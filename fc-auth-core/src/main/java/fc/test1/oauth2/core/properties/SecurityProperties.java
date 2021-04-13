package fc.test1.oauth2.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "fc.auth",ignoreInvalidFields = true)
public class SecurityProperties {
    /**
     * 浏览器配置类
     */
    private BrowserProperties browser = new BrowserProperties();

    /**
     * 图片验证码配置类
     */
    private ImageCaptchaProperties imageCaptcha = new ImageCaptchaProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ImageCaptchaProperties getImageCaptcha() {
        return imageCaptcha;
    }

    public void setImageCaptcha(ImageCaptchaProperties imageCaptcha) {
        this.imageCaptcha = imageCaptcha;
    }
}
