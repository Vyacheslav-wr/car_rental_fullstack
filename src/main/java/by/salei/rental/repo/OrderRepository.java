package by.salei.rental.repo;

import by.salei.rental.entity.Order;
import by.salei.rental.entity.OrderStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findAllByAuthAccountId(Integer id);
    List<Order> findAllByAuthAccountIdAndStatus(Integer id, OrderStatus status);
}
