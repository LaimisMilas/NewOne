package lt.iamus.task.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the building database table.
 * 
 */
@Entity
@NamedQuery(name="Building.findAll", query="SELECT b FROM Building b")
public class Building implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private double aukstis;
	@NotNull
	@Column(name="energetinis_kof")
	private double energetinisKof;
	@NotNull
	private int plotas;

	public Building() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAukstis() {
		return this.aukstis;
	}

	public void setAukstis(double aukstis) {
		this.aukstis = aukstis;
	}

	public double getEnergetinisKof() {
		return this.energetinisKof;
	}

	public void setEnergetinisKof(double energetinisKof) {
		this.energetinisKof = energetinisKof;
	}

	public int getPlotas() {
		return this.plotas;
	}

	public void setPlotas(int plotas) {
		this.plotas = plotas;
	}

}