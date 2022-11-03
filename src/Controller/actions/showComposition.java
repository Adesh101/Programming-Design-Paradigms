package Controller.actions;

import Model.Operation.IOperation;
import View.IView;
import java.util.Scanner;

/**
 * This class will show composition of a particular portfolio.
 */
public class showComposition implements IActions {

  private String portfolioName;

  public showComposition(String portfolioName) {
    this.portfolioName = portfolioName;
  }

  @Override
  public String go(IOperation operation) {
    return "PORTFOLIO COMPOSITION FOR " + this.portfolioName + " IS: \n"
        + operation.getPortfolioComposition(this.portfolioName);
  }
}
