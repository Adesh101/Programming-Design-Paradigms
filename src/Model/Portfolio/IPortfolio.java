package Model.Portfolio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface IPortfolio {
  void fetchStockPrice(String ticker);
  void setPortfolioName(String ticker);
  void addStocksToPortfolio(String ticker, int quantity, double price);

  HashMap<String, List<String>> getPortfolioComposition();
  double totalPortfolioValue();
  void createPortfolio();
//  void setNewPortfolioName(String name);
  void getTicker();
  void getQuantity();
  String getOrderConfirmation(String choice);
  HashMap<String, HashMap<String, List<String>>> getPortfolio();

  public void lockPortfolio();

  public Set<String> getPortfolioNames();
}
