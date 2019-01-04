package lt.iamus.task.DAO;

import java.util.List;

import lt.iamus.task.entity.Devicelog;
import lt.iamus.task.entity.EnergyConsumed;

public interface EnergyConsumedDAO {
	public void addEnergyConsumed (EnergyConsumed energyConsumed);
	public void updateEnergyConsumed (EnergyConsumed energyConsumed);
	public void updateEnergyConsumed (String oldTenantName, String newTenantName);
	public void deleteEngCnsd (int tenantId);
	public void deleteEngCnsd (String tenantName);
	public List<EnergyConsumed> engConListByTenantName (String tenantName);
	public EnergyConsumed findEngCnsd (String tenantName);
	public double getEnergyKwh (String tenantName, String date);
	public double getUsedEnergy (String tenantName, String date);

}
