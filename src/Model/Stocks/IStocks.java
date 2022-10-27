package Model.Stocks;

public interface IStocks {

  void getStockData();

  double getCurrentPrice();

  double getHigh();

  double getLow();

  String getSymbol();
}
