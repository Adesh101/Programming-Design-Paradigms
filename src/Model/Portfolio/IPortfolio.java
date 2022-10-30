package Model.Portfolio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface IPortfolio {
  void fetchStockPrice(String ticker);
  Portfolio setPortfolioName(String ticker);
  String getPortfolioName();
  void addStocksToPortfolio(String portfolioName, String ticker, int quantity, double price);

  Set<String> portfolioNames ();

  HashMap<String, List<String>> getPortfolioComposition(String portfolioName);
  double totalPortfolioValue();
  void createPortfolio();
//  void setNewPortfolioName(String name);
  void getTicker();
  void getQuantity();
  String getOrderConfirmation(String choice);
  HashMap<String, HashMap<String, List<String>>> getPortfolio();

  public void lockPortfolio();

  public ArrayList<String> getPortfolioNames();
}
