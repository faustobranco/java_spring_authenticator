package com.faustobranco.WebAuthentication;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.faustobranco.WebAuthentication.dao.pageRedirect_DAO;
import com.faustobranco.WebAuthentication.impl.pageRedirect_impl;
import com.faustobranco.WebAuthentication.model.pageRedirect;
import com.faustobranco.WebAuthentication.model.userDetails;
import com.faustobranco.WebAuthentication.web.LoginController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class WebAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private pageRedirect obj_pageRedirect;
    private userDetails obj_userDetails;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    // Load default pages (redirect after login) for each user/role
    @Override
    public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1,
                                        Authentication authentication) throws IOException, ServletException {

        String roleName = "";

        obj_userDetails = LoginController.getObj_userDetails ();

        roleName = obj_userDetails.getLst_Roles ().get (0);

        pageRedirect_DAO pageRedirectDAO = new pageRedirect_impl();

        try {
            obj_pageRedirect = pageRedirectDAO.loadRedirect ();
        } catch (Exception e) {
            e.printStackTrace ();
        }

        String str_pageRedirect = "";
        str_pageRedirect = obj_pageRedirect.get_ListbyRole (roleName).get (0).get ("page");

        redirectStrategy.sendRedirect(arg0, arg1, "/" + str_pageRedirect);

//        boolean hasUserRole = false;
//        boolean hasAdminRole = false;
//
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        for (GrantedAuthority grantedAuthority : authorities) {
//            if (grantedAuthority.getAuthority().equals("Normal_User")) {
//                hasUserRole = true;
//                break;
//            } else if (grantedAuthority.getAuthority().equals("Admin")) {
//                hasAdminRole = true;
//                break;
//            }
//        }
//
//        if (hasUserRole) {
//            redirectStrategy.sendRedirect(arg0, arg1, "/" + str_pageRedirect);
//        } else if (hasAdminRole) {
//            redirectStrategy.sendRedirect(arg0, arg1, "/adminPage");
//        } else {
//            throw new IllegalStateException();
//        }
//

    }

}
