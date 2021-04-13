package fc.test1.oauth2.core.captcha.exception;

import org.springframework.security.core.AuthenticationException;

public class CaptchaException extends AuthenticationException {

    public CaptchaException(String msg, Throwable t) {
        super(msg, t);
    }

    public CaptchaException(String msg) {
        super(msg);
    }
}
