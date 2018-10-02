package co.com.bancolombia.aggregation.models;

import java.util.ArrayList;

public class Data {
	private Header header;
	private ArrayList<Document> document;

	public ArrayList<Document> getDocument() {
		return document;
	}

	public void setDocument(ArrayList<Document> document) {
		this.document = document;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

}
