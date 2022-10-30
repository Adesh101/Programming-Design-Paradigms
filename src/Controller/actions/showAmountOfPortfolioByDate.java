package Controller.actions;

import Model.Operation.IOperation;
import View.IView;
import java.util.Scanner;

public class showAmountOfPortfolioByDate implements IActions {
  private Scanner in;
  private IView view;
  private IOperation operation;
  public showAmountOfPortfolioByDate(IOperation operation, IView view){
   this.operation = operation;
   this.in = new Scanner(System.in);
   this.view=view;
  }

  @Override
  public String go() {
    return null;
  }
}
