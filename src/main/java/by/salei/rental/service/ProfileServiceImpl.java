package by.salei.rental.service;

import by.salei.rental.entity.Profile;
import by.salei.rental.repo.ProfileRepository;
import by.salei.rental.service.api.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfileServiceImpl extends BaseServiceImpl<Profile, ProfileRepository> implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public ProfileRepository getDefaultRepo() {
        return profileRepository;
    }
}
