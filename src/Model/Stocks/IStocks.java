package Model.Stocks;

public interface IStocks {

  void callStockAPI(String ticker);
  void callStockAPIByDate(String ticker, String date);
  String getStockData(int i);
  double getStockCurrentPrice(String ticker);
  double getStockCurrentPriceByDate(String ticker);
  String getCurrentDate(String date);
}
