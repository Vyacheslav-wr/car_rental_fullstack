package by.salei.rental.service;

import by.salei.rental.entity.DataForPurchase;
import by.salei.rental.repo.DataForPurchaseRepository;
import by.salei.rental.service.api.DataForPurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DataForPurchaseServiceImpl extends BaseServiceImpl<DataForPurchase, DataForPurchaseRepository> implements DataForPurchaseService {

    private final DataForPurchaseRepository dataForPurchaseRepository;

    @Override
    public DataForPurchaseRepository getDefaultRepo() {
        return dataForPurchaseRepository;
    }
}
