package lt.iamus.task.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lt.iamus.task.entity.Devicelog;

@Repository
public class DevicelogDAOImpl implements DevicelogDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addDevice(Devicelog devicelog) {
		Session session = sessionFactory.getCurrentSession();
		session.save(devicelog);
	}
	/*
	 * (non-Javadoc)
	 * @see lt.iamus.task.DAO.DevicelogDAO#getDeviceList()
	 * Grazina visus irasus ir DB
	 */
	@Override
	public List<Devicelog> getDeviceList() {
		Session session = sessionFactory.getCurrentSession();
		List<Devicelog> devicesList = session.createQuery("FROM Devicelog", Devicelog.class).getResultList();
		return devicesList;
	}

	@Override
	public void dltDeviceRecord (Devicelog devicelog) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(devicelog);
	}

	@Override
	public Devicelog findDevice(int id) {
		Session session = sessionFactory.getCurrentSession();
		Devicelog devicelog = session.find(Devicelog.class, id);
		return devicelog;
	}

	@Override
	public void updateDevice(Devicelog devicelog) {
		Session session = sessionFactory.getCurrentSession();
		session.update(devicelog);
	}
	/*
	 * (non-Javadoc)
	 * @see lt.iamus.task.DAO.DevicelogDAO#getTenantList()
	 * Grazina skirtingu nuomininku sarasa
	 */
	@Override
	public List<Devicelog> getTenantList() {
		Session session = sessionFactory.getCurrentSession();
		List<Devicelog> tenantList = session.createNativeQuery("SELECT * FROM devicelog GROUP BY tenant", Devicelog.class).getResultList();
		return tenantList;
	}

	@Override
	public List<Devicelog> findTenantInfo(String tenant) {
		Session session = sessionFactory.getCurrentSession();
		List<Devicelog> tenantInfoList = session.createNativeQuery("SELECT * FROM devicelog WHERE tenant = ?", Devicelog.class).setParameter(1, tenant).getResultList();
		return tenantInfoList;
	}
	
	@Override
	public void dltTenant(String tenant) {
		Session session = sessionFactory.getCurrentSession();
		session.createNativeQuery("DELETE FROM devicelog WHERE tenant = ?").setParameter(1, tenant).executeUpdate();
	}
	@Override
	public Devicelog findDevice(String tenant) {
		Session session = sessionFactory.getCurrentSession();
		Devicelog devicelog = session.createNativeQuery("SELECT * FROM devicelog WHERE tenant = ? ORDER BY tstamp DESC LIMIT 1", Devicelog.class)
				.setParameter(1, tenant).getSingleResult();
		return devicelog;
	}
	@Override
	public void updateTenant(String oldTenantName, Devicelog devicelog) {
		Session session = sessionFactory.getCurrentSession();
		session.createNativeQuery("UPDATE devicelog SET tenant= ?, source = ?, property = ? WHERE tenant = ?")
		.setParameter(1, devicelog.getTenant()).setParameter(2, devicelog.getSource())
		.setParameter(3, devicelog.getProperty()).setParameter(4, oldTenantName).executeUpdate();
	}
	@Override
	public double getAvgTemp(String tenantName, String data) {
		Session session = sessionFactory.getCurrentSession();
		double avgTemp = (double) session.createNativeQuery("SELECT AVG(dval) FROM devicelog WHERE tenant = ? AND devicetype = 'Temperature' AND tstamp LIKE ?")
		.setParameter(1, tenantName).setParameter(2, data).getSingleResult();
		return avgTemp;
	}

}
