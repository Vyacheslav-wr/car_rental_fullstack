package by.salei.rental.service;

import by.salei.rental.entity.UserRole;
import by.salei.rental.repo.UserRoleRepository;
import by.salei.rental.service.api.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, UserRoleRepository> implements UserRoleService {
}
