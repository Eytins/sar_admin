package com.eytins.sar_admin.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Description
 * @Author Eytins
 * @Create 2021/5/7 23:43
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *
     * @param http 基于http协议的Security配置对象。包含所有Security配置逻辑
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/toLogin");
        /**
         * todo
         * .successHandler(实现AuthenticationSuccessHandler)
         * 登录失败P6
         */

        //这个是线性的，前面permitAll之后后面的就不执行:权限高的写后面
        http.authorizeRequests()
                .antMatchers("/toLogin").permitAll()
                .anyRequest().authenticated();


        http.csrf().disable();
    }
}
