package entity;

public class Reports {
	public String medicine_name;
	public String medicine_id;
	public String getMedicine_name() {
		return medicine_name;
	}
	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}
	public String getMedicine_id() {
		return medicine_id;
	}
	public void setMedicine_id(String medicine_id) {
		this.medicine_id = medicine_id;
	}
	public double order_item_price;
	public double sale_record_price;
	public int sale_record_number;
	public double getOrder_item_price() {
		return order_item_price;
	}
	public void setOrder_item_price(double order_item_price) {
		this.order_item_price = order_item_price;
	}
	public double getSale_record_price() {
		return sale_record_price;
	}
	public void setSale_record_price(double sale_record_price) {
		this.sale_record_price = sale_record_price;
	}
	public int getSale_record_number() {
		return sale_record_number;
	}
	public void setSale_record_number(int sale_record_number) {
		this.sale_record_number = sale_record_number;
	}
}
