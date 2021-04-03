package CSV;

import java.math.BigDecimal;
import java.util.ArrayList;


public class OrderDetails {
	 static ArrayList<OrderBean> orderDetails = new ArrayList<>();
	 
	    public static ArrayList<OrderBean> getAllOrders() {

	        if (orderDetails.isEmpty()) {
	            loadOrderDetails();
	        }
	        return orderDetails;
	    }
	    
	    private static void loadOrderDetails() {
	        for (int i = 1; i < readCSV.getWholeSheet().size(); i++) {
	            OrderBean order = new OrderBean(Integer.parseInt(
	            		readCSV.getWholeSheet().get(i).get(0)), 
	            		readCSV.getWholeSheet().get(i).get(1), 
	            		readCSV.getWholeSheet().get(i).get(2),
	            		readCSV.getWholeSheet().get(i).get(3), 
	            		readCSV.getWholeSheet().get(i).get(4),
	            		readCSV.getWholeSheet().get(i).get(5), 
	                    new BigDecimal(readCSV.getWholeSheet().get(i).get(6)),
	                    new BigDecimal(readCSV.getWholeSheet().get(i).get(7)),
	                    new BigDecimal(readCSV.getWholeSheet().get(i).get(8)));
	            orderDetails.add(order);
	        }
	    }

}
