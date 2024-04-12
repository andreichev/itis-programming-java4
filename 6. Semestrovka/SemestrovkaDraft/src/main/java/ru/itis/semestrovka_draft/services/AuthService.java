package ru.itis.semestrovka_draft.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.itis.semestrovka_draft.dto.RegistrationForm;
import ru.itis.semestrovka_draft.exception.UserAlreadyExistsException;

public interface AuthService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    void register(RegistrationForm form) throws UserAlreadyExistsException;
}
