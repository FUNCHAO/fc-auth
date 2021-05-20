package fc.test1.oauth2.core.captcha.service.impl;

import fc.test1.oauth2.core.captcha.enums.CaptchaTypeEnum;
import fc.test1.oauth2.core.captcha.exception.CaptchaException;
import fc.test1.oauth2.core.captcha.service.CaptchaCreateService;
import fc.test1.oauth2.core.captcha.service.CaptchaProcessor;
import fc.test1.oauth2.core.support.strategy.StrategyContainerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.ServletWebRequest;

@Service
@Slf4j
public class CaptchaCreateServiceImpl implements CaptchaCreateService {
    /**
     * 生成验证码
     *
     * @param request
     * @param type
     */
    @Override
    public void createCaptcha(ServletWebRequest request, String type) {
        CaptchaTypeEnum captchaType=CaptchaTypeEnum.forCode(type);
        if   (type==null){
            throw new CaptchaException("验证码类型不支持");
        }
        try {
            StrategyContainerImpl.getStrategy(CaptchaProcessor.class,captchaType)
                    .create(request);
        } catch (Exception e) {
            log.info("create captcha error....", e);
        }
    }
}
