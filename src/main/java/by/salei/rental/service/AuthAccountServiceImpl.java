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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

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
}
