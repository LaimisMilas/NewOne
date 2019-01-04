package lt.iamus.task.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.iamus.task.DAO.EnergyConsumedDAO;
import lt.iamus.task.entity.EnergyConsumed;

@Service
@Transactional
public class EnergyConsumedServiceImpl implements EnergyConsumedService {

	@Autowired
	private EnergyConsumedDAO energyConsumedDAO;
	
	@Override
	public void addEnergyConsumed(EnergyConsumed energyConsumed) {
		energyConsumedDAO.addEnergyConsumed(energyConsumed);
	}
	@Override
	public void updateEnergyConsumed(EnergyConsumed energyConsumed) {
		energyConsumedDAO.updateEnergyConsumed(energyConsumed);		
	}
	@Override
	public void updateEnergyConsumed(String oldTenantName, String newTenantName) {
		energyConsumedDAO.updateEnergyConsumed(oldTenantName, newTenantName);
	}
	@Override
	public void deleteEngCnsd(int tenantId) {
		energyConsumedDAO.deleteEngCnsd(tenantId);
	}
	@Override
	public void deleteEngCnsd(String tenantName) {
		energyConsumedDAO.deleteEngCnsd(tenantName);
	}
	@Override
	public List<EnergyConsumed> engConListByTenantName(String tenantName) {
		return energyConsumedDAO.engConListByTenantName(tenantName);
	}
	@Override
	public EnergyConsumed getEngCnsmdToChart(String tenantName, String date) {
		EnergyConsumed energyConsumed = energyConsumedDAO.findEngCnsd(tenantName);
		double energyKwh = energyConsumedDAO.getEnergyKwh(tenantName, date);
		double usedEnergy = energyConsumedDAO.getUsedEnergy(tenantName, date);
		energyConsumed.setEnergyKwh(energyKwh);
		energyConsumed.setUsedEnergy(usedEnergy);
		return energyConsumed;
	}




}
