package cts.comparecompany.pojo;


public class ChartModel {
	  private String date;
	  private String minTemp;
	  private String maxTemp;
	  public ChartModel(String date, String minTemp, String maxTemp) {
	    this.date = date;
	    this.minTemp = minTemp;
	    this.maxTemp = maxTemp;
	  }
	  public String getDate() {
	    return date;
	  }
	  public void setDate(String date) {
	    this.date = date;
	  }
	  public String getMinTemp() {
	    return minTemp;
	  }
	  public void setMinTemp(String minTemp) {
	    this.minTemp = minTemp;
	  }
	  public String getMaxTemp() {
	    return maxTemp;
	  }
	  public void setMaxTemp(String maxTemp) {
	    this.maxTemp = maxTemp;
	  }
	}