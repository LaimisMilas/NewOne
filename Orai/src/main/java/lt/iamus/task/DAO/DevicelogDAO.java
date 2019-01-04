package lt.iamus.task.DAO;

import java.util.List;

import lt.iamus.task.entity.Devicelog;

public interface DevicelogDAO {
	public void addDevice (Devicelog devicelog);
	public List<Devicelog> getDeviceList();
	public void updateDevice (Devicelog devicelog);
	public void updateTenant (String oldTenantName, Devicelog devicelog);
	public void dltDeviceRecord (Devicelog devicelog);
	public Devicelog findDevice (int id);
	public Devicelog findDevice (String tenant);
	public List<Devicelog> getTenantList();
	public List<Devicelog> findTenantInfo(String tenant);
	public void dltTenant (String tenant);
	public double getAvgTemp (String tenantName, String data);

}
