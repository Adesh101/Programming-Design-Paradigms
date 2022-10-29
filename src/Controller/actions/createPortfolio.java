package Controller.actions;

import Model.Operation.Operation;
import Model.Portfolio.IPortfolio;
import Model.Portfolio.Portfolio;
import Model.Stocks.IStocks;
import View.IView;
import Model.Stocks.Stocks;
import View.View;
import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class createPortfolio implements IActions {
  private Scanner in;
  private IView view;
  private IPortfolio p;
  private IStocks stock;
  private Operation o;

  public createPortfolio(IPortfolio p, IView view, IStocks stock, InputStream in) {
    this.p = p;
    this.view = view;
    this.stock = stock;
    this.in = new Scanner(System.in);
  }


  @Override
  public void go() {
    view.showEnterNewPortfolioName();
    // check existing name

    p = new Portfolio(in.nextLine());
//    p.setNewPortfolioName();
    String flag = "";
    while(!flag.equalsIgnoreCase("N")){
      view.showTicker();

      // check valid ticker
      String ticker = in.next();
      Stocks stocks = new Stocks(ticker);

      double currentPrice = stocks.getStockCurrentPrice(ticker);
      view.showCurrentPrice(currentPrice);
      if(Objects.equals(in.next().toUpperCase(), "Y")){
        view.showQuantity();
        int quantity = in.nextInt();
        p.addStocksToPortfolio(ticker, quantity, currentPrice);
        view.showPostConfirmation();
        flag = in.next();
      }
    }
    view.showStockPortfolio(p.getPortfolioComposition(), p.totalPortfolioValue());
//    // MIGHT BE WRONG
//    if(p.getOrderConfirmation(in.next())=="N"){
//      o.quit();
//      // send to main menu if you have the brains to implement it
//    }
//    else if (p.getOrderConfirmation(in.next())=="Y") {
//      // add order to portfolio
//      view.showPostConfirmation();
//      // add more stocks. Should run again
//    }
  }

  private void addStockHelper(){

  }
}
