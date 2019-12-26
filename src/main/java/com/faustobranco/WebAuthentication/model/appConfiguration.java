package com.faustobranco.WebAuthentication.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.faustobranco.WebAuthentication.util.AES;

@JsonIgnoreProperties(ignoreUnknown = true)
public class appConfiguration {
    private String db_url;
    private String username;
    private String password;

    String secretKey = "YCns8mVzsg7SwUUHyFMK";

    @JsonCreator
    public appConfiguration(@JsonProperty("db_url") String db_url, @JsonProperty("db_username") String username, @JsonProperty("db_password") String password) {
        this.db_url = db_url;
        this.username = username;
        this.password = password;
    }

    public String getDb_url() {
        return db_url;
    }

    public String getUsername() {
        String str_username = AES.decrypt(username, secretKey);
        return str_username;
    }

    public String getPassword() {
        String str_password = AES.decrypt(password, secretKey);
        return str_password;
    }


}
