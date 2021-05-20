package fc.test1.oauth2.core.captcha.service;

import fc.test1.oauth2.core.captcha.entity.CaptchaVo;

/**
 * 验证码生成接口
 */
public interface CaptchaGenerate {
    /**
     * 生成验证码
     *
     * @return
     */
    CaptchaVo generate();
}
