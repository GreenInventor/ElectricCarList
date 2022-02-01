package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tanner Patterson - tpatterson4
 * CIS175 or CIS152 - SPRING
 * Jan 31, 2022
 */

@Entity
@Table(name="electriccars")
public class ElectricCar 
{
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	@Column(name="MAKE")
	private String make;
	
	@Column(name="MODEL")
	private String model;
	
	@Column(name="YEAR")
	private int year;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="RANGE")
	private int range;
	
	@Column(name="TOPSPEED")
	private int topspeed;
	
	@Column(name="ZEROSIXTYACCELERATION")
	private double zerosixtyacceleration;
	
	@Column(name="CHARGEPOWER")
	private int chargepower;
	
	/**
	 * default no-arg constructor 
	 */
	public ElectricCar() {
		super();
		
	}

	/**
	 * @param make
	 * @param model
	 * @param year
	 * @param price
	 * @param range
	 * @param topspeed
	 * @param zerosixtyacceleration
	 * @param chargepower
	 */
	public ElectricCar(String make, String model, int year, double price, int range, int topspeed,
			double zerosixtyacceleration, int chargepower) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.range = range;
		this.topspeed = topspeed;
		this.zerosixtyacceleration = zerosixtyacceleration;
		this.chargepower = chargepower;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the range
	 */
	public int getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(int range) {
		this.range = range;
	}

	/**
	 * @return the topspeed
	 */
	public int getTopspeed() {
		return topspeed;
	}

	/**
	 * @param topspeed the topspeed to set
	 */
	public void setTopspeed(int topspeed) {
		this.topspeed = topspeed;
	}

	/**
	 * @return the zerosixtyacceleration
	 */
	public double getZerosixtyacceleration() {
		return zerosixtyacceleration;
	}

	/**
	 * @param zerosixtyacceleration the zerosixtyacceleration to set
	 */
	public void setZerosixtyacceleration(double zerosixtyacceleration) {
		this.zerosixtyacceleration = zerosixtyacceleration;
	}

	/**
	 * @return the chargepower
	 */
	public int getChargepower() {
		return chargepower;
	}

	/**
	 * @param chargepower the chargepower to set
	 */
	public void setChargepower(int chargepower) {
		this.chargepower = chargepower;
	}
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public String getCarDetails() {
		return "[make=" + make + ", model=" + model + ", year=" + year + ", price=" + price
				+ ", range=" + range + ", topspeed=" + topspeed + ", zerosixtyacceleration=" + zerosixtyacceleration
				+ ", chargepower=" + chargepower + "]";
	}

	
}
