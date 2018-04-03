package be.formation.java.repasdom.service;

import java.util.List;

import be.formation.java.repasdom.model.entity.Menu;
import be.formation.java.repasdom.model.entity.MenuDuJour;
import be.formation.java.repasdom.model.entity.Plat;

public interface MenuDuJourService {

	void create(MenuDuJour menuDuJour);
	
	List<MenuDuJour> read();
	
	MenuDuJour read(Long id);
	
	void update(Long id, MenuDuJour menuDuJour);
	
	void delete(Long id);

	void create(Menu menu, Plat plat, double prix);
	
}
