package by.salei.rental.service;

import by.salei.rental.entity.Profile;
import by.salei.rental.repo.ProfileRepository;
import by.salei.rental.service.api.ProfileService;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl extends BaseServiceImpl<Profile, ProfileRepository> implements ProfileService {
}
