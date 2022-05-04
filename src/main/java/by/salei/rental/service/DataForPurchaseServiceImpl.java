package by.salei.rental.service;

import by.salei.rental.entity.DataForPurchase;
import by.salei.rental.repo.DataForPurchaseRepository;
import by.salei.rental.service.api.DataForPurchaseService;
import org.springframework.stereotype.Service;

@Service
public class DataForPurchaseServiceImpl extends BaseServiceImpl<DataForPurchase, DataForPurchaseRepository> implements DataForPurchaseService {
}
