package Model.Stocks;

public interface IStocks {

  void callStockAPI(String ticker);
  String[] getStockData();
  double getStockCurrentPrice(String ticker);
  String getCurrentDate(String date);
}
