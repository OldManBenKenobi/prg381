package com.project.prg381;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.prg381.Repository.UserRepository;
import com.project.prg381.service.UserService;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
    //private RegisterRepository regirepo;
	
//opens HTML file or calls function based on url

	@GetMapping("") // home page
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register") // add user
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		//model.addAttribute("register", new Register());
		return "signup_form";
	}
	
	@PostMapping("/process_register") // save user to database
	public String processRegister(User user /* , Register register*/) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
        //regirepo.save(register);

		
		return "register_success";
	}

    @GetMapping("/Alogin") // custom admin login 
	public String LoginAdmin() {
		
		
		return "adminLogin";
	}

    @PostMapping("/Alogin") // go to CRUD after login
	public String processAdmin() {
		
		return "redirect:/CRUD";
	}

	
	@GetMapping("/users") // display users for users after login
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}

    // CRUD opperations 
    @Autowired
	private UserService userService;

    @GetMapping("/CRUD") // Put users into table in crud html
	public String listUsers2(Model model) {
		List<User> listUsers2 = userRepo.findAll();
        model.addAttribute("listUsers", listUsers2);
		
		return "crud";
	}

    @GetMapping("/showNewUserForm") // html for adding users by admin
	public String showNewUserForm(Model model) {
		// create model attribute to bind form datauser
		User user = new User();
		model.addAttribute("user", user);
		return "new_user";
	}
	
	@PostMapping("/saveUser") // save user from update or add
	public String saveUser(@ModelAttribute("user") User user) {
		// save user to database

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // encryption 
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userService.saveUser(user);
		return "redirect:/CRUD";
	}
	
	@GetMapping("/showFormForUpdate/{id}")  // update user from html 
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get user from the service
		User user = userService.getUserById(id);
		
		// set user as a model attribute to pre-populate the form
		model.addAttribute("user", user);
		return "update_user";
	}
	
	@GetMapping("/deleteUser/{id}") // delete user command from html
	public String deleteUser(@PathVariable (value = "id") long id) {
		
		// call delete user method 
		this.userService.deleteUserById(id);
		return "redirect:/CRUD";
	}
	
	
	@GetMapping("/page/{pageNo}") // navigation for table. 
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<User> page = userService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<User> listUsers = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listUsers", listUsers);
		return "index";
	}


}