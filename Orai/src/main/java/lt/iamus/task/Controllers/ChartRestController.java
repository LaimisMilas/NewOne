package lt.iamus.task.Controllers;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lt.iamus.task.Services.EnergyConsumedService;
import lt.iamus.task.entity.EnergyConsumed;

@RestController
public class ChartRestController {
	
	@Autowired
	private EnergyConsumedService energyConsumedService;
	
	@PostMapping ("getChartData")
	public List<EnergyConsumed> getDate (@RequestParam ("tenant") String tenant) {
		System.out.println(tenant);
		int year = 2018;
		int month = 12;
		int day = 4;
		String date = "";
		List<EnergyConsumed> engCnsmdList = new LinkedList<EnergyConsumed>();
		for (int i=1; i>0; i++) {			
		try {
			switch (month) {
				case 1: case 3: case 5: case 7: case 8: case 10: 
				if (day>=32) {day=1; month++;}	
					break;
				case 2 :
					if(day>=29) {day=1; month++;}
					break;
				case 4: case 6: case 9: case 11:
					if (day>=31) {day=1; month++;}
					break;
				case 12:
					if (day>=32) {day=1; month=1; year++;}
					break;
			}
			
			String monthStr = ""+month;
			String dayStr = ""+day;
			if (day<10) {
				dayStr = String.format("%02d", day);
			}
			if (month<10) {
				monthStr = String.format("%02d", month);
			}
			
			date = ""+year+"-"+monthStr+"-"+dayStr+"%";
			String setDate = ""+year+"-"+monthStr+"-"+dayStr;
			EnergyConsumed energyConsumed = energyConsumedService.getEngCnsmdToChart(tenant, date);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Timestamp ts = new Timestamp(((java.util.Date)df.parse(setDate)).getTime());
			energyConsumed.setDate(ts);
			engCnsmdList.add(energyConsumed);
			System.out.println("suveike TRY "+engCnsmdList.size());
		
			} catch (Exception e) {
				System.out.println("suveike CATCH "+date);
				System.out.println(engCnsmdList.size());
				return engCnsmdList;
			}
		day++;
		}
			return engCnsmdList; 
	}
}
