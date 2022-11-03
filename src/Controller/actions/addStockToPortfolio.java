package Controller.actions;

import Model.Operation.IOperation;

/**
 * This class executes the function that will add stocks to a particular portfolio.
 */
public class addStockToPortfolio implements IActions {

  String portfolioName;
  int quantity;
  String ticker;
  double price;

  public addStockToPortfolio(String portfolioName, String ticker, int quantity) {
    this.portfolioName = portfolioName;
    this.ticker = ticker;
    this.quantity = quantity;
    this.price = 0;
  }

  @Override
  public String go(IOperation operation) {
    if (operation.getPortfolio(this.portfolioName)) {
      if (operation.isTickerValid(this.ticker)) {
        this.price = operation.getCurrentPrice(this.ticker);
        operation.addStockToPortfolio(this.portfolioName, this.ticker, this.quantity, this.price);
        return "STOCK " + this.ticker + " WITH QUANTITY " + this.quantity + " ADDED TO "
            + this.portfolioName + " PORTFOLIO.";
      }
      throw new IllegalArgumentException("ENTER A VALID STOCK TICKER.");
    }
    throw new IllegalArgumentException("ENTER A VALID PORTFOLIO NAME.");
  }
}

