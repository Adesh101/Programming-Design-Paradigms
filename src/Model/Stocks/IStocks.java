package Model.Stocks;

public interface IStocks {

  String[] callStockAPI(String ticker);
  String[] getStockData();
  double getStockCurrentPrice(String ticker);
  String getCurrentDate(String date);
}
