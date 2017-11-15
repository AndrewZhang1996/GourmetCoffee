package GourmetCoffee;

import java.util.*;

/**
 * Class Order
 * 
 * @author Andrew
 * @implements Iterable<OrderItem>
 */
public class Order implements Iterable<OrderItem>{

	private ArrayList<OrderItem> items;
	
	/*Constructor*/
	public Order() {
		items = new ArrayList<OrderItem>();
	}
	
	/**
	 * This method is to add orderItem to ArrayLiat<OrderItem> items
	 * 
	 * @param orderItem
	 */
	public void addItem(OrderItem orderItem){
		items.add(orderItem);
	}
	
	/**
	 * This method is to remove orderItem from ArrayLiat<OrderItem> items
	 * 
	 * @param orderItem
	 */
	public void removeItem(OrderItem orderItem)
	{
		items.remove(orderItem);
	}

	/**
	 * This method is to return orderItem from ArrayLiat<OrderItem> items
	 * 
	 * @param product
	 * @return OrderItem item
	 */
	public OrderItem getItem(Product product)
	{
		for(OrderItem item: items)
		{
			if(item.getProduct().equals(product))
				return item;
		}
		return null;
	}
	
	/**
	 * This method is to return the size of ArrayLiat<OrderItem> items
	 * 
	 * @return items.size()
	 */
	public int getNumberOfItems()
	{
		return items.size();
	}
	
	/**
	 * This method is to return the totalCost
	 * 
	 * @return cost
	 */
	public double getTotalCost()
	{
		double cost = 0;
		for(OrderItem item: items)
		{
			cost += item.getTotalPrice();
		}
		return cost;
	}
	
	/**
	 * This method is to return the items in array type
	 * 
	 * @return OrderItem[]
	 */
	public OrderItem[] getItems()
	{
		return items.toArray(new OrderItem[0]);
	}
	
	/*iterator of OrderItem*/
	@Override
	public Iterator<OrderItem> iterator() {
		return items.iterator();
	}

}
