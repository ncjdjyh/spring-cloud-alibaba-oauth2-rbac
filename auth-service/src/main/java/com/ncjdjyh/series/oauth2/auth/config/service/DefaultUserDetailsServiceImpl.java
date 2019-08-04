package com.ncjdjyh.series.oauth2.auth.config.service;

import com.google.common.collect.Lists;
import com.ncjdjyh.series.oauth2.auth.service.AuthService;
import com.ncjdjyh.series.oauth2.common.constant.SecurityConstants;
import com.ncjdjyh.series.oauth2.common.entity.TbPermission;
import com.ncjdjyh.series.oauth2.common.entity.TbUser;
import com.ncjdjyh.series.oauth2.common.service.ITbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser user = authService.getUserByUserName(username, SecurityConstants.FROM_IN);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (user != null) {
            List<TbPermission> userPermission = authService.getAllUserAuth(user.getId(), SecurityConstants.FROM_IN);
            userPermission.forEach(p -> {
                if (p != null && p.getUrl() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(p.getUrl());
                    grantedAuthorities.add(grantedAuthority);
                }
            });
        }
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
