package be.formation.java.repasdom.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import be.formation.java.repasdom.model.entity.Menu;
import be.formation.java.repasdom.service.MenuService;

@Controller
public class HomeController {
	
	private final MenuService menuService;

	public HomeController(MenuService menuService) {
		super();
		this.menuService = menuService;
	}
	
	@GetMapping("/RepasDom")
	public String index(Model model) {
		List<Menu> menus = menuService.getMenusToOrder();
		model.addAttribute("menus", menus);
		return "listeMenus";
	}
	
	@GetMapping("/AfficherMenu/{id}")
	public String afficherMenu(@PathVariable("id") Long id, Model model) {
		Menu menu = menuService.read(id);
		model.addAttribute("menu", menu);
		return "afficherMenu";
	}
	

}
