package com.example.security.priorities;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiabiaoli
 */
@ConfigurationProperties(prefix = "demo.security")
@Configuration
@Data
public class SecurityProperties {
    private String loginPage = "/auth/toLogin";
    private String failureUrl = "/auth/login?error=true";
    private String loginProcessingUrl = "/auth/login";
    private String logoutUrl = "/auth/logout";
    private String[] matchers = new String[]{"/auth/requrie",
            "/js/**",
            "/iview/**",
            "/css/**",
            "/auth/toLogin",
            "/auth/logout",
            "/images/**",
            "/api/**",
            "/auth/token"
    };
    // 默认登录页
    private String loginPageHtml = "signin";


    private int rememberSeconds = 3600*24*7;
}
