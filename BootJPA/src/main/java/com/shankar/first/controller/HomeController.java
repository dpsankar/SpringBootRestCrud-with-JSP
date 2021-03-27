package com.shankar.first.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shankar.first.DAO.AlienRepo;
import com.shankar.first.model.Alien;

@Controller
public class HomeController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("insert")
	public String insert()
	{
		return "insert.jsp";
	}
	@RequestMapping("view")
	public String view()
	{
		repo.toString();
		return "view.jsp";
	}
	@RequestMapping("find")
	public String find()
	{
//		ModelAndView mv=new ModelAndView();
//		Optional<Alien> a=repo.findById(id);
//		mv.addObject("obj",a);
//		mv.setViewName("find.jsp");
//		
//		return mv;
		return "enter.jsp";
	}
	@RequestMapping("findById")
	public ModelAndView findbyId(@RequestParam int aid)
	{
		ModelAndView mv=new ModelAndView("find.jsp");
		Alien alien=repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		mv.setViewName("find.jsp");
		
		return mv;
	}
	
	@RequestMapping("addAlien")
	public String addAlien(Alien alien)
	{
		
		repo.save(alien);
		return "home.jsp";
	}

}
