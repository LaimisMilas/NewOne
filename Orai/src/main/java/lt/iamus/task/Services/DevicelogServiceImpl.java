package lt.iamus.task.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.iamus.task.DAO.DevicelogDAO;
import lt.iamus.task.entity.Devicelog;

@Service
@Transactional
public class DevicelogServiceImpl implements DevicelogService {

	@Autowired
	private DevicelogDAO devicelogDAO;
	
	@Override
	public void addDevice(Devicelog devicelog) {
		devicelogDAO.addDevice(devicelog);
	}

	@Override
	public List<Devicelog> getDeviceList() {
		return devicelogDAO.getDeviceList();
	}

	@Override
	public void dltDevice(int id) {
		Devicelog devicelog = devicelogDAO.findDevice(id);
		devicelogDAO.dltDeviceRecord(devicelog);
	}

	@Override
	public Devicelog findDevice(int id) {
		return devicelogDAO.findDevice(id);
	}

	@Override
	public void updateDevice(Devicelog devicelog) {
		devicelogDAO.updateDevice(devicelog);
	}

	@Override
	public List<Devicelog> getTenantList() {
		return devicelogDAO.getTenantList();
	}

	@Override
	public List<Devicelog> findTenantInfo(String tenant) {
		return devicelogDAO.findTenantInfo(tenant);
	}

	@Override
	public void dltTenant(String tenant) {
		devicelogDAO.dltTenant(tenant);
	}

	@Override
	public Devicelog findDevice(String tenant) {
		return devicelogDAO.findDevice(tenant);
	}

	@Override
	public void updateTenant(String oldTenantName, Devicelog devicelog) {
		devicelogDAO.updateTenant(oldTenantName, devicelog);
	}

	@Override
	public double getAvgTemp(String tenantName, String data) {
		return devicelogDAO.getAvgTemp(tenantName, data);
	}

}
