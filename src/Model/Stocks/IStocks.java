package Model.Stocks;

public interface IStocks {

  String[] callStockAPI(String ticker);
  double getStockCurrentPrice(String ticker);
  String getCurrentDate(String date);
}
