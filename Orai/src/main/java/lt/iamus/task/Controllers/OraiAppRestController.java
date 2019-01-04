package lt.iamus.task.Controllers;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lt.iamus.task.Services.WeatherService;
import lt.iamus.task.entity.Weather;

@RestController
@RequestMapping ("/api")
public class OraiAppRestController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("getWeather")
	public Weather getWeather (@RequestParam ("temp") Double temp, @RequestParam ("pressure") Double pressure, 
			@RequestParam ("humidity") Double humidity, @RequestParam ("city") String city) {
		Weather weather = new Weather();
		weather.setCity(city);
		weather.setTemp(temp);
		weather.setPressure(pressure);
		weather.setHumidity(humidity);
		weather.setTstamp(new Timestamp(System.currentTimeMillis()).toString());
		weatherService.addWeatherInfo(weather);
		return weather;
	}
}
