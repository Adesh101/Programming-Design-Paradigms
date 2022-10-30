package Controller.actions;

import Model.Portfolio.IPortfolio;
import Model.Stocks.IStocks;
import Model.Stocks.Stocks;
import View.IView;
import java.io.InputStream;
import java.util.Scanner;

public class createNewPortfolio implements IActions {
  private Scanner in;
  private IView view;
  private IPortfolio portfolio;
  private IStocks stock;

  public createNewPortfolio(IPortfolio portfolio, IView view, IStocks stock, InputStream in) {
    this.portfolio = portfolio;
    this.view = view;
    this.stock = stock;
    this.in = new Scanner(System.in);
  }

  @Override
  public void go() {
    view.showEnterNewPortfolioName();
    String portfolioName = in.nextLine();
    portfolio.setPortfolioName(portfolioName);
    String flag = "";
    while(!flag.equals("N")){
      view.showTicker();
      // check valid ticker
      String tickerSymbol = in.next();
      Stocks stock = new Stocks(tickerSymbol);
      double currentPrice = stock.getStockCurrentPrice();
      view.showCurrentPrice(currentPrice);
      String getConfirmation = in.next();
      if(getConfirmation.equals("Y")){
        view.showQuantity();
        int quantity = in.nextInt();
        portfolio.addStocksToPortfolio(tickerSymbol, quantity, currentPrice);
        view.showPostConfirmation();
      } else {
        view.showOrderCancelled();
        view.showMenu();
      }
      flag = in.next();
    }
  }
}
