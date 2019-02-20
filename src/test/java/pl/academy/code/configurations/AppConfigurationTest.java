package pl.academy.code.configurations;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.academy.code.dao.IOrderDAO;
import pl.academy.code.dao.IProductDAO;
import pl.academy.code.services.IOrderService;
import pl.academy.code.services.IProductService;

@Configuration
@ComponentScan({"pl.academy.code.operations",
        "pl.academy.code.services.impl"})
public class AppConfigurationTest {
    @Bean
    IProductDAO productDAO() {
        return Mockito.mock(IProductDAO.class);
    }

    @Bean
    IOrderDAO orderDAO() {
        return Mockito.mock(IOrderDAO.class);
    }
}
