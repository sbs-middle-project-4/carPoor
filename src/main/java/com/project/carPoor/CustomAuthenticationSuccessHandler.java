package com.project.carPoor;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        if (authentication != null && authentication.getAuthorities() != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

            // 권한에 따른 URL 설정
            if (authorities.stream().anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"))) {
                setDefaultTargetUrl("/member/admin");
            } else {
                setDefaultTargetUrl("/member/showMemberInfo");
            }
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
