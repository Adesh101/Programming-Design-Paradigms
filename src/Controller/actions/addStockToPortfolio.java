package Controller.actions;

import Model.Operation.IOperation;

public class addStockToPortfolio implements IActions {
  String portfolioName;
  int quantity;
  String ticker;
  double price;

  public addStockToPortfolio(String portfolioName, String ticker, int quantity) {
    this.portfolioName = portfolioName;
    this.ticker = ticker;
    this.quantity = quantity;
    this.price = 0;
  }

//  @Override
//  public void go() {
//      view.showEnterPortfolioToAddStocks();
//      this.portfolioName = view.fetchInput();
//      if (!operation.getPortfolio(portfolioName)) {
//        view.showNoPortfoliosPresent();
//      } else if (operation.getMapSize(portfolioName) != 0) {
//        view.showPortfolioLockedError();
//      } else {
//        String orderConfirmation = "Y";
//        while (orderConfirmation.equalsIgnoreCase("Y")) {
//          this.ticker = view.showTicker();
//          while (true) {
//            if (operation.isTickerValid(this.ticker)) {
//              break;
//            } else {
//              view.showTickerError();
//              this.ticker = view.fetchInput();
//            }
//          }
//          this.quantity = view.showQuantity();
////          while (true) {
////            try {
////              view.showQuantity();
////              this.quantity = Integer.parseInt(in.next());
////              break;
////            } catch (Exception e) {
////              view.showValidQuantity();
////            }
////          }
//          this.helper = new addStockToPortfolioHelper(this.portfolioName, this.ticker,
//              this.quantity, this.operation, this.view);
//          this.helper.createPortfolio();
//          orderConfirmation = view.showPostConfirmation();
//        }
//      }
//        view.showMenuMessage();
//    operation.writeToCSV(operation.getPortfolio());
//  }

  @Override
  public String go(IOperation operation) {
    if(operation.getPortfolio(this.portfolioName)) {
      if(operation.isTickerValid(this.ticker)) {
        this.price = operation.getCurrentPrice(this.ticker);
        operation.addStockToPortfolio(this.portfolioName, this.ticker, this.quantity, this.price);
        return "STOCK " + this.ticker + " WITH QUANTITY " + this.quantity + " ADDED TO " + this.portfolioName + " PORTFOLIO.";
      }
      throw new IllegalArgumentException("ENTER A VALID STOCK TICKER.");
    }
    throw new IllegalArgumentException("ENTER A VALID PORTFOLIO NAME.");
  }
}

