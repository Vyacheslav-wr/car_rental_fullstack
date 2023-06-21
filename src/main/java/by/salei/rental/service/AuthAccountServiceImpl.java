package by.salei.rental.service;

import by.salei.rental.dto.AuthAccountReg;
import by.salei.rental.entity.*;
import by.salei.rental.exception.UserAlreadyExist;
import by.salei.rental.mapper.RegistrationMapper;
import by.salei.rental.repo.AuthAccountRepository;
import by.salei.rental.repo.ProfileRepository;
import by.salei.rental.service.api.AuthAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class AuthAccountServiceImpl extends BaseServiceImpl<AuthAccount, AuthAccountRepository> implements AuthAccountService {

    private final AuthAccountRepository authAccountRepository;
    private final ProfileRepository profileRepository;
    private final RegistrationMapper mapper;
    private final PasswordEncoder encoder;

    @Override
    public void registerNewUser(AuthAccountReg aar) throws UserAlreadyExist {
        AuthAccount aa = mapper.convertToAuthAccount(aar);
        aa.setPassword(encoder.encode(aa.getPassword()));
        Profile profile = mapper.convertToProfile(aar);
        aa.setProfile(profile);
        aa.setStatus(AccountStatus.APPROVED);
        aa.setRole(new UserRole(UserRoleType.USER));

        if(authAccountRepository.findByLogin(aa.getLogin()) != null) {
            throw new UserAlreadyExist("User " + aar.getUsername() + " already exists");
        }

        authAccountRepository.save(aa);
        profileRepository.save(profile);
    }

    @Override
    public AuthAccount updateUser(AuthAccountReg account) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        AuthAccount aa = authAccountRepository.findByLogin(userName);

        Profile p = aa.getProfile();

        if(account.getPassword() != null) {
            aa.setPassword(encoder.encode(account.getPassword()));
        }
        p.setFirstName(account.getFirstName());
        p.setLastName(account.getLastName());
        p.setMiddleName(account.getMiddleName());
        p.setPhoneNumber(account.getPhoneNumber());

        aa.setLogin(account.getUsername());
        aa.setEmail(account.getEmail());
        aa.setProfile(p);
        authAccountRepository.save(aa);
        return aa;
    }

    @Override
    public AuthAccount findUserByLogin(String login) {

        AuthAccount authAccount = authAccountRepository.findByLogin(login);

        if(authAccount == null) {
            throw new EntityNotFoundException(String.format("Пользователь: %s не был найден", login));
        }

        return authAccount;
    }

    @Override
    public AuthAccountRepository getDefaultRepo() {
        return authAccountRepository;
    }
}
