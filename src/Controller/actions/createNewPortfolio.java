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
    if(operation.checkPortfolioAlreadyExists(portfolioName)){
      view.showPortfolioExists();
    return "";
    }
    operation.createNewPortfolio(portfolioName);
    view.showPortfolioCreatedSuccessfully(portfolioName);
    return "";
  }

}
