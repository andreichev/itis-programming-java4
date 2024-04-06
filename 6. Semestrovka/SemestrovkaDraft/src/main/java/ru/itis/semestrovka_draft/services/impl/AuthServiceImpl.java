package ru.itis.semestrovka_draft.services.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.semestrovka_draft.model.Role;
import ru.itis.semestrovka_draft.security.UserDetailsImpl;
import ru.itis.semestrovka_draft.services.AuthService;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService  {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(!"ahmed".equals(username)) {
            throw new UsernameNotFoundException("AHMED!!!!");
        }
        return UserDetailsImpl.builder()
                .username("Ahmed")
                .password("123123")
                .roles(List.of(Role.ROLE_USER))
                .build();
    }
}
