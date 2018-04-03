package be.formation.java.repasdom.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande extends BaseEntity {

	@Column(nullable=false)
	private LocalDateTime dateCmd;
	
	@Column(nullable=false)
	private boolean paye;
	
	@ManyToOne
	@JoinColumn(name="id_client", nullable=false)
	private Client client;

	@OneToMany(mappedBy="plat", fetch=FetchType.LAZY)
	private List<LigneCommande> ligneCommande;

	public Commande() {
		super();
	}

	public LocalDateTime getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(LocalDateTime dateCmd) {
		this.dateCmd = dateCmd;
	}

	public boolean isPaye() {
		return paye;
	}

	public void setPaye(boolean paye) {
		this.paye = paye;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LigneCommande> getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(List<LigneCommande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	
}
