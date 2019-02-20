package pl.academy.code.dao.impl;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.academy.code.dao.IOrderDAO;
import pl.academy.code.entities.Order;
import pl.academy.code.services.ISessionFactoryService;

@Component
public class OrderDAOImpl implements IOrderDAO {

    @Autowired
    ISessionFactoryService sessionFactoryService;

    public void persistOrder(Order order) {
        Transaction tx = this.sessionFactoryService.getSession().beginTransaction();
        this.sessionFactoryService.getSession().saveOrUpdate(order);
        tx.commit();
    }

    public Order getOrderById(int id) {
        Transaction tx = this.sessionFactoryService.getSession().beginTransaction();
        Query query = this.sessionFactoryService.getSession()
                .createQuery("FROM pl.academy.code.entities.Order WHERE id = :id");
        query.setParameter("id", id);
        Order o = (Order) query.getSingleResult();
        tx.commit();
        return o;
    }
}
