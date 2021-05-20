package fc.test1.oauth2.core.captcha.service;

import org.springframework.web.context.request.ServletWebRequest;

public interface CaptchaCreateService {
    /**
     *  生成验证码
     * @param request
     * @param type
     */
    void createCaptcha(ServletWebRequest request, String type);
}
