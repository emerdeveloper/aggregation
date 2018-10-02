package co.com.bancolombia.aggregation.models;

public class Document {

	private String bank_id;
	private String financialProduct_type;
	private String data_file;

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public String getFinancialProduct_type() {
		return financialProduct_type;
	}

	public void setFinancialProduct_type(String financialProduct_type) {
		this.financialProduct_type = financialProduct_type;
	}

	public String getData_file() {
		return data_file;
	}

	public void setData_file(String data_file) {
		this.data_file = data_file;
	}
}
