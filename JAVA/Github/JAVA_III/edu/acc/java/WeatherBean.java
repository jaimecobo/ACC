package edu.acc.java;

import java.io.Serializable;
import java.util.Random;

public class WeatherBean implements Serializable {
	private final static long serialVersionUID = 1L;

	Random rand = new Random();
	private String morningWeather;
	private String noonWeather;
	private String eveningWeather;

	public WeatherBean() {
		morningWeather = makeWeather();
		noonWeather = makeWeather();
		eveningWeather = makeWeather();
	}

	private String makeWeather() {
		String[] weatherBits = {"with rubic cubes", 
				                "widespread fires",
				                "small chance of tidal waves",
				                "mostly light alien brain control",
				                "brightly colored Expo rides",
				                "tree fungus sporadic",
				                "dark sky at night",
				                "hamburger helper",
				                "Foreigner and U2 concerts",
				                "essential services shut",
				                "Internet router issues",
				                "falling Hondas in mountains"
		                        };
		return weatherBits[rand.nextInt(weatherBits.length)] 
				            + " and " 
				            + weatherBits[rand.nextInt(weatherBits.length)];
	}

	public String getMorningWeather() {
		return morningWeather;
	}
	public void setMorningWeather(String morningWeather) {
		this.morningWeather = morningWeather;
	}
	public String getNoonWeather() {
		return noonWeather;
	}
	public void setNoonWeather(String noonWeather) {
		this.noonWeather = noonWeather;
	}
	public String getEveningWeather() {
		return eveningWeather;
	}
	public void setEveningWeather(String eveningWeather) {
		this.eveningWeather = eveningWeather;
	}
}