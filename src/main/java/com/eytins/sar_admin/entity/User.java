package com.eytins.sar_admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Description 用户实体类
 * @Author Eytins
 * @Create 2021/5/9 17:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    private long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String description;
    /**
     * 在数据库中是使用逗号分隔的
     */
    private String roles;

    /**
     * 在SpringSecurity框架中所需的authorities格式，是上面roles分割出来的单体
     */
    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
