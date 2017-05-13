package bing.Pan.sso.manage.controller;

import bing.Pan.sso.common.exception.ServiceException;
import bing.Pan.sso.common.response.Response;
import bing.Pan.sso.domain.entity.SysUser;
import bing.Pan.sso.service.SystemUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @crea :Created by intelliJ IDEA 16.1.3
 * @auth :bing.Pan 15923508369@163.com
 * @date :2017/1/17 18:58
 * @desc :
 */

@Api(value = "LoginController", description = "登录、登出")
@Controller
public class LoginController extends BaseController {

    @Autowired SystemUserService systemUserService;

    /**
     * 登陆
     * @param loginName 登陆名
     * @param password  密码
     * @return
     */
    @ApiOperation(value = "登陆", notes = "系统管理员登陆接口", response = Response.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "loginName", value = "登陆名", required = true, dataType = "Long", paramType = "query"),
        @ApiImplicitParam(name = "password", value = "MD5加密后的密码", required = true, dataType = "Long", paramType = "query")
    })
    @RequestMapping(value = "/loginSysUser", method = RequestMethod.POST)
    @ResponseBody
    public Object loginSysUser(@RequestParam(required = true)  String loginName,
                               @RequestParam(required = true)  String password,
                               HttpServletRequest request) throws ServiceException {

        SysUser byLoginName = systemUserService.findUserByLoginName(loginName, password);
        request.getSession().setAttribute("user",byLoginName);
        return new Response();


    }


}
