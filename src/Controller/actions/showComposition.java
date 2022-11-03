package Controller.actions;

import Model.Operation.IOperation;
import View.IView;
import java.util.Scanner;

public class showComposition implements IActions {

  private String portfolioName;

  public showComposition (String portfolioName) {
    this.portfolioName = portfolioName;
  }

  @Override
  public String go(IOperation operation) {
    return "Portfolio composition for " + this.portfolioName + " is: \n" + operation.getPortfolioComposition(this.portfolioName);
  }
}
