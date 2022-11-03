package Controller.actions;

import Model.Operation.IOperation;

/**
 * This class will show the existing portfolios.
 */
public class showExistingPortfolios implements IActions {

  @Override
  public String go(IOperation operation) {
    return "LIST OF AVAILABLE PORTFOLIOS: \n" + operation.getExistingPortfolios();
  }
}
