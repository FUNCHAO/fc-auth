package fc.test1.oauth2.core.captcha.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CaptchaVo {
    /**
     * 验证码
     */
    private String code;
    /**
     * 失效时间 这个通常放在缓存中或维护在数据库中
     */
    private LocalDateTime expireTime;
    public CaptchaVo (){

    }
    public CaptchaVo(String code, int expireAfterSeconds) {
        this.code = code;
        //多少秒后
        this.expireTime = LocalDateTime.now().plusSeconds(expireAfterSeconds);
    }

    public CaptchaVo(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }
    /**
     * 是否失效
     *
     * @return
     */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
