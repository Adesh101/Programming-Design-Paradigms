package Model.Operation;

import java.util.HashMap;
import java.util.List;

public interface IOperation {

  String createNewPortfolio(String portfolioName);
  void addStockToPortfolio(String portfolioName, String ticker, int quantity, double price);
  boolean getPortfolio(String name);
  String[] getExistingPortfolios();
  double getCurrentPrice(String ticker);

  void callStockAPIHelper(String ticker);
  double callStockAPIByDateHelper(HashMap<String, List<String>> map, String date);

  void getAmountByDate(String Date);
  void getCurrentPriceByDate(String ticker, String date);
  //void getStocksInPortfolios();
  void getPortfolioComposition();
  //void getCurrentAmountOfPortfolio();
  double getPortfolioByDate(String portfolioName, String date);
  //void getTransactionHistory();
  void quit();
}
