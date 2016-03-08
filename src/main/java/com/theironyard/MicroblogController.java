package com.theironyard;


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

    ArrayList<Message> messages = new ArrayList<Message>();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
        model.addAttribute("userName", session.getAttribute("userName"));
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
    @RequestMapping(path = "/message", method = RequestMethod.GET)
    public String message(Model model, HttpSession session) {
        model.addAttribute("message", session.getAttribute("message"));
        return "redirect:/";
    }
    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public String delete(HttpSession session, int id){
        session.setAttribute("delete", id);
        messages.remove(id - 1);
        return "redirect:/";
    }

}
