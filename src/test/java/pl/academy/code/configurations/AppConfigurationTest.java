package pl.academy.code.configurations;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.academy.code.services.IOrderService;
import pl.academy.code.services.IProductService;

@Configuration
@ComponentScan("pl.academy.code.operations")
public class AppConfigurationTest {
    @Bean
    public IProductService productService() {
        return Mockito.mock(IProductService.class);
    }

    @Bean
    public IOrderService orderService() {
        return Mockito.mock(IOrderService.class);
    }
}
