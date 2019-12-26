package com.faustobranco.WebAuthentication.impl;

import com.faustobranco.WebAuthentication.dao.userDetails_DAO;
import com.faustobranco.WebAuthentication.model.appConfiguration;
import com.faustobranco.WebAuthentication.model.userDetails;
import com.faustobranco.WebAuthentication.util.loadConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;


public class userDetails_impl implements userDetails_DAO {

    public userDetails_impl() {
    }

    @Override
    public userDetails loadUser(String user_email) throws Exception {
        if (user_email == null || user_email == "") {
            throw new Exception ("User is empty!");
        }

        String str_Query = "";

        appConfiguration obj_appConfiguration = loadConfiguration.LoadConfiguration ();

        String url = obj_appConfiguration.getDb_url ();
        String user = obj_appConfiguration.getUsername ();
        String password = obj_appConfiguration.getPassword ();

        str_Query = "SELECT tb_users.user_name, tb_users.user_email, string_agg(tb_roles.role_name, ', ' ORDER BY tb_roles.role_weight) AS role_list, string_agg(tb_pages.page_name, ', ' ORDER BY tb_roles.role_weight) AS page_redirect_list" +
                "  FROM tb_users" +
                "       INNER JOIN tb_users_roles On tb_users.user_id = tb_users_roles.user_id" +
                "       INNER JOIN tb_roles On tb_users_roles.role_id = tb_roles.role_id" +
                "       INNER JOIN tb_page_redirect_roles On tb_users_roles.role_id = tb_page_redirect_roles.role_id" +
                "       INNER JOIN tb_pages On tb_page_redirect_roles.page_id = tb_pages.page_id" +
                " WHERE tb_users.user_email = '" + user_email + "'" +
                " GROUP BY tb_users.user_name, tb_users.user_email; ";

        try {
            Connection con = DriverManager.getConnection (url, user, password);
            Statement st = con.createStatement ();
            ResultSet rs = st.executeQuery (str_Query);

            if(rs.next())
            {
                userDetails obj_user = new userDetails (rs.getString ("user_email")
                                         , rs.getString ("user_name")
                                         , new ArrayList<String>(Arrays.asList(rs.getString ("role_list").split(",")))
                                          ,new ArrayList<String>(Arrays.asList(rs.getString ("page_redirect_list").split(","))));
                return obj_user;
            }

        } catch (SQLException ex) {
            throw new Exception (ex);
        }
        return null;
    }
}
