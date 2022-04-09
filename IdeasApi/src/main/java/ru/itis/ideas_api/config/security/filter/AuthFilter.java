package ru.itis.ideas_api.config.security.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.ideas_api.model.Role;
import ru.itis.ideas_api.model.User;
import ru.itis.ideas_api.repository.UsersRepository;

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

    private final UsersRepository usersRepository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String token = getTokenFromRequest((HttpServletRequest) servletRequest);
        if (token != null) {
            Optional<User> optionalUser = usersRepository.findByToken(token);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                Collection<? extends GrantedAuthority> authorities = Collections.singleton(Role.ROLE_USER);
                Authentication auth = new UsernamePasswordAuthenticationToken(user, user.getToken(), authorities);
                securityContext = SecurityContextHolder.getContext();
                securityContext.setAuthentication(auth);
//                HttpSession session = ((HttpServletRequest) servletRequest).getSession(true);
//                session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, securityContext);
            } else {
                securityContext.setAuthentication(null);
            }
        } else {
            SecurityContextHolder.getContext().setAuthentication(null);
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
