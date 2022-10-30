package Model.Operation;

public interface IOperation {

  String createNewPortfolio(String portfolioName);
  void addStockToPortfolio(String portfolioName, String ticker, int quantity, double price);
  boolean getPortfolio(String name);
  void getExistingPortfolios();
  double getCurrentPrice(String ticker);
  void getCurrentPriceByDate(String ticker, String date);
  //void getStocksInPortfolios();
  void getPortfolioComposition();
  //void getCurrentAmountOfPortfolio();
  void getPortfolioByDate(String date);
  //void getTransactionHistory();
  void quit();
}
