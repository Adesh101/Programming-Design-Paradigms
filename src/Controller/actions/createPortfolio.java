package Controller.actions;

import Model.Operation.Operation;
import Model.Portfolio.Portfolio;
import Model.Stocks.Stocks;
import View.View;
import java.util.Scanner;

public class createPortfolio implements IActions {
  private Scanner in;
  private View view;
  private Portfolio p;
  private Operation o;


  @Override
  public void go() {
    view.showEnterNewPortfolioName();
    p.getNewPortfolioName();
    view.showTicker();
    p.getTicker();
    view.showQuantity();
    p.getQuantity();
    view.showConfirmation();
    p.getOrderConfirmation(in.next());
    // MIGHT BE WRONG
    if(p.getOrderConfirmation(in.next())=="N"){
      o.quit();
      // send to main menu if you have the brains to implement it
    }
    else if (p.getOrderConfirmation(in.next())=="Y") {
      // add order to portfolio
      view.showPostConfirmation();
      // add more stocks. Should run again
    }


  }
}
