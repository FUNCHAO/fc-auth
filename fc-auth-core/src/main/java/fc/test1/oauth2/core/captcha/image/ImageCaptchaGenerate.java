package fc.test1.oauth2.core.captcha.image;

import com.google.code.kaptcha.Producer;
import fc.test1.oauth2.core.captcha.entity.ImageCaptchaVo;
import fc.test1.oauth2.core.captcha.service.CaptchaGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
@Service
public class ImageCaptchaGenerate implements CaptchaGenerate {
    @Autowired
    private Producer producer;//config bean中配置

    @Override
    public ImageCaptchaVo generate() {
        String code = producer.createText();
        BufferedImage bufferedImage = producer.createImage(code);
        return new ImageCaptchaVo(bufferedImage, code, 60 * 5);//5分钟过期
    }
}
