package Controller.actions;

import Model.Operation.IOperation;
import View.IView;
import java.util.Scanner;

public class addStockToPortfolio implements IActions {

  IOperation operation;
  IView view;
  private Scanner in;
  String portfolioName;
  String ticker;
  int quantity;
  addStockToPortfolioHelper helper;


  public addStockToPortfolio(IOperation operation, IView view) {
    this.operation = operation;
    this.view = view;
    this.in = new Scanner(System.in);
    this.portfolioName = "";
    this.quantity = 0;
    this.ticker = "";
  }

  @Override
  public void go() {
      view.showEnterPortfolioToAddStocks();
      this.portfolioName = in.nextLine();
      if (!operation.getPortfolio(portfolioName)) {
        view.showNoPortfoliosPresent();
      } else if (operation.getMapSize(portfolioName) != 0) {
        view.showPortfolioLockedError();
      } else {
        String orderConfirmation = "Y";
        while(orderConfirmation.equalsIgnoreCase("Y")) {
          view.showTicker();
          this.ticker = in.next();
          while (true) {
            try {
              if (!operation.isTickerValid(ticker)) {
                throw new IllegalArgumentException();
              } else {
                break;
              }
            } catch (IllegalArgumentException e) {
              view.showTickerError();
              this.ticker = in.next().toUpperCase();
            }
          }
          while (true) {
            try {
              view.showQuantity();
              this.quantity = Integer.parseInt(in.next());
              break;
            } catch (Exception e) {
              view.showValidQuantity();
            }
          }
          this.helper = new addStockToPortfolioHelper(this.portfolioName, this.ticker, this.quantity,
              this.operation, this.view);
          this.helper.createPortfolio();
          view.showPostConfirmation();
          orderConfirmation = in.next();
        }
        view.showMenuMessage();
      }
    operation.writeToCSV(operation.getPortfolio());
  }
}
