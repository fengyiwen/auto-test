package com.auto.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auto.domain.Account;

@Controller  
public class UserController {  
  
    @RequestMapping("/save")  
    public String save(@Valid Account user, BindingResult result) {  
        if(result.hasErrors()) {  
            return "error";  
        }  
        return "success";  
    }  
}  
