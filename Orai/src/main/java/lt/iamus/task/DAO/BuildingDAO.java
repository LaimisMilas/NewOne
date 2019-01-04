package lt.iamus.task.DAO;

import lt.iamus.task.entity.Building;

public interface BuildingDAO {
	public void addBuilding (Building building);
	public Building findBuilding (int id);
	public int findLastBuilding ();
	public void deleteBuilding (Building building);
}
