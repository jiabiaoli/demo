package com.example.security.adapter;

import com.example.security.handler.SecurityAuthenticationFailureHandler;
import com.example.security.handler.SecurityAuthenticationSuccessHandler;
import com.example.security.handler.logout.SecurityLogoutSuccessHandler;
import com.example.security.priorities.SecurityProperties;
import com.example.security.userdetails.PasswordEncoderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @author jiabiaoli
 */
@Configuration
public class SecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private SecurityAuthenticationSuccessHandler securityAuthenticationSuccessHandler;
    @Autowired
    private SecurityAuthenticationFailureHandler securityAuthenticationFailureHandler;
    @Autowired
    private SecurityLogoutSuccessHandler securityLogoutSuccessHandler;
    @Autowired
    private UserDetailsService securityUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PasswordEncoderImpl();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        http.addFilterBefore(encodingFilter, CsrfFilter.class);
        http.formLogin()
                .loginPage(securityProperties.getLoginPage())
                .failureUrl(securityProperties.getFailureUrl())
                .loginProcessingUrl(securityProperties.getLoginProcessingUrl())
                .successHandler(securityAuthenticationSuccessHandler)
                .failureHandler(securityAuthenticationFailureHandler)
                .and()
                .logout()
                .logoutUrl(securityProperties.getLogoutUrl())
                .logoutSuccessUrl(securityProperties.getLoginPage())
                .permitAll()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(securityLogoutSuccessHandler)
                .and()
                .authorizeRequests()
                .antMatchers(securityProperties.getMatchers())
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //  .rememberMe()
                //            .tokenRepository(persistentTokenRepository())
                //            .tokenValiditySeconds(securityProperties.ngetRememberSeconds())
                .userDetailsService(securityUserDetailsService)
                //  .and()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .csrf()
                .disable();
    }
}
