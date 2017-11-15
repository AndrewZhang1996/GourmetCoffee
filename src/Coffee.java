package GourmetCoffee;

import java.util.ArrayList;

/**
 * Class Coffee
 * 
 * @author Andrew
 * @extends Product
 */
public class Coffee extends Product {

	private String origin;
	private String roast;
	private String flavor;
	private String aroma;
	private String acidity;
	private String body;
	
	/*Constructor*/
	public Coffee(String code, String description, double price, String origin, String roast, String flavor, String aroma, String acidity, String body) {
		super(code, description, price);
		this.setOrigin(origin);
		this.setRoast(roast);
		this.setFlavor(flavor);
		this.setAroma(aroma);
		this.setAcidity(acidity);
		this.setBody(body);
	}

	/*get Origin*/
	public String getOrigin() {
		return origin;
	}

	/*set Origin*/
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/*get Roast*/
	public String getRoast() {
		return roast;
	}

	/*set Roast*/
	public void setRoast(String roast) {
		this.roast = roast;
	}

	/*get Aroma*/
	public String getAroma() {
		return aroma;
	}

	/*set Aroma*/
	public void setAroma(String aroma) {
		this.aroma = aroma;
	}

	/*get Flavor*/
	public String getFlavor() {
		return flavor;
	}

	/*set Flavor*/
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	/*get Body*/
	public String getBody() {
		return body;
	}

	/*set Body*/
	public void setBody(String body) {
		this.body = body;
	}

	/*get Acidity*/
	public String getAcidity() {
		return acidity;
	}

	/*set Acidity*/
	public void setAcidity(String acidity) {
		this.acidity = acidity;
	}
	
	/**
	 * This method will return the dataFields of this Coffee class.
	 * 
	 * @return ArrayList<DataField>
	 */
	@Override
	public ArrayList<DataField> getDataFields()
	{
		dataFields = new ArrayList<DataField>();
		dataFields.add(new DataField("Origin",getOrigin()));
		dataFields.add(new DataField("Roast",getRoast()));
		dataFields.add(new DataField("Flavor",getFlavor()));
		dataFields.add(new DataField("Aroma",getAroma()));
		dataFields.add(new DataField("Acidity",getAcidity()));
		dataFields.add(new DataField("Body",getBody()));
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
		return super.toString() + "_" + origin + "_" + roast + "_" + flavor + "_" + aroma + "_" + acidity + "_" + body;
	}
}
