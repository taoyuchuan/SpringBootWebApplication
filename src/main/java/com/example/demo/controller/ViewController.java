package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for views that consumes REST API.
 */
@Controller
public class ViewController {
    /**
     * Render view for consuming GET API.
     * @return view
     */
    @RequestMapping("/view-products")
    public String viewProducts() {
        return "view-products";
    }

    /**
     * Render view for consuming POST API.
     * @return view
     */
    @RequestMapping("/add-products")
    public String addProducts() {
        return "add-products";
    }
}
