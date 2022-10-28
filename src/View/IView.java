package View;

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

  void showStockBuy();
  void showStockSell();
  void showTickerError();
//  void showCreateNew();
//  void showExisting();
}
