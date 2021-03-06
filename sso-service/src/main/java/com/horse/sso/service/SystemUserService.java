package com.horse.sso.service;

import com.horse.sso.common.enums.ResponseCode;
import com.horse.sso.common.exception.ServiceException;
import com.horse.sso.common.utils.AESEncryptUtils;
import com.horse.sso.common.utils.IPAddressUtils;
import com.horse.sso.domain.bussinessobject.SystemUserBo;
import com.horse.sso.domain.entity.SysUser;
import com.horse.sso.domain.valueobject.SysUserVo;
import com.horse.sso.mapper.mapperInterface.SysUserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;


/**
 * @crea : Created by intelliJ IDEA 16.1.3
 * @auth : Gopan
 * @mail : 15923508369@163.com
 * @date : 2017/2/6 20:27
 * @desc :
 */

@Service
public class SystemUserService extends BaseService<SysUser>  implements BaseServiceInterface<SysUser,SystemUserBo,SysUser>{


    @Autowired private SysUserMapper sysUserMapper;


    @Transactional
    public SysUser findByLoginName(String loginName, String password, HttpServletRequest request) throws Exception {
        SysUser sysUser = sysUserMapper.findUserByLoginName(loginName);
        if(ObjectUtils.isEmpty(sysUser))
            throw new ServiceException(ResponseCode.LOGIN_USER_MISS);
        if(!sysUser.getAvailable()){
            throw new ServiceException(ResponseCode.LOGIN_USER_NOT_AVAILABLE);
        }
        if(!AESEncryptUtils.aesEncrypt(password).equals(sysUser.getPassword()))
            throw new ServiceException(ResponseCode.LOGIN_PASSWORD_ERR);



        sysUser.setLastIp(IPAddressUtils.getIpAddr(request));
        sysUser.setLastLogin(LocalDateTime.now());
        sysUserMapper.updateByPrimaryKeySelective(sysUser);

        return sysUser;

    }


    @Transactional(readOnly = true)
    public SysUser findByLoginName(String loginName) throws ServiceException  {
        return sysUserMapper.findUserByLoginName(loginName);
    }


    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public int insertOrUpdate(SysUser record, SysUser currentLoginUser) throws Exception {
        SysUser sysUserTemp = verifyEntity(record, currentLoginUser);
        if(StringUtils.isEmpty(sysUserTemp.getId())){
            return sysUserMapper.insert(sysUserTemp);
        }
        else
           return sysUserMapper.updateByPrimaryKeySelective(sysUserTemp);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public int deleteById(Long id) throws ServiceException  {
        return sysUserMapper.deleteByPrimaryKey(id);

    }

    @Override
    @Transactional(readOnly = true)
    public SysUser findById(Long id) throws ServiceException  {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
        SysUser createUser = sysUserMapper.selectByPrimaryKey(sysUser.getCreateUser());
        SysUser updateUser = sysUserMapper.selectByPrimaryKey(sysUser.getUpdateUser());
        SysUserVo sysUserVo = new SysUserVo();

        BeanUtils.copyProperties(sysUser,sysUserVo);
        if(!ObjectUtils.isEmpty(createUser))
            sysUserVo.setCreateUserName(createUser.getLoginName());
        if(!ObjectUtils.isEmpty(updateUser))
            sysUserVo.setUpdateUserName(updateUser.getLoginName());
        return sysUserVo;
    }

    @Override
    public List<SysUser> findListByE(SystemUserBo customBo) throws ServiceException {
        return sysUserMapper.findListByE(customBo);
    }


    @Override
    @Transactional(readOnly = true)
    public PageInfo findPageListByE(SystemUserBo customBo) throws ServiceException  {

        PageHelper.startPage(customBo.getPageIndex(), customBo.getPageSize());
        return new PageInfo<>(sysUserMapper.findListByE(customBo));
    }

    @Override
    public PageInfo findListByT(SysUser entity) throws ServiceException {
        return null;
    }


    @Override
    @Transactional(readOnly = true)
    public PageInfo findPageListByT(SysUser entity) throws ServiceException  {
        return null;
    }


}
