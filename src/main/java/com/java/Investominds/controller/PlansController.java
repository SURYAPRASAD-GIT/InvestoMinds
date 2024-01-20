package com.java.Investominds.controller;

import com.java.Investominds.dto.InvestmentPlanDto;
import com.java.Investominds.model.Plans;
import com.java.Investominds.repository.PlansRepo;
import com.java.Investominds.repository.UserRepository;
import com.java.Investominds.service.LoginUser;
import com.java.Investominds.service.UserInvestments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class PlansController {


    private UserInvestments userInvestments;

    public PlansController(UserInvestments userInvestments) {
        super();
        this.userInvestments = userInvestments;
    }

    @Autowired
    private PlansRepo plansRepo;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/allplans")
    public String getAllPlans(Model model){
        List<Plans> plans = plansRepo.findAll();
        model.addAttribute("plans",plans);
        return "investnow";
    }

    @GetMapping("/gold/{id}")
    public String getGoldPlan(@AuthenticationPrincipal LoginUser usr, Model model, @PathVariable(name = "id") Long id){
        Plans plans =  plansRepo.findById(id)
                .orElseThrow(()-> new UsernameNotFoundException("id not found"));
        model.addAttribute("p1",plans);
        model.addAttribute("usr",usr);
        return "Digital_Gold";
    }
    @GetMapping("/mutualfunds/{id}")
    public String getMutualFunds(@AuthenticationPrincipal LoginUser usr, Model model, @PathVariable(name = "id") Long id){
        Plans plans =  plansRepo.findById(id)
                .orElseThrow(()-> new UsernameNotFoundException("id not found"));
        model.addAttribute("p1",plans);
        model.addAttribute("usr",usr);
        return "ICICI Mutual";
    }
    @GetMapping("/mutualfunds1/{id}")
    public String getMutualFunds1(@AuthenticationPrincipal LoginUser usr, Model model, @PathVariable(name = "id") Long id){
        Plans plans =  plansRepo.findById(id)
                .orElseThrow(()-> new UsernameNotFoundException("id not found"));
        model.addAttribute("p1",plans);
        model.addAttribute("usr",usr);
        return "Parag_Parikh_Flexi";
    }


    @GetMapping("/mutualfunds")
    public String getMutualfunds(){
        return "mutualfunds";
    }
    @GetMapping("/mutualfunds1")
    public String getMutualfunds1(){
        return "mutualfunds1";
    }


    @ModelAttribute("addplan")
    public InvestmentPlanDto investmentPlanDto() {
        return new InvestmentPlanDto();
    }


    @PostMapping("/addplan")
    public String addPlan(@ModelAttribute("addplan") InvestmentPlanDto investmentPlansDto, Model model ) {
           String msg =userInvestments.save(investmentPlansDto);
           System.out.println(msg);
           model.addAttribute("hi",msg);
           if(msg.equalsIgnoreCase("error")) {
               return "redirect:/allplans?error";
           }else {
               return "redirect:/allplans?success";
           }

    }

   @GetMapping("/getuserplans/{id}")
    public String getUserPlans( @PathVariable Long id, Model model ){
        List<Plans> pl1 = plansRepo.findAllUserPlans(id);
       model.addAttribute("plans",pl1);
       return "userplans";
      }

}



































/*User usr = userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("id not found"));*/