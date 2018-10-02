package co.com.bancolombia.aggregation.models;

public class DataResponse {
	private HeaderResponse header;
	private String transactionStatus;
	
	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public HeaderResponse getHeader() {
		return header;
	}

	public void setHeader(HeaderResponse header) {
		this.header = header;
	}

	
}
