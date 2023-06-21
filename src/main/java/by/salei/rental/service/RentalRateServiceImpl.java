package by.salei.rental.service;

import by.salei.rental.entity.RentalRate;
import by.salei.rental.repo.RentalRateRepository;
import by.salei.rental.service.api.RentalRateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentalRateServiceImpl extends BaseServiceImpl<RentalRate, RentalRateRepository> implements RentalRateService {

    private final RentalRateRepository repository;

    @Override
    public RentalRateRepository getDefaultRepo() {
        return repository;
    }
}
