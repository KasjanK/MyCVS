package CSV;

import java.util.ArrayList;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CSVController {
	// shows the file in JSON with named categories, readable
	@RequestMapping(value = "/showCSVListJSON", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showCSVListJSON() {
		return Methods.showAllDetails(OrderDetails.getAllOrders());
	}
	
	// shows a specific column
	@RequestMapping(value = "/showColumn/{column}", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<String> showCSVListColumn(@PathVariable("column") String id) {
		return Methods.showCSVListColumn(id);
	}
	
	// shows the incorrect total 
	@RequestMapping(value = "/showAnomalies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<String> mathcheck() {
		return Methods.anomalyCheck();
	}
}
