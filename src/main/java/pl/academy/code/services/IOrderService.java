package pl.academy.code.services;

import pl.academy.code.entities.Order;

public interface IOrderService {
    void persistOrder(Order order);
    Order getOrderById(int id);
}
