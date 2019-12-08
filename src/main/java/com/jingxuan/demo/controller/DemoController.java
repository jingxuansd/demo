package com.jingxuan.demo.controller;


import com.jingxuan.demo.model.User;
import com.jingxuan.demo.servie.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

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
        log.info("name:{}", name);
        model.addAttribute("name", name);

        test(model);

        return "index";
    }

    private void test(Model model) {
        List<User> users = new ArrayList<>();
        users.add(User
                .builder()
                .name("jingxuan")
                .email("123@qq.com").amount(BigDecimal.TEN).build());
        users.add(User
                .builder()
                .name("jingxuan")
                .email("123@qq.com").amount(BigDecimal.TEN).build());
        users.add(User
                .builder()
                .name("jingxuan")
                .email("234@qq.com").amount(BigDecimal.TEN).build());
        users.add(User
                .builder()
                .name("jingxuan")
                .email("234@qq.com").amount(BigDecimal.TEN).build());


        Map<String, User> mergeUserMap = new HashMap<>();
        users.forEach(user ->
            mergeUserMap.merge(
                    getKey(user),
                    user,
                    this::mergeUser)
        );
        model.addAttribute("test",
                MessageFormat.format("map size: {0}, map key: {1}, map value: {2}",
                        mergeUserMap.size(), mergeUserMap.keySet(), mergeUserMap.values()));
        log.info("merge users: [{}]", mergeUserMap);
    }

    private String getKey(User user) {
        return String.join("#",user.getName(),user.getEmail());
    }

    private User mergeUser(User u1, User u2) {
        if (u1 == null) {
            return u2;
        }
        if (u2 == null) {
            return u1;
        }
        u1.setAmount(u1.getAmount().add(u2.getAmount()));
        return u1;
    }
}
