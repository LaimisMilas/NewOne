package lt.iamus.task.Controllers;

import java.sql.Timestamp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lt.iamus.task.Services.BuildingService;
import lt.iamus.task.Services.DevicelogService;
import lt.iamus.task.Services.EnergyConsumedService;
import lt.iamus.task.entity.Building;
import lt.iamus.task.entity.Devicelog;

@Controller
public class TenantController {
	
	@Autowired
	private DevicelogService devicelogService;
	@Autowired
	private EnergyConsumedService energyConsumedService;
	@Autowired
	private BuildingService buildingService;
	
	@GetMapping("/tenantList")
	public String getTenantList (Model model) {
		model.addAttribute("tenantList", devicelogService.getTenantList());
		return "tenantList";
	}
	
	@GetMapping("/showMore")
	public String showMore (@RequestParam ("tenant") String tenant, Model model) {
		if(devicelogService.findTenantInfo(tenant).size() == 0) {
			return "redirect:/tenantList";
		}
		model.addAttribute("tenantList", devicelogService.findTenantInfo(tenant));
		return "tenantInfo";
	}
	
	@GetMapping("/dltTenant")
	public String dltTenant (@RequestParam ("dltTenant") String tenant) {
		energyConsumedService.deleteEngCnsd(tenant);
		Devicelog devicelog = devicelogService.findDevice(tenant);
		buildingService.deleteBuilding(devicelog.getBuildingId());
		devicelogService.dltTenant(tenant);
		return "redirect:/tenantList";
	}
	
	@GetMapping("/addTenant")
	public String addTenantGET (Model model) {
		return "addTenant";
	}
	
	@PostMapping("/addTenant")
	public String addTenantPOST (@RequestParam ("tenantName") String tenantName, @RequestParam ("source") String source, 
			@RequestParam ("device") String device, @RequestParam ("property") String property, 
			@RequestParam ("energetinisKof") Double energetinisKof, @RequestParam ("aukstis") Double aukstis, 
			@RequestParam ("plotas") Double plotas, Model model) {
		if (tenantName==null || tenantName.length()<=4) {
			model.addAttribute("tenantError", "Tenant name can't be empty and must be between 4 and 64 letter");
		}
		if (source==null || source.length()<=4) {
			model.addAttribute("sourceError", "Source can't be empty and must be between 4 and 128 letter");
		}
		if (device.equals("Choose Device")) {
			model.addAttribute("deviceError", "Choose Device");
		}
		if (property==null || property.length()<=4) {
			model.addAttribute("propertyError", "Property can't be empty and must be between 4 and 128 letter");
		}
		
		if(energetinisKof == null || aukstis == null || plotas == null) {
			model.addAttribute("buildingEmpty", "Fields can't be empty");
			return "addTenant";
		}
		if (tenantName==null || tenantName.length()<=4 || source==null || source.length()<=4 || 
				device.equals("Choose Device") || property==null || property.length()<=4)  {
			return "addTenant";
		}
			Building building = new Building();
			building.setEnergetinisKof(energetinisKof);
			building.setAukstis(aukstis);
			int plotasInt = plotas.intValue();
			building.setPlotas(plotasInt);
			buildingService.addBuilding(building);
			Integer buildingId = buildingService.findLastBuilding();

			if (buildingId!=null) {
				Devicelog devicelog = new Devicelog();
				devicelog.setTenant(tenantName);
				devicelog.setSource(source);
				devicelog.setDevice(device);
				devicelog.setProperty(property);
				String devicetype = "";
				if(device.equals("1644302641")) {devicetype="Pressure";
						} else if(device.equals("1644302641_1")) {devicetype="Temperature";
						} else {devicetype="Humidity";}
				devicelog.setDevicetype(devicetype);
				devicelog.setBuildingId(buildingId);
				devicelog.setTstamp(new Timestamp(System.currentTimeMillis()));
				devicelogService.addDevice(devicelog);
			}
		return "redirect:/tenantList";
	}
	
	@GetMapping("/updateTenant")
	public String updateTenantGET (@RequestParam ("tenant") String tenant, Model model) {
		model.addAttribute("tenant", devicelogService.findDevice(tenant));
		return "updateTenant";
	}
	
	@PostMapping("/updateTenant")
	public String updateTenantPOST (@ModelAttribute ("tenant") Devicelog devicelog, @RequestParam ("oldTenantName") String oldTenantName) {
		try {
			energyConsumedService.updateEnergyConsumed(oldTenantName, devicelog.getTenant());
			devicelogService.updateTenant(oldTenantName, devicelog);
		} catch (Exception e) {
			devicelogService.updateTenant(oldTenantName, devicelog);
		}
		return "redirect:/tenantList";
	}
	
	/*
	 * Panaikyna nereikalingus tarpus priekyje ir pabaigoje
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor stEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stEditor);
	}
	

}
