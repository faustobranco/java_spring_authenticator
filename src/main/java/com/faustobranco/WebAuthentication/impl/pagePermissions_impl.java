package com.faustobranco.WebAuthentication.impl;

import com.faustobranco.WebAuthentication.dao.pagePermissions_DAO;
import com.faustobranco.WebAuthentication.model.appConfiguration;
import com.faustobranco.WebAuthentication.model.pagePermissions;
import com.faustobranco.WebAuthentication.util.loadConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class pagePermissions_impl implements pagePermissions_DAO {

    public pagePermissions loadPermission() throws Exception {

        ArrayList<HashMap<String, String>> load_PagePermissions = new ArrayList<> ();

        String str_Query = "";

        appConfiguration obj_appConfiguration = loadConfiguration.LoadConfiguration ();

        String url = obj_appConfiguration.getDb_url ();
        String user = obj_appConfiguration.getUsername ();
        String password = obj_appConfiguration.getPassword ();
        str_Query = "Select page_name, role_name" +
                "  from tb_pages" +
                "       inner join tb_page_roles On tb_pages.page_id = tb_page_roles.page_id" +
                "       inner join tb_roles On tb_page_roles.role_id = tb_roles.role_id;";

        try {
            Connection con = DriverManager.getConnection (url, user, password);
            Statement st = con.createStatement ();
            ResultSet rs = st.executeQuery (str_Query);

            while(rs.next())
            {
                HashMap<String, String> page_Permission = new HashMap<String, String>();
                page_Permission.put ("page", rs.getString ("page_name"));
                page_Permission.put ("role", rs.getString ("role_name"));
                load_PagePermissions.add (page_Permission);
            }

        } catch (SQLException ex) {
            throw new Exception (ex);
        }
        return new pagePermissions (load_PagePermissions);
    }
}
