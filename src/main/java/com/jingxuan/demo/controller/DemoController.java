package com.jingxuan.demo.controller;


import com.jingxuan.demo.model.User;
import com.jingxuan.demo.servie.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Xuan Jing
 */
@Slf4j
@Controller
@RequestMapping("/v1/demo")
public class DemoController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{id}/name")
    String getName(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        String name = user.getName();
        log.info("param: name:{}", name);
        model.addAttribute("name", name);
        return "index";
    }

}
