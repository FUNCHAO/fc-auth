package fc.test1.oauth2.browser.config;

import fc.test1.oauth2.core.authentication.FcAuthenticationFailureHandler;
import fc.test1.oauth2.core.authentication.FcAuthenticationSuccessHandler;
import fc.test1.oauth2.core.captcha.filter.CaptchaFilter;
import fc.test1.oauth2.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private FcAuthenticationFailureHandler fcAuthenticationFailureHandler;
    @Autowired
    private FcAuthenticationSuccessHandler fcAuthenticationSuccessHandler;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsService myUserDetailServiceImpl;

    /**
     * 密码加密解密
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //加入图片验证码过滤器
        CaptchaFilter captchaFilter = new CaptchaFilter();
        captchaFilter.setFailureHandler(fcAuthenticationFailureHandler);
        captchaFilter.setSecurityProperties(securityProperties);
        captchaFilter.afterPropertiesSet();
        //图片验证码放在认证之前
        http.addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/authentication/require")//自定义登录请求
//                .loginPage(securityProperties.getBrowser().getLoginPage())//自定义登录请求
                 .loginProcessingUrl("/authentication/form")//自定义登录表单请求
                .successHandler(fcAuthenticationSuccessHandler)
                .failureHandler(fcAuthenticationFailureHandler)
                .and()
//                记住我相关配置
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRemberMeSeconds())
                .userDetailsService(myUserDetailServiceImpl)
                .and()
                .authorizeRequests()
                .antMatchers(securityProperties.getBrowser().getLoginPage(),
                        "/authentication/require", "/captcha/image")//此路径放行 否则会陷入死循环
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()//跨域关闭
        ;
    }

    /**
     * 记住我持久化数据源
     * JdbcTokenRepositoryImpl  CREATE_TABLE_SQL 建表语句可以先在数据库中执行
     *
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //第一次会执行CREATE_TABLE_SQL建表语句 后续会报错 可以关掉
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }
}