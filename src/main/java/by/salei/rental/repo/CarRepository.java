package by.salei.rental.repo;

import by.salei.rental.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

    @Query(value = "select distinct on (c.mark) c.mark, c.id, c.mileage, c.booster, c.charger," +
            " c.toning, c.cooler, c.status, c.back_camera, c.climate_control, c.car_type from car c", nativeQuery = true)
    List<Car> findDistinctByMark();

    List<Car> findAllByStatus( String status);
}
