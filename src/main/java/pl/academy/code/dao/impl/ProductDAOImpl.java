package pl.academy.code.dao.impl;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.academy.code.dao.IProductDAO;
import pl.academy.code.entities.Product;
import pl.academy.code.services.ISessionFactoryService;

import java.util.List;

@Component
public class ProductDAOImpl implements IProductDAO {

    @Autowired
    ISessionFactoryService sessionFactoryService;

    public void persistProduct(Product product) {
        Transaction tx = this.sessionFactoryService.getSession().beginTransaction();
        this.sessionFactoryService.getSession().saveOrUpdate(product);
        tx.commit();
    }

    public List<Product> getAllProducts() {
        Transaction tx = this.sessionFactoryService.getSession().beginTransaction();
        Query query = this.sessionFactoryService.getSession()
                .createQuery("FROM pl.academy.code.entities.Product");
        List<Product> result = query.getResultList();
        tx.commit();
        return result;
    }
}
