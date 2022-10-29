package View;

import java.util.HashMap;
import java.util.List;

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
  void showConfirmation();
  void showOrderConfirmationDeclined();
  void showPostConfirmation();
  void showQuit();

  void showStockMenu();

  void showCurrentPrice(double text);

  void showStockPortfolio(HashMap<String, List<String>> map, double value);

  void showStockBuy();
  void showStockSell();
  void showTickerError();
//  void showCreateNew();
//  void showExisting();
}
