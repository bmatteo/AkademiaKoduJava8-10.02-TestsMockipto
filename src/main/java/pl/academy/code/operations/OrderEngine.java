package pl.academy.code.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.academy.code.entities.Order;
import pl.academy.code.entities.Product;
import pl.academy.code.services.IOrderService;
import pl.academy.code.services.IProductService;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderEngine {
    @Autowired
    IOrderService orderService;

    @Autowired
    IProductService productService;

    public Order generateCommonOrder() {
        Order order = new Order();
        order.setCustomerName("Some Company");
        order.setCustomerSurname("z.o.o");

        Product p1 = new Product();
        p1.setName("Mobile Phone");
        p1.setCode("AS6D5F4A6S5DF");
        p1.setPrice(23.32);

        Product p2 = new Product();
        p2.setName("Phone");
        p2.setCode("AS6D5F4A6S5DF");
        p2.setPrice(45.44);

        Product p3 = new Product();
        p3.setName("SIM");
        p3.setCode("AS6D5F4A6S5DF");
        p3.setPrice(11.32);

        Product p4 = new Product();
        p4.setName("LTE");
        p4.setCode("AS6D545433S5DF");
        p4.setPrice(23.32);

        Product p5 = new Product();
        p5.setName("Mobile Access");
        p5.setCode("AS6D5234232225DF");
        p5.setPrice(23.32);

        order.addProduct(p1);
        order.addProduct(p2);
        order.addProduct(p3);
        order.addProduct(p4);
        order.addProduct(p5);

        this.orderService.persistOrder(order);

        this.productService.persistProduct(p1);
        this.productService.persistProduct(p2);
        this.productService.persistProduct(p3);
        this.productService.persistProduct(p4);
        this.productService.persistProduct(p5);

        return order;
    }

    public List<Product> getSpecialProductsFromDb() {
        List<Product> productList = this.productService.getAllProducts();

        List<Product> result = new ArrayList<Product>();
        for (Product p : productList) {
            if(p.getCode().equals("AS6D5F4A6S5DF")) {
                result.add(p);
            }
        }

        if(result.size() == 0) {
            return null;
        } else {
            return result;
        }
    }
}
