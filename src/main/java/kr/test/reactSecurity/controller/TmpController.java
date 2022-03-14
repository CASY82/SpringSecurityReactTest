package kr.test.reactSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TmpController {
	
	// '/'지점 지정
	@RequestMapping(value = "/")
    public String rootPage() {
		return "/login-form";
	}

	@RequestMapping(value = "/hello")
	@ResponseBody
    public String firstPage() {
        return "Hello. you have valid JWT (JSon Web Token)!";
	}
	
	@RequestMapping(value = "/MainView/MainPage")
	public String MainPage() {
		return "/MainPage";
	}
}
