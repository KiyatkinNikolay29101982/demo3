package com.example.demo3.listener;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
@WebListener
public class ApplicationServletContextListener implements ServletContextListener {

    private HikariDataSource dataSource;


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        Properties properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HikariConfig config = new HikariConfig();



        config.setUsername(properties.getProperty("db.user"));
        config.setPassword(properties.getProperty("db.password"));
        config.setDriverClassName(properties.getProperty("db.driver-class-name"));
        config.setJdbcUrl(properties.getProperty("db.url"));
        config.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.hikari.max-pool-size")));

        this.dataSource = new HikariDataSource(config);

        servletContext.setAttribute("dataSource", dataSource);

        servletContext.setAttribute("storagePath", properties.getProperty("storage.path"));

    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dataSource.close();
    }
}
