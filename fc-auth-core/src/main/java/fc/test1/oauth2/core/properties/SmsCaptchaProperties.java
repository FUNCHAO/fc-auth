package fc.test1.oauth2.core.properties;

/**
 * 短信验证码配置类
 */
public class SmsCaptchaProperties {
    /**
     * 长度
     */
    private int length=6;
    /**
     * 过期秒数 默认3分钟
     */
    private int expireSeconds=180;
    private String interceptUrl;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getInterceptUrl() {
        return interceptUrl;
    }

    public void setInterceptUrl(String interceptUrl) {
        this.interceptUrl = interceptUrl;
    }
}
