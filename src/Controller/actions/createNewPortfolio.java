package Controller.actions;

import Model.Operation.IOperation;
import Model.Operation.Operation;

public class createNewPortfolio implements IActions {
  private String portfolioName;

  public createNewPortfolio(String portfolioName) {
    this.portfolioName = portfolioName;
  }

  @Override
  public String go(IOperation operation) {
    operation.createNewPortfolio(this.portfolioName);
    return "Portfolio " + this.portfolioName + " successfully created. \n";
  }

}
