package by.salei.rental.service.api;

import by.salei.rental.dto.AuthAccountReg;
import by.salei.rental.entity.AuthAccount;
import by.salei.rental.exception.UserAlreadyExist;

public interface AuthAccountService extends BaseService<AuthAccount> {

    void registerNewUser(AuthAccountReg aar) throws UserAlreadyExist;

    AuthAccount updateUser(AuthAccountReg account);

    AuthAccount findUserByLogin(String login);
}
