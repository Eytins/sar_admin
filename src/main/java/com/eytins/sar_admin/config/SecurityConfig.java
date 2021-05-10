package com.eytins.sar_admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/7 23:43
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * @param http 基于http协议的Security配置对象。包含所有Security配置逻辑
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/toLogin")
                .loginProcessingUrl("/login")
                .failureForwardUrl("/failure")
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.sendRedirect("/toMain");
                });

        http.logout()
                .logoutSuccessUrl("/toLogin");

        //这个是线性的，前面permitAll之后后面的就不执行:权限高的写后面
        http.authorizeRequests()
                .antMatchers("/**/css/**", "/**/font/**", "/**/images/**", "/**/js/**", "/**/POIAdder/**").permitAll()
                .antMatchers("/toLogin", "/failure").anonymous()
                .anyRequest().authenticated();

        http.csrf().disable();
    }

}
