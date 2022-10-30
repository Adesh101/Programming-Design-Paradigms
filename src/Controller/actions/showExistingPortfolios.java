package Controller.actions;

import Model.Portfolio.IPortfolio;
import java.io.InputStream;
import java.util.Scanner;

public class showExistingPortfolios implements IActions {
  private IPortfolio portfolio;
  private Scanner in;
  public showExistingPortfolios(IPortfolio portfolio, InputStream in){
    this.portfolio = portfolio;
    this.in= new Scanner(System.in);
  }

  @Override
  public void go() {
    portfolio.getPortfolioNames();
  }
}
