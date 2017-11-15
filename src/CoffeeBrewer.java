package GourmetCoffee;

import java.util.ArrayList;

/**
 * Class CoffeeBrewer
 * 
 * @author Andrew
 * @extends Product
 */
public class CoffeeBrewer extends Product {

	private String model;
	private String waterSupply;
	private int numberOfCups;
	
	/*Construtor*/
	public CoffeeBrewer(String code, String discription, double price, String model, String waterSupply, int numberOfCups) {
		super(code, discription, price);
		this.setModel(model);
		this.setWaterSupply(waterSupply);
		this.setNumberOfCups(numberOfCups);
	}
	
	/*get waterSupply*/
	public String getWaterSupply() {
		return waterSupply;
	}
	
	/*set waterSupply*/
	public void setWaterSupply(String waterSupply) {
		this.waterSupply = waterSupply;
	}
	
	/*get model*/
	public String getModel() {
		return model;
	}
	
	/*set model*/
	public void setModel(String model) {
		this.model = model;
	}
	
	/*get numberOfCups*/
	public int getNumberOfCups() {
		return numberOfCups;
	}
	
	/*set numberOfCups*/
	public void setNumberOfCups(int numberOfCups) {
		this.numberOfCups = numberOfCups;
	}

	/**
	 * This method will return the dataFields of this CoffeeBrewer class.
	 * 
	 * @return ArrayList<DataField>
	 */
	@Override
	public ArrayList<DataField> getDataFields()
	{
		dataFields = new ArrayList<DataField>();
		dataFields.add(new DataField("Model",getModel()));
		dataFields.add(new DataField("Water supply",getWaterSupply()));
		dataFields.add(new DataField("Number of cups",Integer.toString(getNumberOfCups())));
		return dataFields;
	}
	
	/**
	 * This method override toString method.
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		return super.toString() + "_" + model + "_" + waterSupply + "_" + numberOfCups;
	}
}
