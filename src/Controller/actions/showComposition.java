package Controller.actions;

import Model.Operation.IOperation;
import View.IView;
import java.util.Scanner;

public class showComposition implements IActions {

  private Scanner in;
  private IView view;
  private IOperation operation;

  public showComposition(IOperation operation, IView view){
    this.operation=operation;
    this.view=view;
    this.in= new Scanner(System.in);
  }

  @Override
  public void go() {
    view.showPortfolioMessage();
    String portfolioName = in.nextLine();
    if(operation.getPortfolio(portfolioName)){
      view.showValidPortfolio();
      view.showStockPortfolio(operation.getStocksMap(portfolioName));
    }
  }
}
