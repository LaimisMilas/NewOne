package lt.iamus.task.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.iamus.task.DAO.WeatherDAO;
import lt.iamus.task.entity.Weather;

@Service
@Transactional
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherDAO weatherDAO;
	
	@Override
	public void addWeatherInfo(Weather weather) {
		weatherDAO.addWeatherInfo(weather);
	}

	@Override
	public List<Weather> getWeatherList(String city) {
		return weatherDAO.getWeatherList(city);
	}

	@Override
	public void deleteInscription(int id) {
		Weather weather = weatherDAO.findInscription(id);
		weatherDAO.deleteInscription(weather);	
	}

	@Override
	public double getTemp(String city, String data) {
		return weatherDAO.getTemp(city, data);
	}

	@Override
	public List<Weather> getWeatherListByDate(String city, String date) {
		return weatherDAO.getWeatherListByDate(city, date);
	}

	
}
