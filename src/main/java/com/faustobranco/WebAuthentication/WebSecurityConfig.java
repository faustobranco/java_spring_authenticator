package com.faustobranco.WebAuthentication;

import com.faustobranco.WebAuthentication.dao.pagePermissions_DAO;
import com.faustobranco.WebAuthentication.impl.pagePermissions_impl;
import com.faustobranco.WebAuthentication.model.pagePermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static pagePermissions obj_pagePermissions;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private WebAuthenticationSuccessHandler successHandler;

    // Load users, passwords and roles from DB to authenticate
    // Passwords written to DB are encrypted using Spring BCryptPasswordEncoder
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select user_email, password, enabled from tb_users where user_email = ?")
                .authoritiesByUsernameQuery("Select user_email, role_name " +
                        "   from tb_users" +
                        "        inner join tb_users_roles On tb_users.user_id = tb_users_roles.user_id" +
                        "        inner join tb_roles On tb_users_roles.role_id = tb_roles.role_id" +
                        "  Where tb_users.user_email = ?");

    }

    // Load page permissions from DB
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .successHandler(successHandler)
                .loginPage("/loginPage")
                .failureUrl("/loginPage?error")
                .usernameParameter("username").passwordParameter("password")
                .and()
            .logout().logoutSuccessUrl("/logout")
                .and()
            .exceptionHandling().accessDeniedPage("/403")
                .and()
            .rememberMe().key("uniqueAndSecret")
                .tokenValiditySeconds(86400);

        pagePermissions_DAO pagePermissionsDAO = new pagePermissions_impl ();
        try {
            obj_pagePermissions = pagePermissionsDAO.loadPermission ();
        } catch (Exception e) {
            e.printStackTrace ();
        }

        ArrayList<HashMap<String, String>> lst_Permissions = new ArrayList<>();

        lst_Permissions = obj_pagePermissions.getLst_pagePermissions ();

        for (HashMap<String, String> eachEntry : lst_Permissions) {
            String url = "/" + eachEntry.get("page");
            String permission= "hasAuthority('" + eachEntry.get ("role") + "')";
            http.authorizeRequests().and().authorizeRequests().antMatchers(url).access(permission);
        }
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder ();
    }

}