package co.com.bancolombia.aggregation.models;

import java.util.ArrayList;

public class AggregationData {
	boolean customer_habeasData;
	private ArrayList<Document> document;

	
	public boolean isCustomer_habeasData() {
		return customer_habeasData;
	}

	public void setCustomer_habeasData(boolean customer_habeasData) {
		this.customer_habeasData = customer_habeasData;
	}

	public ArrayList<Document> getDocument() {
		return document;
	}

	public void setDocument(ArrayList<Document> document) {
		this.document = document;
	}

	
}
