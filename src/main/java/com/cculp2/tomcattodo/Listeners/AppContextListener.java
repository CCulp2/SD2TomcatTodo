package com.cculp2.tomcattodo.Listeners;

import com.cculp2.tomcattodo.TodoListHibernateRepo;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebListener
public class AppContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        TodoListHibernateRepo repo = new TodoListHibernateRepo(factory);

        sc.setAttribute("repo", repo);
    }

}
