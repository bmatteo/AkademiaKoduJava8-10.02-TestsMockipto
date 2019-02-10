package pl.academy.code;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.academy.code.configurations.AppConfiguration;
import pl.academy.code.operations.OrderEngine;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);
        OrderEngine orderEngine = context.getBean(OrderEngine.class);

        orderEngine.generateCommonOrder();
    }
}
