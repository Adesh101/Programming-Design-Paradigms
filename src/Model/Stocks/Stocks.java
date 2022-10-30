package Model.Stocks;

public class Stocks implements IStocks{

  String[] stockData;
  fetchStockData data;

  public Stocks(String ticker){
    this.stockData = new String[50]; //null;data.callStockAPI(ticker);
  }

  @Override
  public String[] callStockAPI(String ticker) {
    this.stockData = data.callStockAPI(ticker);
    return this.stockData;
  }

  @Override
  public double getStockCurrentPrice(String ticker) {
    return Double.parseDouble(this.stockData[13]);
  }
  @Override
  public String[] getStockData(){
    return this.stockData;
  }

  @Override
  public String getCurrentDate(String date) {
    return String.valueOf(this.stockData[15]);
  }
}
