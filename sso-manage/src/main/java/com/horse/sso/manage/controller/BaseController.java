package com.horse.sso.manage.controller;

import com.horse.sso.common.enums.ResponseCode;
import com.horse.sso.common.exception.ServiceException;
import com.horse.sso.domain.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @crea : Created by intelliJ IDEA 16.1.3
 * @auth : Gopan
 * @mail : 15923508369@163.com
 * @date : 2017/5/13 10:49
 * @desc :
 */
public class BaseController {

    @Autowired private HttpServletRequest request;


    /**
     * 获取当前登录用户
     * @return
     * @throws ServiceException
     */
    SysUser getCurrentUser() throws ServiceException {
        HttpSession session = request.getSession();
        SysUser currentUser = (SysUser) session.getAttribute("user");
        if(StringUtils.isEmpty(currentUser)){
            throw new ServiceException(ResponseCode.LOGIN_TOME_OUT);
        }
        return currentUser;

    }


    /**
     * 页面传参校验
     * @param result
     * @throws ServiceException
     */
    void checkValid(BindingResult result) throws ServiceException {

        if(result.hasErrors()) {
            StringBuilder sBuilder = new StringBuilder();
            List<ObjectError> allErrors = result.getAllErrors();

            for (ObjectError error:allErrors) {
                sBuilder.append(String.format("%s%s",error.getDefaultMessage(),"<br/>"));
            }
            throw new ServiceException(ResponseCode.CLIENT_PARAM_PARSE_ERROR,sBuilder.toString());
        }
    }
}
