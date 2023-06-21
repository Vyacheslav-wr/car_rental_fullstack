package by.salei.rental.service.api;

import by.salei.rental.entity.Order;

import java.util.List;

public interface OrderService extends BaseService<Order> {

    Order createOrder(Integer id, Integer rate_id);

    List<Order> getAllUserOrders(Integer id);
}
