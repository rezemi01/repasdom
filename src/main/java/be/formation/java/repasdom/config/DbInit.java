package be.formation.java.repasdom.config;

import java.time.LocalDate;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import be.formation.java.repasdom.model.entity.Menu;
import be.formation.java.repasdom.model.entity.Plat;
import be.formation.java.repasdom.model.entity.TypePlat;
import be.formation.java.repasdom.repository.MenuRepository;
import be.formation.java.repasdom.repository.PlatRepository;
import be.formation.java.repasdom.repository.TypePlatRepository;
import be.formation.java.repasdom.service.MenuDuJourService;
import be.formation.java.repasdom.service.MenuService;
import be.formation.java.repasdom.service.PlatService;
import be.formation.java.repasdom.service.TypePlatService;

@Configuration
public class DbInit implements InitializingBean {

	private final TypePlatService typePlatService;
	private final PlatService platService;
	private final MenuService menuService;
	private final MenuDuJourService menuDuJourService;
	
	private final TypePlatRepository typePlatRepository;
	private final PlatRepository platRepository;
	private final MenuRepository menuRepository;
	
	public DbInit(TypePlatService typePlatService, PlatService platService, MenuService menuService,
			MenuDuJourService menuDuJourService, TypePlatRepository typePlatRepository, PlatRepository platRepository,
			MenuRepository menuRepository) {
		super();
		this.typePlatService = typePlatService;
		this.platService = platService;
		this.menuService = menuService;
		this.menuDuJourService = menuDuJourService;
		this.typePlatRepository = typePlatRepository;
		this.platRepository = platRepository;
		this.menuRepository = menuRepository;
	}


	@Override
	public void afterPropertiesSet() throws Exception {

		// Création temporaire des types de plat
		typePlatService.create("Entrée");
		typePlatService.create("Plat principal");
		typePlatService.create("Dessert");
		
		// Création temporaire des plats
		TypePlat typePlat = typePlatRepository.findByLibelle("Entrée");
		platService.create("Carpaccio de boeuf", "Fines tranches de boeuf marinées au gingembre et accompagnées d'une salade de roquette.", "http://cache.marieclaire.fr/data/photo/w999_c17/cuisine/43/boeuf5.jpg", typePlat);
		platService.create("Soupe de concombre", "Soupe de concombre avec en garniture des oeufs durs.", "https://static.cuisineaz.com/610x610/i129493-soupe-concombre-poivrons.jpeg", typePlat);
		platService.create("Soupe de potiron", "Soupe de potiron, oignons avec de la crème fraîche.", "https://www.marciatack.fr/wp-content/uploads/2015/10/soupe-potiron-450x450-1.jpg", typePlat);
		platService.create("Soupe de poireaux", "Soupe de poireaux, pommes de terre, carottes et oignons, contient de la crème.", "https://image.afcdn.com/recipe/20171205/75841_w420h344c1cx3680cy2456cxt0cyt0cxb7360cyb4912.jpg", typePlat);
		platService.create("Chèvre chaud", "Petit fromage de chèvre et sa salade.", "https://i.pinimg.com/originals/ee/5b/f5/ee5bf5c74504b51d31b666cfada09887.jpg", typePlat);
		platService.create("Farci de la mer sur son lit de salade", "Tomate farcie aux surimis, oeufs, avocat et mayonnaise.", "http://i43.servimg.com/u/f43/09/03/28/48/farcis12.jpg", typePlat);
		typePlat = typePlatRepository.findByLibelle("Plat principal");
		platService.create("Spaghetti bolognèse", "Spaghetti sauce tomate, boeuf, basilic.", "https://image.afcdn.com/recipe/20160419/14652_w1024h768c1cx2420cy1872.jpg", typePlat);
		platService.create("Darne de saumon", "Darne de saumon aux épinards et fromage frais à l'ail et fines herbes.", "http://www.belfoodservice.ch/webautor-data/7/Darne_saumon.jpg", typePlat);
		platService.create("Quiche au bacon", "Quiche aux épinards et bacon.", "http://everydaydishes.com/wp-content/uploads/2015/09/bacon-spinach-quiche-everydaydishes_com-H-1-740x486.jpg", typePlat);
		platService.create("Poulet basquaise", "Poulet au poivrons, tomates, oignons, riz de Camargue.", "https://www.foodette.fr/files/products/img_4915_aveclogoweb.jpg", typePlat);
		platService.create("Boeuf bourguignon", "Pavé de boeuf aux carottes et oignons.", "https://www.atelierdeschefs.com/media/recette-d17911-pave-de-boeuf-aux-pommes-boulangeres-carottes-vichy-sauce-a-la-bourguignonne.jpg", typePlat);
		platService.create("Cabillaud à la parisienne", "Cabillaud sauce aux champignons et tomates.", "http://static.750g.com/images/600-600/e66053cca52d3799da09e8716f315782/cocotte-de-quenelles-a-la-sauce-tomate.png", typePlat);
		typePlat = typePlatRepository.findByLibelle("Dessert");
		platService.create("Mousse au chocolat", "Mousse au chocolat noir et à la crème.", "https://static.cuisineaz.com/240x192/i45681-mousse-au-chocolat-a-la-creme-fleurette.jpg", typePlat);
		platService.create("Tiramisu", "Tiramisu traditionnel au mascarpone et café.", "http://static.750g.com/images/622-auto/c2c7ae77368260f6a591cb69e9f0c136/tiramisu.jpg", typePlat);
		platService.create("Glace à la compote de fraise", "Glace à la fraise avec fruits rouges, fraises, groseilles, framboises.", "https://www.metro.ca/userfiles/image/recipes/sorbet-fraises-menthe-givree-4948.jpg", typePlat);
		platService.create("Crème caramel", "Crème caramel, zestes d'orange.", "http://cdnwp.audiencemedia.com/wp-content/uploads/2014/11/414892-1-eng-GB_del02.106-470x540.jpg", typePlat);
		platService.create("Tartelette au citron", "Tartelette au citron et à la crème fraîche.", "http://www.delices-du-monde.fr/photos-recettes/zoom/01-tartelettes-au-citron.jpg", typePlat);
		platService.create("Poêlée de pommes et poires caramélisées", "Pommes et poires caramélisées, miel et glace vanille.", "https://maison2.advcdn.net/images/medias/000/016/000016418/660.jpg", typePlat);

		// Création temporaire des menus
		LocalDate date = LocalDate.of(2018, 04, 3);
		menuService.create("Menu 1", "Soupe concombre - Spaghetti bolognèse - Glace à la fraise", "", date);
		date = LocalDate.of(2018, 04, 4);
		menuService.create("Menu 2", "Soupe potiron - Quiche bacon - Tiramisu", "", date);
		date = LocalDate.of(2018, 04, 5);
		menuService.create("Menu 3", "Chèvre chaud - Darne de saumon - Crème caramel", "", date);
		date = LocalDate.of(2018, 04, 6);
		menuService.create("Menu 4", "Soupe de poireaux - Boeuf bourguignon - Mousse au chocolat", "", date);
		date = LocalDate.of(2018, 04, 7);
		menuService.create("Menu 5", "Carpaccio de boeuf - Cabillaud - Tartelette au citron", "", date);
		date = LocalDate.of(2018, 04, 8);
		menuService.create("Menu 6", "Tomate farcie surimi - Poulet basquaise - Poêlée pommes poires ", "", date);
		
		// Création temporaire des menus du jour
		Menu menu1 = menuRepository.findByNom("Menu 1");
		Plat plat1 = platRepository.findByNom("Soupe de concombre");
		menuDuJourService.create(menu1, plat1, 2.5);
		Plat plat2 = platRepository.findByNom("Spaghetti bolognèse");
		menuDuJourService.create(menu1, plat2, 4.5);
		Plat plat3 = platRepository.findByNom("Glace à la compote de fraise");
		menuDuJourService.create(menu1, plat3, 2.5);
		
		Menu menu2 = menuRepository.findByNom("Menu 2");
		plat1 = platRepository.findByNom("Soupe de potiron");
		menuDuJourService.create(menu2, plat1, 2.5);
		plat2 = platRepository.findByNom("Quiche au bacon");
		menuDuJourService.create(menu2, plat2, 3.85);
		plat3 = platRepository.findByNom("Tiramisu");
		menuDuJourService.create(menu2, plat3, 2.5);		

		Menu menu3 = menuRepository.findByNom("Menu 3");
		plat1 = platRepository.findByNom("Chèvre chaud");
		menuDuJourService.create(menu3, plat1, 3.5);
		plat2 = platRepository.findByNom("Darne de saumon");
		menuDuJourService.create(menu3, plat2, 6.5);
		plat3 = platRepository.findByNom("Crème caramel");
		menuDuJourService.create(menu3, plat3, 2.5);		
		
		Menu menu4 = menuRepository.findByNom("Menu 4");
		plat1 = platRepository.findByNom("Soupe de poireaux");
		menuDuJourService.create(menu4, plat1, 2.5);
		plat2 = platRepository.findByNom("Boeuf bourguignon");
		menuDuJourService.create(menu4, plat2, 6.75);
		plat3 = platRepository.findByNom("Mousse au chocolat");
		menuDuJourService.create(menu4, plat3, 2.5);		

		Menu menu5 = menuRepository.findByNom("Menu 5");
		plat1 = platRepository.findByNom("Carpaccio de boeuf");
		menuDuJourService.create(menu5, plat1, 3.5);
		plat2 = platRepository.findByNom("Cabillaud à la parisienne");
		menuDuJourService.create(menu5, plat2, 6.5);
		plat3 = platRepository.findByNom("Tartelette au citron");
		menuDuJourService.create(menu5, plat3, 3.5);		

		Menu menu6 = menuRepository.findByNom("Menu 6");
		plat1 = platRepository.findByNom("Farci de la mer sur son lit de salade");
		menuDuJourService.create(menu6, plat1, 3.5);
		plat2 = platRepository.findByNom("Poulet basquaise");
		menuDuJourService.create(menu6, plat2, 6.5);
		plat3 = platRepository.findByNom("Poêlée de pommes et poires caramélisées");
		menuDuJourService.create(menu6, plat3, 3.5);		

		
	}

}
