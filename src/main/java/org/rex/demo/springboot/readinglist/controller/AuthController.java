package org.rex.demo.springboot.readinglist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by RexSong on 2017/6/25.
 */
@Controller
public class AuthController {
    @RequestMapping("/whatever/shoes")
    @ResponseBody
    public String shoes() {
        return "whatever shoes are";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
