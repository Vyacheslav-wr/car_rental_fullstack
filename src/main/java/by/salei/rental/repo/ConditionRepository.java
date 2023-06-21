package by.salei.rental.repo;

import by.salei.rental.entity.Car;
import by.salei.rental.entity.Condition;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaSpecificationExecutor<Condition>, PagingAndSortingRepository<Condition, Integer> {
}
