package CSV;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Methods {
	
	// Shows the list in JSON
	static ArrayList<String> showCSVListJSON() {
		ArrayList<String> simpleCSV = new ArrayList<String>();
		for (ArrayList<String> row : readCSV.getWholeSheet()) {
			simpleCSV.addAll(row);
		}
		return simpleCSV;
	}
	
	// Formats the JSON and gives names to the specific columns so it's readable
	private static String orderDetailsToJSON(OrderBean order) {
		String pattern = "{\"order\": {\"orderId\": %s,\"orderDate\": \"%s\", \"region\": \"%s\", \"rep1\": \"%s\", \"rep2\": \"%s\", " +
				"\"item\": \"%s\", \"units\":%.2f, \"unitCost\":%.2f, \"total\":%.2f}},";
		
		return String.format(pattern, order.getOrderId(), order.getOrderDate(), order.getRegion(), order.getRep1(), order.getRep2(),
				order.getItem(), order.getUnits(), order.getUnitCost(), order.getTotal());
	}
	
	// Prints all the details as JSON
	public static String showAllDetails (ArrayList<OrderBean> orderDetails) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
        for (OrderBean order : orderDetails) {
            sb.append(orderDetailsToJSON(order));
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }
	
	// Shows a specific column
	static ArrayList<String> showCSVListColumn(String id) {
		int i = Integer.parseInt(id);
		
		ArrayList<String> showColumn = new ArrayList<String>();
		for (ArrayList<String> row : readCSV.getWholeSheet()) {
            showColumn.add(row.get(i));
        }
        return showColumn;
	}
	
	// Checks for anomalies, i.e. if the math doesn't add up
	static ArrayList<String> anomalyCheck() {
        ArrayList<String> mathCheck = new ArrayList<String>();
        for (ArrayList<String> row : readCSV.getWholeSheet()) {
            String unit = (row.get(6));
            String unitCost = (row.get(7));
            String total = (row.get(8));

            if (unit.equals("Units")) {}
            if (unitCost.equals("UnitCost")) {}
            if (total.equals("Total")) {
            } else {

                BigDecimal units = new BigDecimal(unit);
                BigDecimal unitcost = new BigDecimal(unitCost);
                BigDecimal totalPrice = new BigDecimal(total);
                BigDecimal result = units.multiply(unitcost);

                if (result.compareTo(totalPrice) == 0) {
                } else {
                    mathCheck.add(row.get(0) + ":" + " " + "Units: " + unit + " " + "UnitCost: " + unitCost + " " + "Total: " + total);
                }
            }
        }
        return mathCheck;
    }
}
