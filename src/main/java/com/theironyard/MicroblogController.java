package com.theironyard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by ericweidman on 3/7/16.
 */
@Controller
public class MicroblogController {
    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
        model.addAttribute("userName", session.getAttribute("userName"));
        model.addAttribute("messages", messages.findAll());

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
    public String addMessage(HttpSession session, String text){
        Message message = new Message(text);
        messages.save(message);
        return "redirect:/";
    }
    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delete(HttpSession session, int id){
        session.setAttribute("id", id);
        messages.delete(id);
        return "redirect:/";
    }
    @RequestMapping(path = "update-message", method = RequestMethod.POST)
    public String updateMessage(HttpSession session){

        return "redirect:/";
    }
}
