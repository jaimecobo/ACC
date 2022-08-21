package edu.acc.java;

import java.io.Serializable;

public class RegionBean implements Serializable {
	private final static long serialVersionUID = 1L;
	
	private WeatherBean eastCoast;
	private WeatherBean westCoast;
	private WeatherBean realCoast;
	
	public RegionBean() {
		this.eastCoast = new WeatherBean();
		this.westCoast = new WeatherBean();
		this.realCoast = new WeatherBean();
	}
	
	public WeatherBean getEastCoast() {
		return eastCoast;
	}

	public void setEastCoast(WeatherBean eastCoast) {
		this.eastCoast = eastCoast;
	}

	public WeatherBean getWestCoast() {
		return westCoast;
	}

	public void setWestCoast(WeatherBean westCoast) {
		this.westCoast = westCoast;
	}

	public WeatherBean getRealCoast() {
		return realCoast;
	}

	public void setRealCoast(WeatherBean realCoast) {
		this.realCoast = realCoast;
	}

}