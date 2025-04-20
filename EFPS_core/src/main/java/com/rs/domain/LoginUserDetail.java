package com.rs.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rs.domain.Emp;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @FileName: LoginUserDetail
 * @Date: 2024/8/7:22:03
 * @Description:
 * @Author: RWG
 */
@Data
@NoArgsConstructor
@ApiModel(value = "登录用户详情实体")
public class LoginUserDetail implements UserDetails {
    private List<String> list;
    private Emp emp;

    public LoginUserDetail(Emp emp, List<String> list) {
        this.emp = emp;
        this.list = list;
    }

    // 自定义一个权限列表集合
    @JSONField(serialize = false)
    List<SimpleGrantedAuthority> authorities;

    // 权限
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities != null) {
            return authorities;
        }
        authorities = new ArrayList<>();
        for (String item : list) {
            authorities.add(new SimpleGrantedAuthority(item));
        }
        return authorities;
    }

    // 密码
    @Override
    @JsonIgnore
    public String getPassword() {
        return emp.getePassword();
    }

    // 账号
    @Override
    public String getUsername() {
        return emp.geteUsername();
    }

    // 账号是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账号是否锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 密码是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 账号是否可用
    @Override
    public boolean isEnabled() {
        return true;
    }


}
