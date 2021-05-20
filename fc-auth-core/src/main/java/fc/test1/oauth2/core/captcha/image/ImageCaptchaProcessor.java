package fc.test1.oauth2.core.captcha.image;

import fc.test1.oauth2.core.captcha.entity.ImageCaptchaVo;
import fc.test1.oauth2.core.captcha.enums.CaptchaTypeEnum;
import fc.test1.oauth2.core.captcha.service.AbstractCaptchaProcessor;
import fc.test1.oauth2.core.captcha.service.CaptchaGenerate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
@Slf4j
public class ImageCaptchaProcessor extends AbstractCaptchaProcessor<ImageCaptchaVo> {
    private static final String FORMAT_NAME = "JPEG";

    @Autowired
    private CaptchaGenerate imageCaptchaGenerate;

    /**
     * 获得策略条件
     *
     * @return 用来注册的策略处理条件
     */
    @Override
    public CaptchaTypeEnum getCondition() {
        return CaptchaTypeEnum.IMAGE;
    }

    @Override
    protected ImageCaptchaVo generateCaptcha(ServletWebRequest request) {
        return (ImageCaptchaVo) imageCaptchaGenerate.generate();
    }

    @Override
    protected void send(ServletWebRequest request, ImageCaptchaVo captcha) throws IOException {
        HttpServletResponse response=request.getResponse();
        response.setHeader("Cache-Control", "no-store, no-cache");// 没有缓存
        response.setContentType("image/jpeg");
        ImageIO.write(captcha.getImage(), FORMAT_NAME, response.getOutputStream());

    }
}
