package GourmetCoffee;

public class PlainTextSalesFormatter{
	private static PlainTextSalesFormatter singletonInstance = null;
	public static PlainTextSalesFormatter getSingletonInstance(){
		if (singletonInstance == null) {
			singletonInstance = new PlainTextSalesFormatter();
		}
		return singletonInstance;
	}
	
	//private PlainTextSalesFormatter(){} 		//单例模式

	public String formatSales(Sales sales){
		String str = "";
	    int i = 0;
	    for (Order localOrder : sales){
	    	str = str + "------------------------\n"+ "Order " + ++i + "\n\n";
	      for (OrderItem localOrderItem : localOrder) {
	        str = str + localOrderItem.getQuantity() + " " + localOrderItem.getProduct().getCode() + " " + localOrderItem.getProduct().getPrice() + "\n";
	      }
	      str = str + "\nTotal = " + localOrder.getTotalCost() + "\n";
	    }
	    return str;
	  }

}
