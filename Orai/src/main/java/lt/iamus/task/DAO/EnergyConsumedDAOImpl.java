package lt.iamus.task.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lt.iamus.task.entity.EnergyConsumed;

@Repository
public class EnergyConsumedDAOImpl implements EnergyConsumedDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addEnergyConsumed(EnergyConsumed energyConsumed) {
		Session session = sessionFactory.getCurrentSession();
		session.save(energyConsumed);
	}
	@Override
	public void updateEnergyConsumed(EnergyConsumed energyConsumed) {
		Session session = sessionFactory.getCurrentSession();
		session.update(energyConsumed);		
	}
	@Override
	public void updateEnergyConsumed(String oldTenantName, String newTenantName) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("oldTenantName "+oldTenantName+" newTenantName "+newTenantName);
		session.createNativeQuery("UPDATE energy_consumed SET tenant_name = ?  WHERE tenant_name = ?")
		.setParameter(1, newTenantName).setParameter(2, oldTenantName).executeUpdate();		
	}
	@Override
	public void deleteEngCnsd(int tenantId) {
		Session session = sessionFactory.getCurrentSession();
		session.createNativeQuery("DELETE FROM energy_consumed WHERE tenant_id = ?").setParameter(1, tenantId).executeUpdate();
	}
	@Override
	public void deleteEngCnsd(String tenantName) {
		Session session = sessionFactory.getCurrentSession();
		session.createNativeQuery("DELETE FROM energy_consumed WHERE tenant_name = ?").setParameter(1, tenantName).executeUpdate();
	}

	@Override
	public List<EnergyConsumed> engConListByTenantName(String tenantName) {
		Session session = sessionFactory.getCurrentSession();
		List<EnergyConsumed> engConListByTenantName = session.createNativeQuery("SELECT * FROM energy_consumed WHERE tenant_name = ?", EnergyConsumed.class)
				.setParameter(1, tenantName).getResultList();
		return engConListByTenantName;
	}
	@Override
	public EnergyConsumed findEngCnsd(String tenantName) {
		Session session = sessionFactory.getCurrentSession();
		EnergyConsumed energyConsumed = session.createNativeQuery("SELECT * FROM energy_consumed WHERE tenant_name = ? LIMIT 1", EnergyConsumed.class)
				.setParameter(1, tenantName).getSingleResult();
		return energyConsumed;
	}
	@Override
	public double getEnergyKwh(String tenantName, String date) {
		Session session = sessionFactory.getCurrentSession();
		return (double) session.createNativeQuery("SELECT SUM(energy_kwh) FROM energy_consumed WHERE tenant_name = ? AND date LIKE ?")
				.setParameter(1, tenantName).setParameter(2, date).getSingleResult();
	}
	@Override
	public double getUsedEnergy(String tenantName, String date) {
		Session session = sessionFactory.getCurrentSession();
		return (double) session.createNativeQuery("SELECT SUM(used_energy) FROM energy_consumed WHERE tenant_name = ? AND date LIKE ?")
				.setParameter(1, tenantName).setParameter(2, date).getSingleResult();
	}

	



	

}
