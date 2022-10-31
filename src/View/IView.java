package View;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface IView {
  void showWelcomeMessage();
//  void showFirstName();
//  void showLastName();
//  void showAccountID();
//  void showInitialBalance();
  void showError();
  void showMenu();
  void showEnterNewPortfolioName();
  void showTicker();
  void showQuantity();
  void showConfirmation(double price);
  void showOrderConfirmationDeclined();
  void showPostConfirmation();
  void showQuit();
  void clearScreen();

  void showStockMenu();

  void showCurrentPrice(double text);
  void showOrderCancelled();
  void showOrderCompleted();
  void showMenuMessage();
  void showPortfolioNames(String[] names);
  void showEnterPortfolioToAddStocks();
  void showValidPortfolio();
  void showAllPortfolioNames(String names);

  void showStockPortfolio(HashMap<String, List<String>> map);

  void showStockBuy();
  void showStockSell();
  void showTickerError();
//  void showCreateNew();
//  void showExisting();
}
