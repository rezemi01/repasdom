package be.formation.java.repasdom.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.formation.java.repasdom.model.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

	Menu findByNom(String nom);
	
	List<Menu> findAllByDateAfterOrderByDate(LocalDate now);
}
