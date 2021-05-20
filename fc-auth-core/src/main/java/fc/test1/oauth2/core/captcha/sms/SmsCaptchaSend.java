package fc.test1.oauth2.core.captcha.sms;

/**
 * 短信验证码发送接口
 */
public interface SmsCaptchaSend {
    /**
     * 发送短信验证码
     * @param mobile
     * @param code
     * @return
     */
    boolean sendSms(String mobile,String code);
}
