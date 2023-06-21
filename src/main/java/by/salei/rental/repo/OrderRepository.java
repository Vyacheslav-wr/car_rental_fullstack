package by.salei.rental.repo;

import by.salei.rental.entity.Order;
import by.salei.rental.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaSpecificationExecutor<Order>, PagingAndSortingRepository<Order, Integer> {

    List<Order> findAllByAuthAccountId(Integer id);
    List<Order> findAllByAuthAccountIdAndStatus(Integer id, OrderStatus status);

    List<Order> findAllByAuthAccountIdAndStatusIn(Integer id, List<OrderStatus> statusList);
}
