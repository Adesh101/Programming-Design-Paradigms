package Controller.actions;

import Model.Operation.IOperation;
import View.IView;

/**
 * This class creates a new portfolio using CSV filetype.
 */
public class createNewPortfolioCSV implements IActions {

  private String fileName;

  public createNewPortfolioCSV(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public String go(IOperation operation) {
    return operation.readFromFile(this.fileName);
  }
}
