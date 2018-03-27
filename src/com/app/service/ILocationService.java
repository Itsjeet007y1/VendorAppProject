package com.app.service;

import java.util.List;

import com.app.model.Location;

public interface ILocationService {
	public int saveLocation(Location loc);
	public void updateLocation(Location loc);
	public void deleteLocation(int locId);
	public Location getLocationById(int locId);
	public List<Location> getAllLocations();
	public List<Object[]> getLocationCountAndType();
}
