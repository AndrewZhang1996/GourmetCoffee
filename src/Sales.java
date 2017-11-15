package GourmetCoffee;

import java.util.*;

/**
 * Class Sales
 * 
 * @author Andrew
 * @implements Iterable<Order>
 */
public class Sales implements Iterable<Order>{

	private ArrayList<Order> orders;
	
	/*Constructor*/
	public Sales() {
		orders = new ArrayList<Order>();
	}
	
	/**
	 * This method is to add order to ArrayLiat<Order> order
	 * 
	 * @param order
	 */
	public void addOrder(Order order)
	{
		orders.add(order);
	}
	
	/**
	 * This method is to return the size of ArrayLiat<Order> orders
	 * 
	 * @return orders.size()
	 */
	public int getNumberOfOrders(){
		return orders.size();
	}

	/*iterator of Order*/
	@Override
	public Iterator<Order> iterator() {
		return orders.iterator();
	}

}
