package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ILocationDao;
import com.app.model.Location;

@Repository
public class LocationDaoImpl implements ILocationDao {
	
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveLocation(Location loc) {
		return (Integer)ht.save(loc);
	}

	@Override
	public void updateLocation(Location loc) {
		ht.update(loc);
		
	}

	@Override
	public void deleteLocation(int locId) {
		Location loc=new Location();
		loc.setLocId(locId);
		ht.delete(loc);
	}

	@Override
	public Location getLocationById(int locId) {
		return ht.get(Location.class, locId);
		
	}

	@Override
	public List<Location> getAllLocations() {
		return ht.loadAll(Location.class);
	}

	@Override
	public List<Object[]> getLocationCountAndType() {
		String hql="select locType, count(locType) from com.app.model.Location group by locType";
		List<Object[]> data=ht.find(hql);
		return data;
	}
	
}
