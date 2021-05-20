package fc.test1.oauth2.core.captcha;

import fc.test1.oauth2.core.captcha.service.CaptchaCreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class CaptchaController {
//    public static final String CAPTCHA_SESSION_KEY = "image_captcha_session_key";
//    private static final String FORMAT_NAME = "JPEG";

//    @Autowired
//    private ICaptchaGenerate imageCaptchaGenerate;
//    //spring session 工具类
//    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
//    @Autowired
//    private CaptchaGenerate smsCaptchaGenerate;
//    @Autowired
//    private SmsCaptchaSend smsCaptchaSend;
    @Autowired
    private CaptchaCreateService captchaCreateService;
//    /**
//     * 获取图片验证码
//     *
//     * @param request
//     * @param response
//     * @throws IOException
//     */
//    @GetMapping("/captcha/image")
//    public void createKaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        //1.接口生成验证码
//        ImageCaptchaVo imageCaptcha = imageCaptchaGenerate.generate();
//        //2.保存到session中
//        sessionStrategy.setAttribute(new ServletWebRequest(request), CAPTCHA_SESSION_KEY, imageCaptcha);
//        //3.写到响应流中
//        response.setHeader("Cache-Control", "no-store, no-cache");// 没有缓存
//        response.setContentType("image/jpeg");
//        ImageIO.write(imageCaptcha.getImage(), FORMAT_NAME, response.getOutputStream());
//    }
//
//    /**
//     * 获取短信验证码
//     *
//     * @param request
//     * @param response
//     * @throws IOException
//     */
//    @GetMapping("/captcha/sms")
//    public void createSms(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
//        log.info("获取短信验证码");
//        //1.获取短信验证码
//        CaptchaVo captchaVo = smsCaptchaGenerate.generate();
//        //2.保存到session中
//        sessionStrategy.setAttribute(new ServletWebRequest(request), CAPTCHA_SESSION_KEY + "sms", captchaVo);
//        //3.发送
//        String mobile = ServletRequestUtils.getRequiredStringParameter(request, "mobile");
//        smsCaptchaSend.sendSms(mobile, captchaVo.getCode());
//    }
    @GetMapping("/captcha/{type}")
    public void createCaptcha(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
        log.info("获取验证码开始");
        captchaCreateService.createCaptcha(new ServletWebRequest(request, response), type);
        log.info("获取验证码结束");
    }
}
