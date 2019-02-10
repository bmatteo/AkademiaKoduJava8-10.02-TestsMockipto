package pl.academy.code.services.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.spi.SessionFactoryBuilderFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import pl.academy.code.services.ISessionFactoryService;

@Component
public class SessionFactoryServiceImpl implements ISessionFactoryService {

    private SessionFactory sessionFactory;

    public SessionFactoryServiceImpl() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
