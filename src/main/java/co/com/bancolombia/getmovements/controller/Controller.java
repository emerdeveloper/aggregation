package co.com.bancolombia.getmovements.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.bancolombia.aggregation.models.RequestService;
import co.com.bancolombia.aggregation.models.ResponseService;
import co.com.bancolombia.aggregation.service.AggregationService;
@RestController
public class Controller {
@Autowired
private AggregationService aggregation;
	
	@RequestMapping(value = "/aggregation", method = RequestMethod.POST)
	public ResponseService controller(@RequestBody RequestService data){
		 return aggregation.aggregation(data);
		
	}
		
}
