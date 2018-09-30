package com.polarbear.shareweb;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.tomcat.jni.File;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoticeController {

    @RequestMapping(value = { "/updateMsg" }, method = RequestMethod.POST)
    public String updateMsg(Model model, @RequestParam("systemMessage") String message) {

        model.addAttribute("message", message);
        FileWriter file = null;

        try {
            file = new FileWriter("/data/message.json");
            file.write(message);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "notice";
    }

}