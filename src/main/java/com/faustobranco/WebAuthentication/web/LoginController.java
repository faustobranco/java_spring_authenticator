package com.faustobranco.WebAuthentication.web;

import com.faustobranco.WebAuthentication.WebAuthenticationSuccessHandler;
import com.faustobranco.WebAuthentication.dao.userDetails_DAO;
import com.faustobranco.WebAuthentication.impl.userDetails_impl;
import com.faustobranco.WebAuthentication.model.userDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class LoginController implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    private static userDetails obj_userDetails;

    public static userDetails getObj_userDetails() {
        return obj_userDetails;
    }

    @Autowired
    private WebAuthenticationSuccessHandler successHandler;

    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("welcomePage");
        return model;
    }

    @RequestMapping(value = { "/homePage"}, method = RequestMethod.GET)
    public String homePage(Model model, Principal principal) throws Exception {
        model.addAttribute("message", "You are logged in as " + obj_userDetails.getUser_Name ());
        model.addAttribute("userName", obj_userDetails.getUser_Name ());
        model.addAttribute("userLogin", obj_userDetails.getUser_Login ());
        return "homePage";
    }

    @RequestMapping(value = {"/userPage"}, method = RequestMethod.GET)
    public String userPage(Model model, Principal principal) throws Exception {
        model.addAttribute("message", "You are logged in as " + obj_userDetails.getUser_Name ());
        model.addAttribute("userName", obj_userDetails.getUser_Name ());
        model.addAttribute("userLogin", obj_userDetails.getUser_Login ());
        return "userPage";
    }

    @RequestMapping(value = {"/adminPage"}, method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) throws Exception {
        model.addAttribute("message", "You are logged in as " + obj_userDetails.getUser_Name ());
        model.addAttribute("userName", obj_userDetails.getUser_Name ());
        model.addAttribute("userLogin", obj_userDetails.getUser_Login ());
        return "adminPage";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
                                  @RequestParam(value = "logout",	required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("loginMessage", "Invalid Credentials provided.");
        }

        if (logout != null) {
            model.addObject("loginMessage", "Logged out successfully.");
        }

        model.setViewName("loginPage");
        return model;
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();

        session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }

        for(Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }

        return "redirect:/loginPage?logout";
    }



    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        model.addObject("msg","You do not have permission to access this page!");

        model.setViewName("403");
        return model;

    }

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event)
    {
        UserDetails user = (UserDetails) event.getAuthentication().getPrincipal();
        try {
            userDetails_DAO userDetailDAO = new userDetails_impl ();
            obj_userDetails = userDetailDAO.loadUser (user.getUsername());
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

}
