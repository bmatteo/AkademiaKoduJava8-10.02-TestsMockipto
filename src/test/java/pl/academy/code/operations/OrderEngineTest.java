package pl.academy.code.operations;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.academy.code.configurations.AppConfiguration;
import pl.academy.code.configurations.AppConfigurationTest;
import pl.academy.code.dao.IOrderDAO;
import pl.academy.code.dao.IProductDAO;
import pl.academy.code.entities.Order;
import pl.academy.code.entities.Product;
import pl.academy.code.services.IOrderService;
import pl.academy.code.services.IProductService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigurationTest.class)
public class OrderEngineTest {

    @Autowired
    OrderEngine orderEngine;

    @Autowired
    IProductDAO productDAO;

    @Autowired
    IOrderDAO orderDAO;

    @Test
    public void generateCommonOrderTest() {
        Order order = orderEngine.generateCommonOrder();

        Assert.assertEquals(5, order.getProducts().size());
        Assert.assertEquals("Some Company", order.getCustomerName());

        verify(orderDAO, times(1))
                .persistOrder(Matchers.any(Order.class));

        verify(productDAO, times(5))
                .persistProduct(Matchers.any(Product.class));
    }

    @Test
    public void getSpecialProductsFromDbTest() {
        when(productDAO.getAllProducts()).thenReturn(prepareFakeProductList());

        List<Product> list = orderEngine.getSpecialProductsFromDb();
        Assert.assertEquals(3, list.size());
        Assert.assertEquals("AS6D5F4A6S5DF", list.get(0).getCode());
        Assert.assertEquals("AS6D5F4A6S5DF", list.get(1).getCode());
        Assert.assertEquals("AS6D5F4A6S5DF", list.get(2).getCode());
    }

    private List<Product> prepareFakeProductList() {
        List<Product> result = new ArrayList<Product>();

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

        result.add(p1);
        result.add(p2);
        result.add(p3);
        result.add(p4);
        result.add(p5);

        return result;
    }
}
