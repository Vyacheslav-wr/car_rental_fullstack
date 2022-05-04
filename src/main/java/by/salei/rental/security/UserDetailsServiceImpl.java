package by.salei.rental.security;

import by.salei.rental.entity.AuthAccount;
import by.salei.rental.repo.AuthAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AuthAccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthAccount authAccount = Optional.ofNullable(repository.findByLogin(username))
                .orElseThrow(() -> new UsernameNotFoundException("Incorrect name or password"));

        return User.builder()
                .username(authAccount.getLogin())
                .password(authAccount.getPassword())
                .authorities(authAccount.getRole().getRole().toString())
                .build();
    }
}
