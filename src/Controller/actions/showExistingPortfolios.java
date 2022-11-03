package Controller.actions;

import Model.Operation.IOperation;

public class showExistingPortfolios implements IActions {

  @Override
  public String go(IOperation operation) {
    return "List of available portfolios: \n" + operation.getExistingPortfolios();
  }
}
