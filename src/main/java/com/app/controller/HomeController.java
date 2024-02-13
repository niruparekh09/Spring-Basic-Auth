package com.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class HomeController {
    @GetMapping("/add")
    String add() {
        return "Inside Add. Only Admin";
    }

    @GetMapping("/view")
    String view() {
        return "Inside view";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete")
    String delete() {
        return "Inside delete. Only Admin has permission";
    }

    @GetMapping("/categories")
    String categories() {
        return "categories. Every Authenticated";
    }

    @GetMapping("/purchase")
    String purchase(){
        return "purchase. Only Customer";
    }
}
