package fc.test1.oauth2.core.captcha.service;

import fc.test1.oauth2.core.captcha.enums.CaptchaTypeEnum;
import fc.test1.oauth2.core.support.strategy.IStrategy;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码处理器接口
 */
public interface CaptchaProcessor extends IStrategy<CaptchaTypeEnum> {
    /**
     * 验证码
     */
    String CAPTCHA_SESSION_KEY="captcha_session_key_";
    /**
     * 创建验证码
     * @param request 封装请求和响应
     * @throws Exception
     */
    void create(ServletWebRequest request) throws  Exception;
}
