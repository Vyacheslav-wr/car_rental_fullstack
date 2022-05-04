package by.salei.rental.repo;

import by.salei.rental.entity.DataForPurchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataForPurchaseRepository extends CrudRepository<DataForPurchase, Integer> {
}
