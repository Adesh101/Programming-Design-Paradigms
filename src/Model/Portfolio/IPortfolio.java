package Model.Portfolio;

import java.util.HashMap;
import java.util.List;

public interface IPortfolio {
  void fetchStockPrice(String ticker);
  void addStocksToPortfolio(String ticker, int quantity, double price);

  HashMap<String, List<String>> getPortfolioComposition();
  double totalPortfolioValue();
  void createPortfolio();
//  void setNewPortfolioName(String name);
  void getTicker();
  void getQuantity();
  String getOrderConfirmation(String choice);


  public void lockPortfolio();

  public void getPortfolio();
}
