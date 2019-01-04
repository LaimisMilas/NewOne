package lt.iamus.task.Services;

import java.util.List;

import lt.iamus.task.entity.Devicelog;

public interface DevicelogService {
	public void addDevice (Devicelog devicelog);
	public List<Devicelog> getDeviceList();
	public void dltDevice (int id);
	public Devicelog findDevice (int id);
	public Devicelog findDevice (String tenant);
	public void updateDevice (Devicelog devicelog);
	public void updateTenant (String oldTenantName, Devicelog devicelog);
	public List<Devicelog> getTenantList();
	public List<Devicelog> findTenantInfo(String tenant);
	public void dltTenant (String tenant);
	public double getAvgTemp (String tenantName, String data);
}
