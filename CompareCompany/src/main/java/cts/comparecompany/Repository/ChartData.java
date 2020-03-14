package cts.comparecompany.Repository;
import java.util.ArrayList;
import java.util.List;

import cts.comparecompany.pojo.ChartModel;

public class ChartData {
  private static final List<ChartModel> CHART_MODELS;
  static {
    CHART_MODELS = new ArrayList<ChartModel>();
    CHART_MODELS.add(new ChartModel("06/01/2015", "28", "35"));
    CHART_MODELS.add(new ChartModel("06/02/2015", "25", "39"));
    CHART_MODELS.add(new ChartModel("06/03/2015", "26", "40"));
    CHART_MODELS.add(new ChartModel("06/04/2015", "22", "33"));
    CHART_MODELS.add(new ChartModel("06/05/2015", "21", "34"));
    CHART_MODELS.add(new ChartModel("06/06/2015", "25.6", "38.6"));
    CHART_MODELS.add(new ChartModel("06/07/2015", "20.9", "38.4"));
    CHART_MODELS.add(new ChartModel("06/08/2015", "27.8", "39.1"));
    CHART_MODELS.add(new ChartModel("06/09/2015", "25", "37"));
    CHART_MODELS.add(new ChartModel("06/10/2015", "38.1", "40.2"));
    CHART_MODELS.add(new ChartModel("06/11/2015", "30.5", "41"));
    CHART_MODELS.add(new ChartModel("06/12/2015", "27", "38.9"));
    CHART_MODELS.add(new ChartModel("06/13/2015", "26.4", "39.7"));
    CHART_MODELS.add(new ChartModel("06/14/2015", "26.3", "39.7"));
    CHART_MODELS.add(new ChartModel("06/15/2015", "23.4", "38.4"));
    CHART_MODELS.add(new ChartModel("06/16/2015", "22", "39"));
    CHART_MODELS.add(new ChartModel("06/17/2015", "24", "38"));
    CHART_MODELS.add(new ChartModel("06/18/2015", "26", "40.5"));
    CHART_MODELS.add(new ChartModel("06/19/2015", "26", "39.4"));
    CHART_MODELS.add(new ChartModel("06/20/2015", "23", "39"));
    CHART_MODELS.add(new ChartModel("06/21/2015", "25.4", "38"));
    CHART_MODELS.add(new ChartModel("06/22/2015", "26.1", "39"));
  }
  public static List<ChartModel> getHighChartDataList() {
    return CHART_MODELS;
  }
}