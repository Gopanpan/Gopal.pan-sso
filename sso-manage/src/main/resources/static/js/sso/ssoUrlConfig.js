/**
 * 系统访问路径配置
 */
var base_serve_url_config = "https://127.0.0.1:4444";


/**
 * 登陆登出、系统连接相关
 */
var user_login_url = base_serve_url_config + "/loginSysUser";
var user_login_out_url = base_serve_url_config + "/loginOut";
var system_main_url = base_serve_url_config + "/ssoMain";


/**
 * 系统用户url
 * @type {string}
 */
var sysUser_list_url = base_serve_url_config + "/sysUser/systemUserList";
var sysUser_addAUpdate_view_url = base_serve_url_config + "/sysUser/addAUPdateSysUserView";
var sysUser_addAUpdate_url = base_serve_url_config + "/sysUser/addAUPdateSysUser";
var sysUsr_check_unique_loginName = base_serve_url_config + "/sysUser/checkLoginName";
var sysUser_findById_url = base_serve_url_config + "/sysUser/getSystemUserById";
var sysUser_detail_view_url = base_serve_url_config +　"/sysUser/sysUserDetailView";
var sysUser_delete_url = base_serve_url_config + "/sysUser/deleteUser";
var sysUser_download_url = base_serve_url_config + "/sysUser/downloadSysUser";


/**
 * 应用系统用户url
 * @type {string}
 */
var ssoUser_list_url = base_serve_url_config + "/ssoUser/ssoUserList";
var ssoUser_addAUpdate_view_url = base_serve_url_config + "/ssoUser/addAUPdateSsoUserView";
var ssoUser_addAUpdate_url = base_serve_url_config + "/ssoUser/addAUPdateSsoUser";
var ssoUser_delete_url = base_serve_url_config + "/ssoUser/deleteUser";
var ssoUser_findById_url = base_serve_url_config + "/ssoUser/getSsoUserById";
var ssoUser_detail_view_url = base_serve_url_config + "/ssoUser/ssoUserDetailView";
var ssoUsr_check_unique_loginName = base_serve_url_config + "/ssoUser/checkLoginName";


/**
 * 应用系统url
 * @type {string}
 */
var ssoSystem_list_url= base_serve_url_config + "/ssoSystem/ssoSystemList";
var ssoSystem_addAUpdate_view_url = base_serve_url_config + "/ssoSystem/addAUPdateSsoUserSystemView";
var ssoSystem_addAUpdate_url = base_serve_url_config + "/ssoSystem/addAUPdateSsoSystem";
var ssoSystem_findById_url = base_serve_url_config + "/ssoSystem/getSsoSystemById";


