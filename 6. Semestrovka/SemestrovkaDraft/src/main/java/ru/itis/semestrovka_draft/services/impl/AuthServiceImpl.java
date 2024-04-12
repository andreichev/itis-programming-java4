package ru.itis.semestrovka_draft.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.semestrovka_draft.dto.RegistrationForm;
import ru.itis.semestrovka_draft.exception.UserAlreadyExistsException;
import ru.itis.semestrovka_draft.model.Role;
import ru.itis.semestrovka_draft.model.User;
import ru.itis.semestrovka_draft.repository.UsersRepository;
import ru.itis.semestrovka_draft.security.UserDetailsImpl;
import ru.itis.semestrovka_draft.services.AuthService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService  {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(RegistrationForm form) throws UserAlreadyExistsException {
        if(usersRepository.existsByUsername(form.getUsername())) {
            throw new UserAlreadyExistsException("AHMEEEEED!");
        }
        User user = User.builder()
                .username(form.getUsername())
                .passwordHash(passwordEncoder.encode(form.getPassword()))
                .role(Role.ROLE_USER)
                .build();
        usersRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = usersRepository.findByUsername(username);
        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("AHMED!!!!");
        }
        User user = optionalUser.get();
        return UserDetailsImpl.builder()
                .username(user.getUsername())
                .password(user.getPasswordHash())
                .roles(List.of(user.getRole()))
                .build();
    }
}
