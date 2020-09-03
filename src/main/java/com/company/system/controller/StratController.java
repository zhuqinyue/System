//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StratController {
    public StratController() {
    }

    @RequestMapping({"/news/strat"})
    public String strat() {
        return "/view/starter.html";
    }

    @RequestMapping({"data"})
    public String data() {
        return "/view/newsdata.html";
    }

    @RequestMapping({"/"})
    public String getpage() {
        return "/view/desk/shouye.html";
    }

    @RequestMapping({"case"})
    public String addsucess() {
        return "/view/case.html";
    }

    @RequestMapping({"dex"})
    public String getpagedex() {
        return "/view/dex.html";
    }
}
