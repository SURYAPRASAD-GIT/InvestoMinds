package com.java.Investominds.controller;

import com.java.Investominds.model.Balance;
import com.java.Investominds.repository.BalanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BalanceController {

    @Autowired
    private BalanceRepo balanceRepo;

    @GetMapping("/checkbalance/{id}")
    public String checkBalance(@PathVariable(name = "id") Long user_id, Model model) {

        Balance balanceResponse =  balanceRepo.findByuser_id(user_id);

        model.addAttribute("bal",balanceResponse);
        return "checkmybalance";
    }
}
