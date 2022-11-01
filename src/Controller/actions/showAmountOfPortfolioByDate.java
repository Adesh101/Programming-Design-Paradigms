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
    view.showPortfolioMessage();
    String portfolioName = in.nextLine();
    if(operation.getPortfolio(portfolioName)) {
      view.showValidPortfolio();
      System.out.println("Enter the date at which you want to see portfolio value:");
      String date = in.nextLine();
      double value = operation.getPortfolioByDate(portfolioName, date);
      System.out.println("Total portfolio value: " + value);
    }
    return "Hello";
  }
}
