package com.feedvisor.repricer.controllers;

import com.feedvisor.repricer.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

  @Autowired
  AppProperties appProperties;

  @GetMapping("")
  public String home(){
    return "Welcome to repricer";
  }

  @GetMapping("version")
  public String getAppVersion(){
    return appProperties.getApiVersion();
  }
}
