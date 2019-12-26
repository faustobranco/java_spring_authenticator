package com.faustobranco.WebAuthentication.dao;

import com.faustobranco.WebAuthentication.model.userDetails;

public interface userDetails_DAO {

        public userDetails loadUser(String user_email) throws Exception;
}
