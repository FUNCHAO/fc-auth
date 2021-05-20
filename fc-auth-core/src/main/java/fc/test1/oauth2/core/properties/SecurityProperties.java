package fc.test1.oauth2.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "fc.auth",ignoreInvalidFields = true)
public class SecurityProperties {
    /**
     * 浏览器配置类
     */
    private BrowserProperties browser = new BrowserProperties();

    /**
     * 验证码配置类
     */
    private CaptchaProperties captcha = new CaptchaProperties();
    /**
     * 短信验证码配置类
     */
    private SmsCaptchaProperties sms =new SmsCaptchaProperties();

    public SmsCaptchaProperties getSms() {
        return sms;
    }

    public void setSms(SmsCaptchaProperties sms) {
        this.sms = sms;
    }

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public CaptchaProperties getCaptcha() {
        return captcha;
    }

    public void setCaptcha(CaptchaProperties captcha) {
        this.captcha = captcha;
    }
}
