package lt.iamus.task.Services;

import java.util.List;

import lt.iamus.task.entity.Weather;

public interface WeatherService {
	public void addWeatherInfo(Weather weather);
	public List<Weather> getWeatherList (String city);
	public void deleteInscription (int id);
	public double getTemp (String city, String data);
	public List<Weather> getWeatherListByDate (String city, String date);
	
}
