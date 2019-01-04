package lt.iamus.task.entity;

import java.io.Serializable;
import javax.persistence.*;

@NamedQueries ({
	@NamedQuery (name="weatherList", query="SELECT w FROM Weather w WHERE w.city = :city")
})

@Entity
@NamedQuery(name="Weather.findAll", query="SELECT w FROM Weather w")
public class Weather implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String city;

	private double humidity;

	private double pressure;

	private double temp;

	private String tstamp;

	public Weather() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getHumidity() {
		return this.humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getPressure() {
		return this.pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getTemp() {
		return this.temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public String getTstamp() {
		return this.tstamp;
	}

	public void setTstamp(String tstamp) {
		this.tstamp = tstamp;
	}

}