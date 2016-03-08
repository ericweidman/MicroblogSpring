package com.theironyard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by ericweidman on 3/7/16.
 */
@Controller
public class MicroblogController {
    @Autowired
    MessageRepository message;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
        model.addAttribute("userName", session.getAttribute("userName"));
        model.addAttribute("message", message.findAll());
        return "home";
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName){
        session.setAttribute("userName", userName);
        if (userName.equals("")){
            return "redirect:/login";
        }
        return "redirect:/";
    }
    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(HttpSession session, String message) {
        session.setAttribute("message", session.getAttribute("message"));

        return "redirect:/";
    }
    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delete(HttpSession session, int id){
        session.setAttribute("delete", id);
        return "redirect:/";
    }
    @RequestMapping(path = "update-message", method = RequestMethod.POST)
    public String updateMessage(HttpSession session){

        return "redirect:/";
    }
}
