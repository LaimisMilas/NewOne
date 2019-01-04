package lt.iamus.task.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.iamus.task.DAO.BuildingDAO;
import lt.iamus.task.entity.Building;

@Service
@Transactional
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingDAO buildingDAO;
	@Override
	public void addBuilding(Building building) {
		buildingDAO.addBuilding(building);
	}
	@Override
	public Building findBuilding(int id) {
		return buildingDAO.findBuilding(id);
	}
	@Override
	public int findLastBuilding() {
		return buildingDAO.findLastBuilding();
	}
	@Override
	public double getKof(int buildingId) {
		Building building = buildingDAO.findBuilding(buildingId);
		/*
		 * Suskaiciuojamas pastato turis, tuomet padauginama is pastato silumos koeficiento
		 *  ir padalinama is 860. Taip skaiciuojamas energijos kiekis (kW/h) reikalingas sildytina patalpa
		 *  vienai valandai
		 */
		return building.getAukstis() * building.getPlotas() * building.getEnergetinisKof() / 860;
	}
	@Override
	public void deleteBuilding(int id) {
		Building building = buildingDAO.findBuilding(id);
		buildingDAO.deleteBuilding(building);		
	}
	

}
