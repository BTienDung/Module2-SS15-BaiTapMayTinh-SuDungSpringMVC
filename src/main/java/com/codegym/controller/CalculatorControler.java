package com.codegym.controller;

import com.codegym.service.CalculatorServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorControler {
    CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
    @GetMapping("/form")
    public String  showForm(Model model){

        return "index";
    }

    @PostMapping("/calculate")
    public ModelAndView calculator(@RequestParam ("operator") String operator, @RequestParam("firstOperand") float firstOperand, @RequestParam("secondOperand") float secondOperand){
        ModelAndView modelAndView = new ModelAndView("index");
        float result;
        if (operator.equals("+")){
             result = calculatorService.add(firstOperand, secondOperand);
             modelAndView.addObject("result", result);
        } else if (operator.equals("-")){
             result = calculatorService.sub(firstOperand, secondOperand);
             modelAndView.addObject("result", result);
        }else if (operator.equals("*")){
            result = calculatorService.mul(firstOperand, secondOperand);
            modelAndView.addObject("result", result);
        }else if (operator.equals("/") && secondOperand !=0){
            result = calculatorService.div(firstOperand, secondOperand);
            modelAndView.addObject("result", result);
        }else{
            modelAndView.addObject("result", "Mẫu số không được là 0.");
        }
        return modelAndView;
    }
}
