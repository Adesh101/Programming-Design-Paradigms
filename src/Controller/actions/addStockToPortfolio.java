package Controller.actions;

import Model.Operation.IOperation;
import View.IView;
import java.io.InputStream;
import java.util.Scanner;

public class addStockToPortfolio implements IActions {

  IOperation operation;
  IView view;
  createNewPortfolio portfolio;
  private Scanner in;

  public addStockToPortfolio(IOperation operation, IView view) {
    this.operation = operation;
    this.view = view;
    this.in = new Scanner(System.in);
  }

  @Override
  public String go() {
    view.showEnterPortfolioToAddStocks();
    String portfolioName = in.nextLine();
    if(operation.getPortfolio(portfolioName)) {
      view.showValidPortfolio();
      String orderConfirmation = "Y";
      while(orderConfirmation.equalsIgnoreCase("Y")) {
        view.showTicker();
        String ticker = in.next().toUpperCase();
        operation.callStockAPIHelper(ticker);
        double price = operation.getCurrentPrice(ticker);
        view.showConfirmation(price);
        view.showQuantity();
        int quantity = in.nextInt();
        operation.addStockToPortfolio(portfolioName, ticker, quantity, price);
        view.showPostConfirmation();
        orderConfirmation = in.next();
      }
      if(orderConfirmation.equalsIgnoreCase("N")) {
        view.showOrderCancelled();
      }
      view.showMenuMessage();
    }
    return "Stocks added successfully!";
  }
}
