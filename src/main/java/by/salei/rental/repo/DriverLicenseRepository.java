package by.salei.rental.repo;

import by.salei.rental.entity.DriverLicense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverLicenseRepository extends CrudRepository<DriverLicense, Integer> {
}
