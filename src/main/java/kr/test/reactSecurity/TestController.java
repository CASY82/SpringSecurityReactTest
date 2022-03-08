package kr.test.reactSecurity;

import java.security.Principal;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class TestController {
	
	@RequestMapping(value = "/testapi", method = RequestMethod.GET)
	public String testRestApi() {
		return "index";
	}
	
	@RequestMapping(value = "/admin/testapi")
	@ResponseBody
	public void testAdminRestApi() {
		
	}
	
	@RequestMapping(value = "/main/testapi")
	@ResponseBody
	public String testMainRestApi(Principal principal) {
		JsonObject jo = new JsonObject();
		
		jo.addProperty("username", principal.getName());
		jo.addProperty("date", new Date().toString());
		
		JsonArray ja = new JsonArray();
		for(int i=0; i<5; i++) {
			JsonObject obj = new JsonObject();
			obj.addProperty("num"+i, i);
			ja.add(obj);
		}
		
		jo.add("testData", ja);
		
		return jo.toString();
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login-form";
	}
}
