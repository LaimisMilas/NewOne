package lt.iamus.task.Services;

import lt.iamus.task.entity.Building;

public interface BuildingService {
	public void addBuilding (Building building);
	public Building findBuilding (int id);
	public int findLastBuilding ();
	public double getKof (int buildingId);
	public void deleteBuilding (int id);

}
