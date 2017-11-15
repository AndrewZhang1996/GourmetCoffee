package GourmetCoffee;

import java.util.ArrayList;

/**
 * Class Product
 * 
 * @author Andrew
 */
public class Product {

	private String code;
	private String description;
	private double price;
	protected ArrayList<DataField> dataFields;
	
	/*Constructor*/
	public Product(String code, String discription, double price) {
		this.code = code;
		this.description = discription;
		this.price = price;
	}

	/*get Code*/
	public String getCode()
	{
		return code;
	}
	
	/*get Description*/
	public String getDescription()
	{
		return description;
	}
	
	/*get Price*/
	public double getPrice()
	{
		return price;
	}
	
	/**
	 * This method will return the dataFields of this Product class.
	 * 
	 * @return ArrayList<DataField>
	 */
	public ArrayList<DataField> getDataFields()
	{
		dataFields = new ArrayList<DataField>();
		dataFields.add(new DataField("Code",getCode()));
		dataFields.add(new DataField("Description",getDescription()));
		dataFields.add(new DataField("Price",Double.toString(getPrice())));
		
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
		return code+ "_" + description + "_" + price;
	}
}
