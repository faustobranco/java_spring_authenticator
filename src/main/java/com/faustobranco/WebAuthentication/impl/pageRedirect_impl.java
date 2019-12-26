package com.faustobranco.WebAuthentication.impl;

import com.faustobranco.WebAuthentication.dao.pageRedirect_DAO;
import com.faustobranco.WebAuthentication.model.appConfiguration;
import com.faustobranco.WebAuthentication.model.pageRedirect;
import com.faustobranco.WebAuthentication.util.loadConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class pageRedirect_impl implements pageRedirect_DAO {

    public pageRedirect loadRedirect() throws Exception {

        ArrayList<HashMap<String, String>> load_PageRedirect = new ArrayList<> ();

        String str_Query = "";

        appConfiguration obj_appConfiguration = loadConfiguration.LoadConfiguration ();

        String url = obj_appConfiguration.getDb_url ();
        String user = obj_appConfiguration.getUsername ();
        String password = obj_appConfiguration.getPassword ();

        str_Query = "Select page_name, role_name" +
                "  from tb_pages" +
                "       inner join tb_page_redirect_roles On tb_pages.page_id = tb_page_redirect_roles.page_id" +
                "       inner join tb_roles On tb_page_redirect_roles.role_id = tb_roles.role_id;";

        try {
            Connection con = DriverManager.getConnection (url, user, password);
            Statement st = con.createStatement ();
            ResultSet rs = st.executeQuery (str_Query);

            while(rs.next())
            {
                HashMap<String, String> page_Permission = new HashMap<String, String>();
                page_Permission.put ("page", rs.getString ("page_name"));
                page_Permission.put ("role", rs.getString ("role_name"));
                load_PageRedirect.add (page_Permission);
            }

        } catch (SQLException ex) {
            throw new Exception (ex);
        }
        return new pageRedirect (load_PageRedirect);
    }
}
