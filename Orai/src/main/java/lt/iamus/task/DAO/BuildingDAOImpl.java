package lt.iamus.task.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lt.iamus.task.entity.Building;

@Repository
public class BuildingDAOImpl implements BuildingDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addBuilding(Building building) {
		Session session = sessionFactory.getCurrentSession();
		session.save(building);
	}

	@Override
	public Building findBuilding(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Building.class, id);
	}

	@Override
	public int findLastBuilding() {
		Session session = sessionFactory.getCurrentSession();
		Building building = session.createNativeQuery("SELECT * FROM building ORDER BY id DESC LIMIT 1", Building.class).getSingleResult();
		return building.getId();
	}

	@Override
	public void deleteBuilding(Building building) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(building);
	}
}
