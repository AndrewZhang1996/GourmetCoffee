package GourmetCoffee;

import java.util.*;

/**
 * Class Catalog
 * 
 * @author Andrew
 * @implements Iterable<Product>
 */
public class Catalog implements Iterable<Product>{

	private ArrayList<Product> products;
	
	/*Constructor*/
	public Catalog() {
		products = new ArrayList<Product>();
	}
	
	/**
	 * This method is to add product to the ArrayList<Product> products
	 * 
	 * @param Product product
	 */
	public void addProduct(Product product)
	{
		products.add(product);
	}

	/**
	 * This method is to return a Product Type 
	 * 
	 * @param String code: the code of the product
	 * @return product in a specific code
	 */
	public Product getProduct(String code) {
		for(Product product: products)
		{
			if(product.getCode().equals(code))
				return product;
		}
		return null;
	}
	
	/**
	 * This method is to return the number of products 
	 * 
	 * @return size of ArrayList<Product> products
	 */
	public int getNumberOfProducts()
	{
		return products.size();
	}
	
	/**
	 * This method is to return an array of codes
	 * 
	 * @return codes in String[] type
	 */
	public String[] getCodes()
	{
		String[] codes = new String[getNumberOfProducts()];
		int i = 0;
		for(Product product: products)
		{
			codes[i] = product.getCode();
			i++;
		}
		return codes;
	}
	
	/*iterator of Product*/
	@Override
	public Iterator<Product> iterator()
	{
		return products.iterator();
	}
}

