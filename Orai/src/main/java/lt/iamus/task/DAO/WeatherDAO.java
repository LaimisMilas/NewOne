package lt.iamus.task.DAO;

import java.util.List;

import lt.iamus.task.entity.Weather;

public interface WeatherDAO {
	public void addWeatherInfo(Weather weather);
	public List<Weather> getWeatherList (String city);
	public void deleteInscription (Weather weather);
	public Weather findInscription (int id);
	public double getTemp (String city, String data);
	public List<Weather> getWeatherListByDate (String city, String date);
}
