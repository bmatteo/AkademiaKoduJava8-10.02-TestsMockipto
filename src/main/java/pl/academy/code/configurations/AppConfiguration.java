package pl.academy.code.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.academy.code.services.ISessionFactoryService;
import pl.academy.code.services.impl.SessionFactoryServiceImpl;

@Configuration
@ComponentScan({"pl.academy.code.services.impl", "pl.academy.code.operations"})
public class AppConfiguration {
}
