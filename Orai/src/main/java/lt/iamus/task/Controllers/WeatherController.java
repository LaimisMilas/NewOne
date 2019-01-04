package lt.iamus.task.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lt.iamus.task.Services.WeatherService;

@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/getList")
	public String getList (@RequestParam ("city") String city, Model model) {
		model.addAttribute("weatherList", weatherService.getWeatherList(city));
		return "weatherList";
	}

}
