package by.salei.rental.service;

import by.salei.rental.entity.DriverLicense;
import by.salei.rental.repo.DriverLicenseRepository;
import by.salei.rental.service.api.DriverLicenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DriverLicenseServiceImpl extends BaseServiceImpl<DriverLicense, DriverLicenseRepository> implements DriverLicenseService {

    private final DriverLicenseRepository driverLicenseRepository;
    @Override
    public DriverLicenseRepository getDefaultRepo() {
        return driverLicenseRepository;
    }
}
