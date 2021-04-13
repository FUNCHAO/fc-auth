package fc.test1.oauth2.core.captcha.service;

import fc.test1.oauth2.core.captcha.ImageCaptchaVo;

public interface ICaptchaGenerate {
    /**
     * 生成图片验证码
     *
     * @return
     */
    ImageCaptchaVo generate();
}
