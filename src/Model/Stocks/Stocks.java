package Model.Stocks;

public class Stocks implements IStocks{

  String[] stockData;
  fetchStockData data;

  public Stocks(){
    this.stockData = new String[50]; //null;data.callStockAPI(ticker);
    this.data = new fetchStockData();
  }

  @Override
  public void callStockAPI(String ticker) {
    this.stockData = data.callStockAPI(ticker);
  }


  @Override
  public void callStockAPIByDate(String ticker, String date) {
    this.stockData = data.callStockAPIbyDate(ticker, date);
  }

  @Override
  public double getStockCurrentPrice(String ticker) {
    return Double.parseDouble(this.stockData[13]);
  }

  @Override
  public double getStockCurrentPriceByDate(String ticker) {
    return Double.parseDouble(this.stockData[1]);
  }

  @Override
  public String getStockData(int i){
    return this.stockData[i];
  }

  @Override
  public String getCurrentDate(String date) {
    return String.valueOf(this.stockData[15]);
  }
}
