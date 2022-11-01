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
    String portfolioName="";
    view.showEnterPortfolioToAddStocks();
    portfolioName = in.nextLine();
    boolean flag=true;
      if(!operation.getPortfolio(portfolioName)){
        flag=false;
        view.showNoPortfoliosPresent();
      }
      else if(operation.getMapSize(portfolioName)!=0){
        flag=false;
        view.showPortfolioLockedError();
      }
      String addStockConfirmation="";
    if(flag) {
      if (operation.getPortfolio(portfolioName)) {
        view.showValidPortfolio();
        String orderConfirmation = "Y";
        while (orderConfirmation.equalsIgnoreCase("Y")) {
          addStockConfirmation = "Y";
          while (orderConfirmation.equalsIgnoreCase("Y") && addStockConfirmation.equalsIgnoreCase(
              "Y")) {
            //copied from above
            view.showTicker();
            String ticker = in.next().toUpperCase();
            //String[] stockData = operation.callStockAPIHelper(ticker);
//
            while(true) {
              try {
                if (!operation.isTickerValid(ticker)) {
                  throw new IllegalArgumentException();
                } else {
                  break;
                }
              } catch (IllegalArgumentException e) {
                view.showTickerError();
                ticker = in.next().toUpperCase();
              }
            }
            operation.callStockAPIHelper(ticker);
            double price = operation.getCurrentPrice(ticker);
            view.showConfirmation(price);
            orderConfirmation = in.next();
            //
            if (orderConfirmation.equalsIgnoreCase("Y")) {
              view.showQuantity();
              String quantity = in.next();
              while(true) {
                try {
                  if (!operation.isQuantityValid(quantity)) {
                    throw new IllegalArgumentException();
                  } else {
                    break;
                  }
                } catch (IllegalArgumentException e) {
                  view.showValidQuantity();
                  quantity = in.next().toUpperCase();
                }
              }
              operation.addStockToPortfolio(portfolioName, ticker, Integer.parseInt(quantity), price);
              view.showPostConfirmation();
              addStockConfirmation = in.next();
            }
          }
          if (addStockConfirmation.equalsIgnoreCase("N")) {
            view.showOrderCompleted();
            orderConfirmation = "N";
          }
        }
        if (orderConfirmation.equalsIgnoreCase("N") && addStockConfirmation.equalsIgnoreCase("Y")) {
          view.showOrderCancelled();
        }
        view.showMenuMessage();
      }
    }
    return "Stocks added successfully!";
  }
}
