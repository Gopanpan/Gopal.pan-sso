package bing.Pan.sso.manage.controller;

import bing.Pan.sso.common.enums.ResponseCode;
import bing.Pan.sso.common.exception.ServiceException;
import bing.Pan.sso.common.response.Response;
import bing.Pan.sso.domain.bussinessobject.SystemUserAddBo;
import bing.Pan.sso.domain.bussinessobject.SystemUserBo;
import bing.Pan.sso.domain.entity.SysUser;
import bing.Pan.sso.service.SystemUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @crea : Created by intelliJ IDEA 16.1.3
 * @auth : bing.Pan
 * @mail : 15923508369@163.com
 * @date : 2017/2/6 19:23
 * @desc : SSO系统管理用户相关
 */

@Api(value = "SystemUserController", description = "系统用户管理接口")
@RestController
@RequestMapping("/sysUser")
public class SystemUserController extends BaseController{

    @Autowired private SystemUserService systemUserService;

    /**
     * 系统管理用户列表
     * @param systemUserBo
     * @return
     */
    @ApiOperation(value = "系统管理用户列表")
    @RequestMapping(value = "/systemUserList", method = RequestMethod.POST)
    public Object systemUserList(@Valid @ModelAttribute SystemUserBo systemUserBo, BindingResult result) throws ServiceException {
        if(result.hasErrors()){
            throw new ServiceException(ResponseCode.CLIENT_PARAM_ERR);
        }
        return new Response<>(systemUserService.systemUserList(systemUserBo));
    }


    @ApiOperation(value = "根据系统管理用户ID获取详情")
    @RequestMapping(value = "/getSystemUserById", method = RequestMethod.POST)
    public Object getSystemUserById(Long sysUserId) throws ServiceException {
        return new Response<>(systemUserService.getSystemUserById(sysUserId));

    }

    @ApiOperation(value = "添加系统管理员账户")
    @RequestMapping(value = "/addSysUser", method = RequestMethod.POST)
    public Object addSysUser(@Valid @RequestBody SystemUserAddBo userAddBo, BindingResult result) throws Exception {

        if(result.hasErrors())
            throw new ServiceException(ResponseCode.CLIENT_PARAM_ERR);

        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userAddBo,sysUser);
        systemUserService.addAUpdateSysUser(sysUser);

        return new Response<>();

    }

}
