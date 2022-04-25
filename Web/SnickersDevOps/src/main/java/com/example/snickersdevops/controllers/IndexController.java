package com.example.snickersdevops.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/biology")
    public String BiologyCourse(){
        return "biology";
    }

    @GetMapping("/chemistry")
    public String ChemistryCourse(){
        return "chemistry";
    }

    @GetMapping("/geography")
    public String geographyCourse(){
        return "geography";
    }

    @GetMapping("/math")
    public String mathCourse(){
        return "math";
    }

    @GetMapping("/math_literacy")
    public String mathLiteracyCourse(){
        return "math_literacy";
    }

    @GetMapping("/oqu_sauat")
    public String oquSauatCourse(){
        return "oqu_sauat";
    }

    @GetMapping("/physics")
    public String physicsCourse(){
        return "physics";
    }

    @GetMapping("/qazaqstan_tarih")
    public String qazaqstanTarihCourse(){
        return "qazaqstan_tarih";
    }
}
