package Controller.actions;

import Model.Portfolio.IPortfolio;
import Model.Stocks.IStocks;
import View.IView;
import java.io.InputStream;
import java.util.Scanner;

public class showExistingPortfolios implements IActions {
  private Scanner in;
  private IView view;
  private IPortfolio portfolio;

  public showExistingPortfolios(IPortfolio portfolio, IView view, InputStream in){
    this.portfolio = portfolio;
    this.view = view;
    this.in = new Scanner(System.in);
  }

  @Override
  public String go() {
    view.showPortfolioNames(portfolio.portfolioNames());
    return null;
  }
}
