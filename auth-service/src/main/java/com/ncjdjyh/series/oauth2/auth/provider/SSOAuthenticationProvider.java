package com.ncjdjyh.series.oauth2.auth.provider;

import com.ncjdjyh.series.oauth2.auth.token.SSOAuthenticationToken;
import lombok.Data;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/13
 * @Description: ~
 */
@Data
public class SSOAuthenticationProvider implements AuthenticationProvider {
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails userDetails = userDetailsService.loadUserByUsername((String) authentication.getPrincipal());
        if (userDetails == null) {
            throw new InternalAuthenticationServiceException("未找到该 token 对应的用户");
        }

        SSOAuthenticationToken authenticationResult = new SSOAuthenticationToken(userDetails, userDetails.getAuthorities());

        authenticationResult.setDetails(authentication.getDetails());

        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (SSOAuthenticationToken.class
                .isAssignableFrom(authentication));
    }
}
