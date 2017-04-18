package bing.Pan.sso.domain.bussinessobject;

import bing.Pan.sso.domain.valueobject.BaseVo;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @crea : Created by intelliJ IDEA 16.1.3
 * @auth : bing.Pan
 * @mail : 15923508369@163.com
 * @date : 2017/2/6 19:46
 * @desc :
 */
public class SystemUserBo extends PageBo {



    @ApiModelProperty("登录名")
    private String loginName;

    @ApiModelProperty("真实名称")
    private String realName;

    @ApiModelProperty("电话号码")
    private String phone;



    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
