package ru.itis.u_mishi.shop.config.security.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.u_mishi.shop.model.Role;
import ru.itis.u_mishi.shop.model.User;
import ru.itis.u_mishi.shop.repository.UserRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static org.springframework.util.StringUtils.hasText;

@Component
@RequiredArgsConstructor
public class AuthFilter extends GenericFilterBean {
    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer ";

    private final JwtHelper jwtHelper;
    private final UserRepository usersRepository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = getTokenFromRequest((HttpServletRequest) servletRequest);
        if (token == null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if(jwtHelper.validateToken(token) == false) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String id = jwtHelper.getIdFromToken(token);
        Optional<User> optionalUser = usersRepository.findById(Integer.parseInt(id));
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Collection<GrantedAuthority> authorities = Collections.singleton(Role.ROLE_USER);
            Authentication auth = new UsernamePasswordAuthenticationToken(user, null, authorities);
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
