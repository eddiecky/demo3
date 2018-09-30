package com.polarbear.shareweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoticeController {

    @RequestMapping(value={"/updateMsg"}, method = RequestMethod.POST)
    public String updateMsg(Model model, @RequestParam("systemMessage") String message) {
        model.addAttribute("message", message);
        return "notice";
    }

}