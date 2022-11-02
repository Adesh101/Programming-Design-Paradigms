package Controller.actions;

import Model.Operation.IOperation;
import View.IView;
import java.util.Scanner;

public class addStockToPortfolioHelper {
  IOperation operation;
  IView view;
  String portfolio;
  String stockName;
  int quantity;
  double price;
  private Scanner in;

  public addStockToPortfolioHelper(String portfolioName, String stockName, int quantity, IOperation operation, IView view) {
    this.portfolio = portfolioName;
    this.stockName = stockName;
    this.quantity = quantity;
    this.operation = operation;
    this.price = 0;
    this.view = view;
    this.in = new Scanner(System.in);
  }

  protected void createPortfolio() {
    if (operation.getPortfolio(this.portfolio)) {
      operation.callStockAPIHelper(this.stockName);
      this.price = operation.getCurrentPrice(this.stockName);
      operation.addStockToPortfolio(this.portfolio, this.stockName, this.quantity, this.price);
    } else {
      view.showInvalidPortfolioName();
    }
  }
}
