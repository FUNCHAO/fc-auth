package fc.test1.oauth2.core.properties;

import fc.test1.oauth2.core.mode.enums.LoginTypeEnum;

public class BrowserProperties {
    /**
     * 登录页面 不配置默认标准登录界面
     */
    private String loginPage = "/fc-login.html";
    /**
     * 记住我秒数
     * @return
     */
    private int remberMeSeconds=3600;
    /**
     * 跳转类型 默认返回json数据
     */
    private LoginTypeEnum loginType = LoginTypeEnum.JSON;


    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginTypeEnum getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginTypeEnum loginType) {
        this.loginType = loginType;
    }

    public int getRemberMeSeconds() {
        return remberMeSeconds;
    }

    public void setRemberMeSeconds(int remberMeSeconds) {
        this.remberMeSeconds = remberMeSeconds;
    }
}
