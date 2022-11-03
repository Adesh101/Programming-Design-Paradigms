package Controller.actions;

import Model.Operation.IOperation;

/**
 * This class fetches the total amount of a particular portfolio as per the passed date.
 */
public class showAmountOfPortfolioByDate implements IActions {

  private String portfolioName;
  private String date;

  public showAmountOfPortfolioByDate (String portfolioName, String date) {
    this.portfolioName = portfolioName;
    this.date = date;
  }

  @Override
  public String go(IOperation operation) {
    return "VALUE OF " + this.portfolioName + " ON " + this.date + " IS : "
        + operation.getPortfolioByDate(this.portfolioName, this.date) + "$";
  }
}
