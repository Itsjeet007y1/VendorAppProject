package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.User;
import com.app.service.IUserService;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;

@Controller
public class UserController {

	@Autowired
	private IUserService service;

	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	private CodeUtil codeUtil;

	// 1. show User Registration Page
	@RequestMapping("/regUser")
	public String showUser() {
		return "UserRegister";
	}

	// 2. Register user and send email also
	@RequestMapping(value = "/saveUser", method = POST)
	public String saveUser(@ModelAttribute("user") User user, ModelMap map) {

		// generate the password
		String pwd = codeUtil.getPassword();
		// set password to user
		user.setUserPwd(pwd);
		// save user data
		int userId = service.saveUser(user);
		String message = "User Registered with ID:" + userId;
		String text = "Welcom to VDM User '" + user.getUserName()
				+ "' user Id is: " + user.getUserEmail() + " (or) "
				+ user.getUserContact() + "....Password is: "
				+ user.getUserPwd();
		// send email
		boolean flag = commonUtil.sendMail(user.getUserEmail(),
				"Login Details", text, null);
		if (flag) {
			message += ",Email also sent";
			// send message to UI
			map.addAttribute("msg", message);
		}
		return "UserRegister";
	}

	// 3. Show login page
	@RequestMapping("/login")
	public String showLogin() {
		return "UserLogin";
	}

	// 4. do Login process
	@RequestMapping(value = "/loginCheck", method = POST)
	public String doLoginCheck(@RequestParam("un") String un,
			@RequestParam("pwd") String pwd, ModelMap map,
			HttpServletRequest req) {
		String page = null;
		User user = service.getUserByNameAndPassword(un, pwd);
		if (user == null) { // user does not exists
			map.addAttribute("msg","<span style='color:red'>Invalid Username/Password!!!</span>");
			page = "UserLogin";
		} else {			//user exists
			page="LocationRegistration";
			//create one httpSession object
			HttpSession session=req.getSession();
			session.setAttribute("username", user.getUserName());
		}
		return page;
	}
	
	//5. doLogout process
	@RequestMapping("/logout")
	public String doLogoutProcess(HttpServletRequest req,ModelMap map){
		HttpSession session=req.getSession(false);
		session.setAttribute("username", null);
		session.invalidate();
		map.addAttribute("msg","<span style='color:green'>Logout Successful.</span>");
		return "UserLogin";
	}
}
