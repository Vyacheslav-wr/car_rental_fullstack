package by.salei.rental.repo;

import by.salei.rental.entity.RentalRate;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRateRepository extends JpaSpecificationExecutor<RentalRate>, PagingAndSortingRepository<RentalRate, Integer> {

    @Query(value = "select distinct on (rr.measurements) rr.measurements, rr.id from rental_rate rr", nativeQuery = true)
    List<RentalRate> findDistinctMeasurement();
}
