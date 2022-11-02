package Controller.actions;

import Model.Operation.IOperation;
import View.IView;

public class addStockToPortfolio implements IActions {

  IOperation operation;
  IView view;
  String portfolioName;
  String ticker;
  int quantity;
  addStockToPortfolioHelper helper;


  public addStockToPortfolio(IOperation operation, IView view) {
    this.operation = operation;
    this.view = view;
    this.portfolioName = "";
    this.quantity = 0;
    this.ticker = "";
  }

  @Override
  public void go() {
      view.showEnterPortfolioToAddStocks();
      this.portfolioName = view.fetchInput();
      if (!operation.getPortfolio(portfolioName)) {
        view.showNoPortfoliosPresent();
      } else if (operation.getMapSize(portfolioName) != 0) {
        view.showPortfolioLockedError();
      } else {
        String orderConfirmation = "Y";
        while (orderConfirmation.equalsIgnoreCase("Y")) {
          this.ticker = view.showTicker();
          while (true) {
            if (operation.isTickerValid(this.ticker)) {
              break;
            } else {
              view.showTickerError();
              this.ticker = view.fetchInput();
            }
          }
          this.quantity = view.showQuantity();
//          while (true) {
//            try {
//              view.showQuantity();
//              this.quantity = Integer.parseInt(in.next());
//              break;
//            } catch (Exception e) {
//              view.showValidQuantity();
//            }
//          }
          this.helper = new addStockToPortfolioHelper(this.portfolioName, this.ticker,
              this.quantity, this.operation, this.view);
          this.helper.createPortfolio();
          orderConfirmation = view.showPostConfirmation();
        }
      }
        view.showMenuMessage();
    operation.writeToCSV(operation.getPortfolio());
  }
}

