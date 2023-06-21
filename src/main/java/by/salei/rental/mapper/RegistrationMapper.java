package by.salei.rental.mapper;

import by.salei.rental.dto.AuthAccountReg;
import by.salei.rental.entity.AuthAccount;
import by.salei.rental.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RegistrationMapper {

    @Mapping(source = "username", target = "login")
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "password", target = "password", qualifiedByName = "verifyPassword")
    AuthAccount convertToAuthAccount(AuthAccountReg aar);

    Profile convertToProfile(AuthAccountReg aar);

    Profile mergeProfiles(@MappingTarget Profile targetProfile, Profile sourceProfile);

    AuthAccount mergeAuthAccount(@MappingTarget AuthAccount targetAuthAccount, AuthAccount sourceAuthAcocunt);

    @Named("verifyPassword")
    default String verifyPassword(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(password != null) {
            return passwordEncoder.encode(password);
        }
        return null;
    }
}
