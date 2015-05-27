package filmator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogOut {
	
	@RequestMapping(value = "/LogOut", method = RequestMethod.GET)
	public String home(HttpSession session) {
		
		if (session != null) {
		    session.invalidate();
		}
	
		return "redirect:/login";
	}

}
