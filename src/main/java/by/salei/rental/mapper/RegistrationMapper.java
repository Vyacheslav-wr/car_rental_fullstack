package by.salei.rental.mapper;

import by.salei.rental.dto.AuthAccountReg;
import by.salei.rental.entity.AuthAccount;
import by.salei.rental.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RegistrationMapper {

    @Mapping(source = "username", target = "login")
    AuthAccount convertToAuthAccount(AuthAccountReg aar);

    Profile convertToProfile(AuthAccountReg aar);
}
