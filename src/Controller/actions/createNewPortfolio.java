package Controller.actions;

import Model.Operation.IOperation;
import View.IView;
import java.util.Scanner;

public class createNewPortfolio implements IActions {
  private Scanner in;
  private IView view;
  private IOperation operation;
  private String portfolioName;
//  private addStockToPortfolioHelper helper;

  public createNewPortfolio(IOperation operation, IView view) {
    this.operation = operation;
    this.in = new Scanner(System.in);
    this.view = view;
    this.portfolioName = "";
  }

  @Override
  public void go() {
    this.portfolioName = view.showEnterNewPortfolioName(); //Check why nextline here is not working
    if(operation.checkPortfolioAlreadyExists(portfolioName)){
      view.showPortfolioExists();
    }
    operation.createNewPortfolio(portfolioName);
    view.showPortfolioCreatedSuccessfully(portfolioName);
  }
}
