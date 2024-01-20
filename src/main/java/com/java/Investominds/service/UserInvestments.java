package com.java.Investominds.service;

import com.java.Investominds.dto.InvestmentPlanDto;
import com.java.Investominds.dto.UserRegistrationDto;
import com.java.Investominds.model.Balance;
import com.java.Investominds.model.Plans;
import com.java.Investominds.model.Role;
import com.java.Investominds.model.User;
import com.java.Investominds.repository.BalanceRepo;
import com.java.Investominds.repository.PlansRepo;
import com.java.Investominds.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class UserInvestments {

    @Autowired
    private PlansRepo plansRepo;
    @Autowired
    private BalanceRepo balanceRepo;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public String save(InvestmentPlanDto investmentPlanDto) {
        Plans plans = plansRepo.findById(investmentPlanDto.getPlans_id())
                .orElseThrow(() -> new UsernameNotFoundException(investmentPlanDto.getPlans_id().toString()));
        User user = userRepository.findById(investmentPlanDto.getUser_id())
                .orElseThrow(() -> new UsernameNotFoundException(investmentPlanDto.getPlans_id().toString()));
        Balance balance = balanceRepo.findByuser_id(investmentPlanDto.getUser_id());

       if(balance.getAvailable_balance()<=plans.getMin_amount()){

           System.out.println( balance.getAvailable_balance()+" "+ plans.getMin_amount()+"Insufficient balance, Please add sufficient balance to Add this plan.");

           /*throw new ResourceAccessException("Your current balance "+balance.getAvailable_balance()+" is less than plan Amount "+plans.getMin_amount()+" Please add sufficient balance to continue this plan.");*/

           //return "Your current balance "+balance.getAvailable_balance()+" is less than plan Amount "+plans.getMin_amount()+" Please add sufficient balance to continue this plan.";
       return "error";
       }else {
          Double updated_balance =balance.getAvailable_balance()-plans.getMin_amount();
           balanceRepo.updateBalanceByuser_id(updated_balance, balance.getId());

           System.out.println("saved "+updated_balance);

           List<Plans> plan = new ArrayList<>();

           Plans pln = plansRepo.getById(investmentPlanDto.getPlans_id());

/*                   plan.add(pln);
           user.setPlans(new HashSet<> (plan));*/
           user.getPlans().add(pln);
           userRepository.save(user);
         return pln.getPlan_names()+" is successfully added to your Investment plans.";
       }
    }

}
















/*Plans plans1 = new Plans();
           plans1.setId(investmentPlanDto.getPlans_id());
           plans1.setPlan_names(plans.getPlan_names());
           plans1.setPlan_description(plans.getPlan_description());
           plans1.setMin_amount(plans.getMin_amount());
           plans1.setRate_of_return(plans.getRate_of_return());
           plans1.setMin_amount(plans.getMin_amount());

           List<User> users = new ArrayList<>();

           User usr = userRepository.getById(investmentPlanDto.getUser_id());
           users.add(usr);

           plans1.setUser(new HashSet<>(users));
           plansRepo.save(plans1);
*/