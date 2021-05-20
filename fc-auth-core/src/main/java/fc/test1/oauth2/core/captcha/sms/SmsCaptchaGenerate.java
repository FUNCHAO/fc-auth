package fc.test1.oauth2.core.captcha.sms;

import fc.test1.oauth2.core.captcha.entity.CaptchaVo;
import fc.test1.oauth2.core.captcha.service.CaptchaGenerate;
import fc.test1.oauth2.core.properties.SecurityProperties;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsCaptchaGenerate implements CaptchaGenerate {

    @Autowired
    private SecurityProperties securityProperties;
    /**
     * 生成短信验证码
     *
     * @return
     */
    @Override
    public CaptchaVo generate() {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCaptcha().getSms().getLength());
        return new CaptchaVo(code, securityProperties.getCaptcha().getSms().getExpireSeconds());
    }

}
