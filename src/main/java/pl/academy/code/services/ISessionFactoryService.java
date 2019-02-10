package pl.academy.code.services;

import org.hibernate.Session;

public interface ISessionFactoryService {
    Session getSession();
}
