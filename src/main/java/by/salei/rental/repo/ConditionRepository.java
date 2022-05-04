package by.salei.rental.repo;

import by.salei.rental.entity.Condition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends CrudRepository<Condition, Integer> {
}
