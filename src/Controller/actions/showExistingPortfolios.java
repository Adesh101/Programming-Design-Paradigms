package Controller.actions;

import Model.Operation.IOperation;
import Model.Portfolio.IPortfolio;
import Model.Stocks.IStocks;
import View.IView;
import java.io.InputStream;
import java.util.Scanner;

public class showExistingPortfolios implements IActions {
  private Scanner in;
  private IView view;
  private IOperation operation;

  public showExistingPortfolios(IOperation operation, IView view){
    this.view = view;
    this.operation=operation;
    this.in = new Scanner(System.in);
  }

  @Override
  public String go() {
    //view.showPortfolioNames(portfolio.portfolioNames());
    return operation.getExistingPortfolios();
  }
}
