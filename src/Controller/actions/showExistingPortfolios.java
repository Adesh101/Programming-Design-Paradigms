package Controller.actions;

import Model.Operation.IOperation;
import View.IView;
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
  public void go() {
    if(operation.getExistingPortfolios().length==0){
      view.showNoPortfoliosPresent();
    }
    view.showPortfolioNames(operation.getExistingPortfolios());
  }
}
