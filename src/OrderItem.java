package GourmetCoffee;

/**
 * Class Order
 * 
 * @author Andrew
 */
public class OrderItem {

	private Product product;
	private int quantity;
	
	/*Constructor*/
	public OrderItem(Product product,int quantity) {
		this.setProduct(product);
		this.setQuantity(quantity);
	}

	/**
	 * get product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * set product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * get quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * set product
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * get the price of the orderItem
	 * 
	 * @return product.getPrice()*getQuantity()
	 */
	public double getTotalPrice()
	{
		return product.getPrice()*getQuantity();
	}
	
	/**
	 * Override function toString()
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return getQuantity() + " " + getProduct().getCode() + " " + getProduct().getPrice();
	}
}
