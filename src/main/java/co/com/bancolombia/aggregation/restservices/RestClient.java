package co.com.bancolombia.aggregation.restservices;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import co.com.bancolombia.aggregation.models.RequestRestService;

@Component
public class RestClient {

	final static String URL = "https://sbapi.bancolombia.com/v1/sales-service/customer-management/customer-event-history/bank-statements";

	public Response financialData(String token, RequestRestService dataRequest) {
		try {
			OkHttpClient client = new OkHttpClient();

			String requests = ObjectToString(dataRequest);
			MediaType mediaType = MediaType.parse("application/vnd.bancolombia.v1+json");
			RequestBody body = RequestBody.create(mediaType, requests);
			Request request = new Request.Builder().url(URL).post(body).addHeader("authorization", "Bearer " + token)
					.addHeader("content-type", "application/vnd.bancolombia.v1+json")
					.addHeader("accept", "application/vnd.bancolombia.v1+json").build();
			return client.newCall(request).execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String ObjectToString(RequestRestService dataRequest) {
		Gson gson = new Gson();
		System.out.println(gson.toJson(dataRequest));
		return gson.toJson(dataRequest);

	}

}
