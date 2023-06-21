package by.salei.rental.repo;

import by.salei.rental.entity.Car;
import by.salei.rental.entity.DataForPurchase;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataForPurchaseRepository extends JpaSpecificationExecutor<DataForPurchase>, PagingAndSortingRepository<DataForPurchase, Integer> {
}
