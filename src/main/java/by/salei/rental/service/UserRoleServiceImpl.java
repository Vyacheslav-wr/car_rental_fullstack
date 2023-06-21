package by.salei.rental.service;

import by.salei.rental.entity.UserRole;
import by.salei.rental.repo.UserRoleRepository;
import by.salei.rental.service.api.UserRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, UserRoleRepository> implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Override
    public UserRoleRepository getDefaultRepo() {
        return userRoleRepository;
    }
}
