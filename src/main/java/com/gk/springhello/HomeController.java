package com.gk.springhello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gk.springhello.model.Video;
import com.gk.springhello.model.VideoService;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private VideoService videoService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		String userName;
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		UserService userService = UserServiceFactory.getUserService();
	    User currentUser = userService.getCurrentUser();
	    String logout = userService.createLogoutURL("/");
	    model.addAttribute("logoutURL", logout);
	    model.addAttribute("fullUser", currentUser);
		
		return "home";
	}
	
	@RequestMapping(value="/welcome",method = RequestMethod.GET)
	public String welcome(Model model,HttpServletRequest request){
		logger.info("Inside the welcome page");
		
		UserService userService = UserServiceFactory.getUserService();
	    User currentUser = userService.getCurrentUser();
	    String logout = userService.createLogoutURL("/");
	    model.addAttribute("logoutURL", logout);
	    model.addAttribute("fullUser", currentUser);
		model.addAttribute("message", "This is the welcome page");
		return "welcome";
	}
	
	@RequestMapping(value="/hello",method = RequestMethod.GET)
	public @ResponseBody String hello(HttpServletResponse res,@RequestParam String name){
		return name;
	}
	
	@RequestMapping(value="/video",method = RequestMethod.GET)
	public @ResponseBody String videoInsert(HttpServletResponse res,@RequestParam String videoId,@RequestParam String name){
		Video newVideo = new Video(videoId,name);
		videoService.insertVideo(newVideo);
		return "new Video Inserted";
	}
	
}

