package com.faustobranco.WebAuthentication;

import javax.sql.DataSource;

import com.faustobranco.WebAuthentication.model.appConfiguration;
import com.faustobranco.WebAuthentication.util.loadConfiguration;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.IOException;

@Configuration
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource getDataSource() throws IOException {
        appConfiguration obj_appConfiguration = loadConfiguration.LoadConfiguration ();

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(obj_appConfiguration.getDb_url ());
        dataSource.setUsername(obj_appConfiguration.getUsername ());
        dataSource.setPassword(obj_appConfiguration.getPassword ());
        return dataSource;
    }
}
