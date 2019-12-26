package com.faustobranco.WebAuthentication.model;

import java.util.List;

public class userDetails {

    private final String User_Login;
    private final String User_Name;
    private final List<String> lst_Roles;
    private final List<String> lst_Redirect_Pages;

    public userDetails(String user_Login, String user_Name, List<String> Roles, List<String> RedirectPages) {
        User_Login = user_Login;
        User_Name = user_Name;
        lst_Roles = Roles;
        lst_Redirect_Pages = RedirectPages;
    }

    public String getUser_Login() {
        return User_Login;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public List<String> getLst_Roles() {
        return lst_Roles;
    }
}
