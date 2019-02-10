package pl.academy.code.services;

import pl.academy.code.entities.Product;

import java.util.List;

public interface IProductService {
    void persistProduct(Product product);
    List<Product> getAllProducts();
}
