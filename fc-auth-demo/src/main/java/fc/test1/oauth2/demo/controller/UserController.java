package fc.test1.oauth2.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
    /**
     *获取用户认证信息
     * @return
     */
    @GetMapping("authentication")
    public Authentication getCurrentAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户认证信息
     * 同getCurrentAuthentication spring 会帮我们注入
     * @param authentication
     * @return
     */
    @GetMapping("authentication/auto")
    public Authentication getCurrentAuthentication2(Authentication authentication){
        return authentication;
    }
}
