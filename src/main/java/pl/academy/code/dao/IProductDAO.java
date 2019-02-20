package pl.academy.code.dao;

import pl.academy.code.entities.Product;

import java.util.List;

public interface IProductDAO {
    void persistProduct(Product product);
    List<Product> getAllProducts();
}
