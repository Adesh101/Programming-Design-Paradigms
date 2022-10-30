package Controller.actions;

import Model.Operation.IOperation;
import View.IView;
import java.io.InputStream;
import java.util.Scanner;

public class createNewPortfolio implements IActions {
  private Scanner in;
  private IView view;
  private IOperation operation;
  protected String portfolioName;

  public createNewPortfolio(IOperation operation, IView view) {
    this.operation = operation;
    this.in = new Scanner(System.in);
    this.view = view;
    this.portfolioName = "";
  }

  @Override
  public String go() {
    view.showEnterNewPortfolioName();
    this.portfolioName = in.nextLine();
    return "Portfolio: " + operation.createNewPortfolio(portfolioName) + "created successfully!";
  }

//  @Override
//  public void go() {
//    view.showEnterNewPortfolioName();
//    String portfolioName = in.nextLine();
//    portfolio = portfolio.setPortfolioName(portfolioName);
//    String flag = "";
//    while(!flag.equalsIgnoreCase("N")){
//      view.showTicker();
//      // check valid ticker
//      String tickerSymbol = in.next();
//      Stocks stock = new Stocks(tickerSymbol);
//      double currentPrice = stock.getStockCurrentPrice();
//      view.showCurrentPrice(currentPrice);
//      String getConfirmation = in.next();
//      if(getConfirmation.equalsIgnoreCase("Y")){
//        view.showQuantity();
//        int quantity = in.nextInt();
//        portfolio.addStocksToPortfolio(portfolioName, tickerSymbol, quantity, currentPrice);
//        view.showPostConfirmation();
//      } else {
//        view.showOrderCancelled();
//        view.showMenu();
//      }
//      flag = in.next();
//    }
////    Portfolio p = new
////        Portfolio("ABCD");
//    view.showStockPortfolio(portfolio.getPortfolioComposition(portfolioName));
//    view.showMenuMessage();
//    view.showMenu();
//  }
}
