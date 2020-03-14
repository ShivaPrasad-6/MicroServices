package cts.comparecompany.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cts.comparecompany.Repository.ChartData;
import cts.comparecompany.pojo.ChartModel;

/**
 * Servlet implementation class HighChartServlet
 */
public class HighChart extends HttpServlet {
  private static final long serialVersionUID = 1L;
  List<ChartModel> chartModels;
  /**
   * @see HttpServlet#HttpServlet()
   */
  public HighChart() {
    chartModels = ChartData.getHighChartDataList();
  }
  /**
   * @see Servlet#init(ServletConfig)
   */
  @Override
  public void init(ServletConfig config) throws ServletException {}
  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String json = "";
    String sDate = request.getParameter("start");
    String eDate = request.getParameter("end");
    if (sDate != null && eDate != null) {
      System.out.println("Start Date : " + sDate);
      System.out.println("End Date : " + eDate);
      //Actual data should come from database
      //select data from database based on start date and end date
      //here I am neither going to fetch data from database nor fetch data based on date range
      //you need to manipulate those things from database
      int counter = 1;
      if (chartModels != null) {
        json += "[";
      }
      for (ChartModel chartModel : chartModels) {
        try {
          json += "[" + (new SimpleDateFormat("MM/dd/yyyy")).parse(chartModel.getDate()).getTime() + "," + chartModel.getMinTemp() + ","
              + chartModel.getMaxTemp() + "]";
          if (counter < chartModels.size()) {
            json += ",";
          }
          counter++;
        } catch (ParseException e) {
          e.printStackTrace();
        }
      }
      if (chartModels != null) {
        json += "]";
      }
      if (chartModels == null) {
        json = "No record found";
      }
    } else {
      json = "Date must be selected.";
    }
    System.out.println(json);
    response.getWriter().write(json);
  }
}