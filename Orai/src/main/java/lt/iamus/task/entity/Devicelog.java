package lt.iamus.task.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

import java.sql.Timestamp;

@Entity
@NamedQuery(name="Devicelog.findAll", query="SELECT d FROM Devicelog d")
public class Devicelog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="building_id")
	private int buildingId;

	@Column(name="dev_custid")
	private Integer devCustid;
	
	@NotNull
	@Size (min=4, max=255, message="Device Id must be between 4 and 255 letter")
	private String device;

	private String devicetype;

	private double dval;

	private Timestamp expires;
	
	@NotNull
	@Size (min=4, max=128, message="Property must be between 4 and 128 letter")
	private String property;
	
	@NotNull
	@Size (min=4, max=128, message="Source must be between 4 and 128 letter")
	private String source;

	private String sval;
	
	@NotNull (message="Field Can't Be Empty")
	@Size (min=4, max=64, message="Tenant name must be between 4 and 64 letter")
	private String tenant;

	private Timestamp tstamp;

	public Devicelog() {
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

	public Integer getDevCustid() {
		return this.devCustid;
	}

	public void setDevCustid(Integer devCustid) {
		this.devCustid = devCustid;
	}

	public String getDevice() {
		return this.device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDevicetype() {
		return this.devicetype;
	}

	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
	}

	public double getDval() {
		return this.dval;
	}

	public void setDval(double dval) {
		this.dval = dval;
	}

	public Timestamp getExpires() {
		return this.expires;
	}

	public void setExpires(Timestamp expires) {
		this.expires = expires;
	}

	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSval() {
		return this.sval;
	}

	public void setSval(String sval) {
		this.sval = sval;
	}

	public String getTenant() {
		return this.tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public Timestamp getTstamp() {
		return this.tstamp;
	}

	public void setTstamp(Timestamp tstamp) {
		this.tstamp = tstamp;
	}

}