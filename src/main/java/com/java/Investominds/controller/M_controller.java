package com.java.Investominds.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class M_controller {



        @RequestMapping("/products")
        public String products() {
            return "products";
        }

        @RequestMapping("/about")
        public String about() {
            return "about";
        }


}
