package by.salei.rental.repo;

import by.salei.rental.entity.DriverLicense;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverLicenseRepository extends JpaSpecificationExecutor<DriverLicense>, PagingAndSortingRepository<DriverLicense, Integer> {
}
