package pl.academy.code.services.impl;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.academy.code.dao.IOrderDAO;
import pl.academy.code.dao.IProductDAO;
import pl.academy.code.entities.Order;
import pl.academy.code.entities.Product;
import pl.academy.code.services.IOrderService;
import pl.academy.code.services.ISessionFactoryService;

@Component
public class OrderServiceImpl implements IOrderService {

    @Autowired
    IOrderDAO orderDAO;

    @Autowired
    IProductDAO productDAO;

    public void persistOrder(Order order) {
        orderDAO.persistOrder(order);

        for(Product p : order.getProducts()) {
            productDAO.persistProduct(p);
        }
    }

    public Order getOrderById(int id) {
        return orderDAO.getOrderById(id);
    }
}
