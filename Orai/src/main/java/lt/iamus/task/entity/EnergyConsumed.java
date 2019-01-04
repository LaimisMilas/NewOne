package lt.iamus.task.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the energy_consumed database table.
 * 
 */
@Entity
@Table(name="energy_consumed")
@NamedQuery(name="EnergyConsumed.findAll", query="SELECT e FROM EnergyConsumed e")
public class EnergyConsumed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="building_id")
	private int buildingId;

	private Timestamp date;

	@Column(name="energy_kwh")
	private double energyKwh;

	@Column(name="tenant_id")
	private int tenantId;

	@Column(name="tenant_name")
	private String tenantName;

	@Column(name="used_energy")
	private double usedEnergy;

	public EnergyConsumed() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuildingId() {
		return this.buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public double getEnergyKwh() {
		return this.energyKwh;
	}

	public void setEnergyKwh(double energyKwh) {
		this.energyKwh = energyKwh;
	}

	public int getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantName() {
		return this.tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public double getUsedEnergy() {
		return this.usedEnergy;
	}

	public void setUsedEnergy(double usedEnergy) {
		this.usedEnergy = usedEnergy;
	}

}