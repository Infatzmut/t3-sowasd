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

import com.upn.restaurant.model.entity.Pedido;
import com.upn.restaurant.model.entity.Plato;
import com.upn.restaurant.service.PedidoService;
import com.upn.restaurant.service.PlatoService;




@Controller
@RequestMapping("/plato")
@SessionAttributes( {"plato", "pedido" } )
public class PedidoController {

	
	private PlatoService platoService;
	
	
	private PedidoService pedidoService;
	
	@Autowired
	//private PacienteService pacienteService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Plato> platos = platoService.findAll();
			model.addAttribute("Plato", platos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/pedido/inicio";
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
		
		return "/pedido/edit";
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
		Plato platos = new Plato();
		model.addAttribute("plato", platos);
		try {
			List<Plato> listaPlatos = 
					platoService.findAll();
			model.addAttribute("plato", listaPlatos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/platos/nuevo";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Pedido> pedidos = pedidoService.findById(id);
			if(pedidos.isPresent()) {
				pedidoService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Pedido> pedidos = pedidoService.findAll();
				model.addAttribute("pedido", pedidos);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/pedido/inicio";
		}
		return "redirect:/pedido";
	}@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Pedido> pedido = pedidoService.findById(id);
			if(pedido.isPresent()) {
				model.addAttribute("pedido", pedido.get());
			} else {
				return "redirect:/pedido";
			}
		} catch (Exception e) {

		}	
		
		return "/pedido/info";
	}
	
	@GetMapping("/{id}/nuevoplato")
	public String nuevoPlato(@PathVariable("id") int id, Model model) {
		Plato plato = new Plato();
		try {
			Optional<Pedido> pedido = pedidoService.findById(id);
			if(pedido.isPresent()) {
				plato.setPedido(pedido.get());
				model.addAttribute("plato", plato);
			} else {
				return "redirect:/pedido";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/pedido/nuevoplato";
	}
	
	@PostMapping("/saveplato")
	public String savePlato(@ModelAttribute("plato") Plato plato, 
			Model model, SessionStatus status) {
		try {
			platoService.save(plato);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/pedido/info/" + plato.getPedido().getId();
	}
	
}
