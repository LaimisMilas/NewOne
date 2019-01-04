package lt.iamus.task.Services;

import java.util.List;

import lt.iamus.task.entity.Devicelog;
import lt.iamus.task.entity.EnergyConsumed;

public interface EnergyConsumedService {
	public void addEnergyConsumed (EnergyConsumed energyConsumed);
	public void updateEnergyConsumed (EnergyConsumed energyConsumed);
	public void updateEnergyConsumed (String oldTenantName, String newTenantName);
	public void deleteEngCnsd (int tenantId);
	public void deleteEngCnsd (String tenantName);
	public List<EnergyConsumed> engConListByTenantName (String tenantName);
	public EnergyConsumed getEngCnsmdToChart (String devicelog, String date);

}
