package com.xuke.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

	@RequestMapping
	public String homePage(){
		return "Sateng is comming! " + new Date();
	}
}
