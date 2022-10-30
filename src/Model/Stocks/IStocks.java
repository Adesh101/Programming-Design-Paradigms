package Model.Stocks;

public interface IStocks {

  String[] callStockAPI(String ticker);
  String[] getStockData();
  double getStockCurrentPrice();
  String getCurrentDate(String date);
}
