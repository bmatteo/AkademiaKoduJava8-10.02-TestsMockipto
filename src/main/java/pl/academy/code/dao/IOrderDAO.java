package pl.academy.code.dao;

import pl.academy.code.entities.Order;

public interface IOrderDAO {
    void persistOrder(Order order);
    Order getOrderById(int id);
}
