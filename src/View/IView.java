package View;

public interface IView {
  void showWelcomeMessage();
  void showError();
  void showMenu();
  String fetchInput();
  String showEnterNewPortfolioName();
  String showTicker();
  int showQuantity();
  String showPostConfirmation();
  String showQuit();

  String showStockMenu();

  String showPortfolioMenuOption();
  void showInvalidPortfolioName();
  String showFileName();
  void showInvalidFileError();

  void showOrderCompleted();

  void showMenuMessage();
  void showPortfolioNames(String[] names);
  void showEnterPortfolioToAddStocks();
  void showValidPortfolio();
  void showPortfolioMessage();
  void showStockPortfolio(String[][] composition);

  void showAllPortfolioNames(String names);

  void showTickerError();
  void showPortfolioLockedError();
  void showPortfolioExists();
  void showPortfolioCreatedSuccessfully(String name);
  void showNoPortfoliosPresent();
}
