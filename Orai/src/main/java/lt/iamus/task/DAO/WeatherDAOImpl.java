package lt.iamus.task.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lt.iamus.task.entity.Weather;

@Repository
public class WeatherDAOImpl implements WeatherDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addWeatherInfo(Weather weather) {
		Session session = sessionFactory.getCurrentSession();
		session.save(weather);
		System.out.println("Nauji duomenys apie ora prideti");
	}

	@Override
	public List<Weather> getWeatherList(String city) {
		Session session = sessionFactory.getCurrentSession();
		List<Weather> weatherList = session.createNamedQuery("weatherList").setParameter("city", city).getResultList();
		return weatherList;
	}

	@Override
	public void deleteInscription(Weather weather) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(weather);
	}

	@Override
	public Weather findInscription (int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Weather.class, id);
	}

	@Override
	public double getTemp(String city, String data) {
		Session session = sessionFactory.getCurrentSession();
		double kelvinoTemp = (double) session.createNativeQuery("SELECT AVG(temp) FROM weather where city = ? AND tstamp LIKE ?")
				.setParameter(1, city).setParameter(2, data).getSingleResult();
		double celcijausTemp = kelvinoTemp - 273.15;
		return celcijausTemp;
	}

	@Override
	public List<Weather> getWeatherListByDate(String city, String date) {
		Session session = sessionFactory.getCurrentSession();
		List<Weather> weatherListByDate = session.createNativeQuery("SELECT * FROM weather WHERE city = ? AND tstamp LIKE ?", Weather.class)
				.setParameter(1, city).setParameter(2, date).getResultList();
		return weatherListByDate;
	}

}
