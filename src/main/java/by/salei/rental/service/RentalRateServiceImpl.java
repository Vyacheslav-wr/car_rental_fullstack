package by.salei.rental.service;

import by.salei.rental.entity.RentalRate;
import by.salei.rental.repo.RentalRateRepository;
import by.salei.rental.service.api.RentalRateService;
import org.springframework.stereotype.Service;

@Service
public class RentalRateServiceImpl extends BaseServiceImpl<RentalRate, RentalRateRepository> implements RentalRateService {
}
