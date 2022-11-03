package Controller.actions;

import Model.Operation.IOperation;

public class showAmountOfPortfolioByDate implements IActions {

  private String portfolioName;
  private String date;

  public showAmountOfPortfolioByDate (String portfolioName, String date) {
    this.portfolioName = portfolioName;
    this.date = date;
  }

  @Override
  public String go(IOperation operation) {
    return "Value of " + this.portfolioName + " on " + this.date + " is : "
        + operation.getPortfolioByDate(this.portfolioName, this.date) + "$";
  }
}
