package com.upn.restaurant.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import com.upn.restaurant.model.entity.Plato;
import com.upn.restaurant.service.PlatoService;




@Controller
@RequestMapping("/plato")
@SessionAttributes( {"plato"} )
public class PlatoController {

	@Autowired
	private PlatoService platoService;
	
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Plato> platos = platoService.findAll();
			model.addAttribute("platos", platos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/plato/inicio";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Plato> optional = platoService.findById(id);
			if (optional.isPresent()) {
				
				
				
				model.addAttribute("plato", optional.get());
				
			} else {
				return "redirect:/plato";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/plato/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("cliente") Plato plato, 
			Model model, SessionStatus status) {
		try {
			platoService.save(plato);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/plato";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Plato plato = new Plato();
		model.addAttribute("plato", plato);
		try {
			List<Plato> platos = 
					platoService.findAll();
			model.addAttribute("platos", platos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/plato/nuevo";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Plato> platos = platoService.findById(id);
			if(platos.isPresent()) {
				platoService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Plato> platos = platoService.findAll();
				model.addAttribute("plato", platos);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/plato/inicio";
		}
		return "redirect:/plato";
	}@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Plato> plato = platoService.findById(id);
			if(plato.isPresent()) {
				model.addAttribute("plato", plato.get());
			} else {
				return "redirect:/plato";
			}
		} catch (Exception e) {

		}	
		
		return "/plato/info";
	}
	
	
}
