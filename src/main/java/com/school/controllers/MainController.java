package com.school.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.utility.Converter;
import com.school.models.Alumno;
import com.school.models.Director;
import com.school.models.Fallo;
import com.school.services.AlumnoService;
import com.school.services.DirectorService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RequestMapping({"/"})
@Controller
public class MainController {
	
	@Autowired
	AlumnoService alumnoService;
	
	@Autowired
	DirectorService directorService;
	
	Converter converter = new Converter();
	
	static String userlogged;
	
	@RequestMapping({"/index", "/"})
	public String indexPage() {
		userlogged = "";
		return "index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("Director", new Director());
		return "register";
	}
	
	@RequestMapping(value = "/tryregister", method = RequestMethod.POST)
	public String trySave(@Valid @ModelAttribute("Director") Director director, Model model) {
		director.setDirector_release_datetime(LocalDateTime.now());
		director.setDirector_password(converter.toMD5(director.getDirector_password()));
		directorService.saveDirectorDB(director);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage( Model model) {
		model.addAttribute("Director", new Director());
		return "login";
	}
	
	@RequestMapping(value = "/trylogin", method = RequestMethod.POST)
	public String tryLogin(@Valid @ModelAttribute("Director") Director director,
			Model model) {
		Director directorx = directorService.getDirectorByEmailAndPassword(director.getDirector_email(), converter.toMD5(director.getDirector_password()));
		try {
			if (directorx.getDirector_password() == null) {
				return "redirect:/login";
			}else {
				userlogged = directorx.getDirector_name();
				return "redirect:/home?user="+userlogged;
			}
		}catch(Exception ex) {
			return "redirect:/login";
		}
	}
	
	@RequestMapping("home")
	public String homePage(Model model, @RequestParam("user") String name) {
		model.addAttribute("mensaje", "Bienvenido, "+name);
		return "logged";
	}
	
	@RequestMapping(value= "/listaAlumnos" , method = RequestMethod.GET)
	public String listaAlumnos(Model model) {
		model.addAttribute("alumnos", alumnoService.getAllAlumnosDB());
		return "mostrarAlumnos";
	}
	
	@RequestMapping(value = "/guardarAlumno", method = RequestMethod.GET)
	public String guardarAlumnoPage(Model model) {
		model.addAttribute("Alumno", new Alumno());
		return "guardarAlumno";
	}
	
	@RequestMapping(value = "/saveAlumno", method = RequestMethod.POST)
	public String trySaveAlumno(@Valid @ModelAttribute("Alumno") Alumno alumno, Model model) {
		alumno.setAlumno_release_datetime(LocalDateTime.now());
		alumnoService.saveAlumnoDB(alumno);
		return "redirect:/home?user="+userlogged;
	}
	
	@RequestMapping(value = "/volver", method = RequestMethod.GET)
	public String volver(Model model) {
		return "redirect:/home?user="+userlogged;
	}
	
	@PostMapping("/deleteAlumno")
	public String deleteAllUsers(Model model) {
		model.addAttribute("Alumno", new Alumno());
		return "delete";
	}
	
	@GetMapping("/delete")
	public String deleteUser(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("deleteid"));
		alumnoService.deleteAlumnoDB(id);
		return "Successfully deleted the specified entry of this database";
	}
	
}
