package fc.test1.oauth2.core.captcha.sms;

import fc.test1.oauth2.core.captcha.entity.CaptchaVo;
import fc.test1.oauth2.core.captcha.enums.CaptchaTypeEnum;
import fc.test1.oauth2.core.captcha.service.AbstractCaptchaProcessor;
import fc.test1.oauth2.core.captcha.service.CaptchaGenerate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

@Service
@Slf4j
public class SmsCaptchaProcessor extends AbstractCaptchaProcessor<CaptchaVo> {

    @Autowired
    private CaptchaGenerate smsCaptchaGenerate;
    @Autowired
    private SmsCaptchaSend captchaSend;

    /**
     * 获得策略条件
     *
     * @return 用来注册的策略处理条件
     */
    @Override
    public CaptchaTypeEnum getCondition() {
        return CaptchaTypeEnum.SMS;
    }

    @Override
    protected CaptchaVo generateCaptcha(ServletWebRequest request) {
        return smsCaptchaGenerate.generate();
    }

    @Override
    protected void send(ServletWebRequest request, CaptchaVo captcha) throws ServletRequestBindingException {
        String mobile= ServletRequestUtils.getRequiredStringParameter(request.getRequest(),"mobile");
        captchaSend.sendSms(mobile, captcha.getCode());
    }
}
