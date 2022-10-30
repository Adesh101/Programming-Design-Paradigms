package Model.Operation;

public interface IOperation {

  String createNewPortfolio(String portfolioName);
  void addStockToPortfolio(String portfolioName, String ticker, int quantity, double price);
  boolean getPortfolio(String name);
  String getExistingPortfolios();
  double getCurrentPrice(String ticker);

  void callStockAPIHelper(String ticker);
  void getAmountByDate(String Date);
  void getCurrentPriceByDate(String ticker, String date);
  //void getStocksInPortfolios();
  void getPortfolioComposition();
  //void getCurrentAmountOfPortfolio();
  void getPortfolioByDate(String date);
  //void getTransactionHistory();
  void quit();
}
