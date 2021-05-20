package fc.test1.oauth2.core.captcha.entity;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
@Data
public class ImageCaptchaVo extends CaptchaVo {

    /**
     * 图片验证码
     */
    private BufferedImage image;
    public ImageCaptchaVo (){

    }
    public ImageCaptchaVo(BufferedImage image, String code, int expireAfterSeconds) {
        super(code, expireAfterSeconds);
        this.image = image;
    }

    public ImageCaptchaVo(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }
}
