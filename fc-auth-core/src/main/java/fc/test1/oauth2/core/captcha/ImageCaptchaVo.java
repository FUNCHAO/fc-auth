package fc.test1.oauth2.core.captcha;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
@Data
public class ImageCaptchaVo {
    /**
     * 图片验证码
     */
    private BufferedImage image;
    /**
     *  验证码
     */
    private String code;
    /**
     * 失效时间 这个通常放在缓存中或维护在数据库中
     */
    private LocalDateTime expireTime;

    public ImageCaptchaVo(BufferedImage image, String code, int expireAfterSeconds){
        this.image = image;
        this.code = code;
        //多少秒后
        this.expireTime = LocalDateTime.now().plusSeconds(expireAfterSeconds);
    }

    public ImageCaptchaVo(BufferedImage image, String code, LocalDateTime expireTime){
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     * 是否失效
     * @return
     */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
