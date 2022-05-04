package by.salei.rental.repo;

import by.salei.rental.entity.RentalRate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRateRepository extends CrudRepository<RentalRate, Integer> {
}
