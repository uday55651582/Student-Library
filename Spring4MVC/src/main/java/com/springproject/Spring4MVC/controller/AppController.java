package com.springproject.Spring4MVC.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.springproject.Spring4MVC.mail.Emailinputs;
import com.springproject.Spring4MVC.model.Mybooks;
import com.springproject.Spring4MVC.model.User;
import com.springproject.Spring4MVC.service.BookService;
import com.springproject.Spring4MVC.service.SecurityService;
import com.springproject.Spring4MVC.service.UserService;
import com.springproject.Spring4MVC.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
@RequestMapping("/")
public class AppController {
	
	 @Autowired
	    private UserService userService;
	 
	 	Emailinputs Emailtest = new Emailinputs();

	 	@Autowired
	    private BookService bookService;

	    @Autowired
	    private SecurityService securityService;

	    @Autowired
	    private UserValidator userValidator;
 
    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "home";
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(ModelMap model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, ModelMap model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }


@RequestMapping(value ="/welcome", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
	   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	     String currentPrincipalName = authentication.getName();
	   List<Mybooks> mybooks1 = bookService.findbyowner(currentPrincipalName);
	   List<Mybooks> mybooks = new ArrayList<Mybooks>();
	   List<Mybooks> allbooks = new ArrayList<Mybooks>();
	   List<Mybooks> allbooks1 = bookService.findAll();
	     for(int i=mybooks1.size();i>=mybooks1.size()-2;i--)
	     {
	    	 mybooks.add(0, (Mybooks) mybooks1.get(i-1));
	    	 }
	     for(int i=allbooks1.size();i>=allbooks1.size()-2;i--)
	     {	    	 
	    	 allbooks.add(0, (Mybooks) allbooks1.get(i-1));	
	    	 }
	     ((ModelMap) model).addAttribute("allbooks", allbooks);
	   ((ModelMap) model).addAttribute("mybooks", mybooks);
        return "welcome";
    }
   

   @RequestMapping(value ="/addbooks")
   public String addbooks(ModelMap model) {
	   Mybooks bookForm = new Mybooks();    
	   System.out.println("printing in Addbooks......." );
       model.put("bookForm", bookForm);
	   List<String> categoryList = new ArrayList<>();
	   categoryList.add("Engineering");
	   categoryList.add("Arts & Science");
	   categoryList.add("Literature");
	   categoryList.add("Other");
       model.put("categoryList", categoryList);
       return "addbooks";
   }
   @RequestMapping(value = "/addbooks", method = RequestMethod.POST)
   @ResponseStatus(value=HttpStatus.OK)
   public ModelAndView addbooks(@ModelAttribute("bookForm") Mybooks addbooks,
           Map<String, Object> model) { 
	   bookService.save(addbooks);	
	   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	     String currentPrincipalName = authentication.getName();
	   List<Mybooks> mybooks = bookService.findbyowner(currentPrincipalName);  
	   ((ModelMap) model).addAttribute("mybooks", mybooks);
       return new ModelAndView("mybooks");
   }
   
   @RequestMapping(value ="/mybooks", method = RequestMethod.GET)
   public String mybooks(ModelMap model) {
	   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	     String currentPrincipalName = authentication.getName();
	   List<Mybooks> mybooks = bookService.findbyowner(currentPrincipalName);  
	   System.out.println("printing......." );
	   model.addAttribute("mybooks", mybooks);
		return "mybooks";
   }
   
   @RequestMapping(value ="/allbooks", method = RequestMethod.GET)
   public String allbooks(ModelMap model) {
	   List<Mybooks> mybooks = bookService.findAll();  
	   System.out.println("printing all books......." );
	   model.addAttribute("mybooks", mybooks);
		return "allbooks";
   }
   
   /*@RequestMapping(value="/delete", method=RequestMethod.POST)
   public ModelAndView deletebook(HttpServletRequest request) {
	   int bookid = Integer.parseInt(request.getParameter("book_id"));
	   System.out.println("printing......." );
	   bookService.delete(bookid);
		return new ModelAndView("mybooks");
	}*/
   
 /*  @RequestMapping(value="/editbook", method=RequestMethod.POST)
   public ModelAndView editbook(HttpServletRequest request) {
	   System.out.println("printing in  Editbook......." );
	   int bookid = Integer.parseInt(request.getParameter("book_id"));
	   System.out.println(bookid);
	   Mybooks book = bookService.getbook(bookid);
	    ModelAndView model1 = new ModelAndView("editbook");	
	    model1.addObject("book", book);
	    bookService.update(book);
	    return model1;
	}*/
   

   @RequestMapping(value = "/doSearch", method = RequestMethod.POST)
   public ModelAndView search(
      @RequestParam("searchText")
      String searchText
   ) throws Exception
   {
      List<Mybooks> allFound = bookService.searchForBook(searchText);
	   List<Mybooks> mybooks = new ArrayList<Mybooks>();  
      
      for (Mybooks b : allFound)
      {
    	  Mybooks bm = new Mybooks();
         bm.setBook_author(b.getBook_author());
         bm.setBook_title(b.getBook_title());
         bm.setBook_category(b.getBook_category());
         System.out.println("title....."+ b.getBook_title());
         mybooks.add(bm);
      }
      
      ModelAndView mav = new ModelAndView("bookresults");
      mav.addObject("foundBooks", mybooks);
      return mav;
   }
   
   @RequestMapping(value="/bookrequest")
   public ModelAndView requestbook(ModelMap model)
   	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	   System.out.println(authentication.getName());
	   if(authentication.getName() == "anonymousUser"){
		   System.out.println("in authentication loop..........");
		   model.addAttribute("error", "User should be logged-in to make a request");	
		   return new ModelAndView("login");
	   	}
	   else{
	   Emailtest.automail();
	   
	   model.addAttribute("flash", "Requested successfully");
	   return new ModelAndView("welcome");
	   }
	}
   
   
  
}
   
   
