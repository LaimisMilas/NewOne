package lt.iamus.task.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lt.iamus.task.Services.DevicelogService;

@Controller
public class ChartController {
	
	@Autowired
	private DevicelogService devicelogService;
	
	@GetMapping("/tenantListChart")
	public String getTenantList (Model model) {
		model.addAttribute("tenantList", devicelogService.getTenantList());
		return "energyConsumption";
	}
	
	@GetMapping("/showChart")
	public String showChart (@RequestParam ("tenant") String tenantName, Model model) {
		model.addAttribute("tenantName", tenantName);
		return "chart";
	}

}
