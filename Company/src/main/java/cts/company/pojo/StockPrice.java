package cts.company.pojo;

import java.sql.Time;

import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity

@Table(name = "stockprice")

public class StockPrice {

	
	private String companyname;
	
	@Override

	public String toString() {

		return "StockPrice [companyname=" + companyname + ", stockexchange=" + stockexchange + ", currentprice="

				+ currentprice + ", date=" + date + ", time=" + time + "]";

	}
	@Id
	private String stockexchange;
	public String getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(String stockexchange) {
		this.stockexchange = stockexchange;
	}
	private Integer currentprice;
	public Integer getCurrentprice() {
		return currentprice;
	}

	public void setCurrentprice(Integer currentprice) {
		this.currentprice = currentprice;
	}
	private String date;
	private String time;
	

	public String getCompanyname() {

		return companyname;

	}

	public void setCompanyname(String companyname) {

		this.companyname= companyname;

	}

	

	
	public String getDate() {

		return date;

	}

	public void setDate(String date) {

		this.date = date;

	}

	public String getTime() {

		return time;

	}

	public void setTime(String time) {

		this.time = time;

	}

}