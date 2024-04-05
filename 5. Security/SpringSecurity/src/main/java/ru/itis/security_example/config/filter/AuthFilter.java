package ru.itis.security_example.config.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.security_example.dto.UserDto;
import ru.itis.security_example.model.Role;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import static org.springframework.util.StringUtils.hasText;

@Component
@RequiredArgsConstructor
public class AuthFilter extends GenericFilterBean {
    private static final String TOKEN = "613daffa-d1d0-4296-8b1d-2fd1856f1e9e";
    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer ";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = getTokenFromRequest((HttpServletRequest) servletRequest);
        if (TOKEN.equals(token)) {
            Collection<? extends GrantedAuthority> authorities = Collections.singleton(Role.ROLE_ADMIN);
            UserDto userDto = UserDto.builder()
                    .name("Oleg")
                    .age(20)
                    .build();
            Authentication auth = new UsernamePasswordAuthenticationToken(userDto, token, authorities);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Nullable
    private static String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);
        if (hasText(bearer) && bearer.startsWith(BEARER)) {
            return bearer.substring(BEARER.length());
        }
        return null;
    }
}
