package pl.academy.code.services.impl;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.academy.code.dao.IProductDAO;
import pl.academy.code.entities.Product;
import pl.academy.code.services.IProductService;
import pl.academy.code.services.ISessionFactoryService;

import java.util.List;

@Component
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductDAO productDAO;

    public void persistProduct(Product product) {
        productDAO.persistProduct(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }
}
