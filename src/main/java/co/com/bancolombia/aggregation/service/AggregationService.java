package co.com.bancolombia.aggregation.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.squareup.okhttp.Response;

import co.com.bancolombia.aggregation.models.AggregationData;
import co.com.bancolombia.aggregation.models.DataResponse;
import co.com.bancolombia.aggregation.models.HeaderResponse;
import co.com.bancolombia.aggregation.models.RequestRestService;
import co.com.bancolombia.aggregation.models.RequestService;
import co.com.bancolombia.aggregation.models.ResponseService;
import co.com.bancolombia.aggregation.restservices.RestClient;

@Component
public class AggregationService {
	@Autowired
	private RestClient restclient;

	public ResponseService aggregation(RequestService dataRequest) {
		try {
			Response response = restclient.financialData(dataRequest.getData().get(0).getHeader().getToken(),putRequest(dataRequest));
			return validateRestResponse(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private ResponseService putResponse(String transactionStatus, int code) {
		DataResponse dataResponse = new DataResponse();
		dataResponse.setTransactionStatus(transactionStatus);
		HeaderResponse header = new HeaderResponse();
		header.setStatus(code);
		dataResponse.setHeader(header);
		ResponseService responseService = new ResponseService();
		ArrayList<DataResponse> list = new ArrayList<>();
		list.add(dataResponse);
		responseService.setData(list);
		return responseService;

	}

	private ResponseService validateRestResponse(Response response) {
		return (response.code() == 200) ? converResponsoToJsonObject(response)
				: putResponse("No se completó la transaccion", response.code());
	}

	private ResponseService converResponsoToJsonObject(Response response) {
		try {
			Gson g = new Gson();
			JsonObject p = g.fromJson(response.body().string(), JsonObject.class);
			JsonArray data = (JsonArray) p.get("data");
			JsonObject dataObject = data.get(0).getAsJsonObject();
			JsonObject status = dataObject.get("status").getAsJsonObject();
			return putResponse(status.get("description").getAsString(), response.code());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private RequestRestService putRequest(RequestService dataRequest) {
		RequestRestService requestService = new RequestRestService();
		AggregationData aggregationData = new AggregationData();
		aggregationData.setCustomer_habeasData(true);
		aggregationData.setDocument(dataRequest.getData().get(0).getDocument());
		ArrayList<AggregationData> list = new ArrayList<>();
		list.add(aggregationData);
		requestService.setData(list);
		return requestService;
	}
}
