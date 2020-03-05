package com.cts.project.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.pojos.User;

@RestController
public class HelloWorldController {
	@RequestMapping("/hello")
	public String HelloWorld() {
	 return "HelloWorld";
 }

}
