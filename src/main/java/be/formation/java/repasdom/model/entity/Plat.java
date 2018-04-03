package be.formation.java.repasdom.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Plat extends BaseEntity {
	
	@Column(nullable=false)
	private String nom;
	
	private String description;
	
	private String imageUrl;

	@ManyToOne
	@JoinColumn(name="idType", nullable=false)
	private TypePlat typePlat;
	
	@OneToMany(mappedBy="plat", fetch=FetchType.LAZY)
	private List<MenuDuJour> menuDuJour;
	
	@OneToMany(mappedBy="plat", fetch=FetchType.LAZY)
	private List<LigneCommande> ligneCommande;
	
	public Plat() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public TypePlat getTypePlat() {
		return typePlat;
	}

	public void setTypePlat(TypePlat typePlat) {
		this.typePlat = typePlat;
	}

	public List<MenuDuJour> getMenuDuJour() {
		return menuDuJour;
	}

	public void setMenuDuJour(List<MenuDuJour> menuDuJour) {
		this.menuDuJour = menuDuJour;
	}

	public List<LigneCommande> getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(List<LigneCommande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	
	
}
