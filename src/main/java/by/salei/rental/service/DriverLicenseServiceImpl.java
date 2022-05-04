package by.salei.rental.service;

import by.salei.rental.entity.DriverLicense;
import by.salei.rental.repo.DriverLicenseRepository;
import by.salei.rental.service.api.DriverLicenseService;
import org.springframework.stereotype.Service;

@Service
public class DriverLicenseServiceImpl extends BaseServiceImpl<DriverLicense, DriverLicenseRepository> implements DriverLicenseService {
}
