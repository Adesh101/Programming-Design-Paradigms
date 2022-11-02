package Controller.actions;

import Model.Operation.IOperation;
import View.IView;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class createNewPortfolioCSV implements IActions {
  private Scanner in;
  private IView view;
  private IOperation operation;
  private String portfolioName;
  private String fileName;
  private addStockToPortfolioHelper helper;

  public createNewPortfolioCSV(IOperation operation, IView view, String fileName) {
    this.operation = operation;
    this.in = new Scanner(System.in);
    this.view = view;
    this.portfolioName = "";
    this.fileName = fileName;
  }

  @Override
  public void go() {
    String line = "";
    String splitBy = ",";
    try {
      BufferedReader br = new BufferedReader(new FileReader(this.fileName));
      while ((line = br.readLine()) != null)   //returns a Boolean value
      {
        String[] portfolioNames = line.split(splitBy);    // use comma as separator
        if (portfolioNames.length == 1) {
          if (portfolioNames[0].length() != 0) {
            if(operation.checkPortfolioAlreadyExists(portfolioNames[0])){
              if (operation.getMapSize(portfolioName) != 0) {
                view.showPortfolioLockedError();
                view.showInvalidFileError();
                break;
              }
            } else {
              this.portfolioName = portfolioNames[0];
              operation.createNewPortfolio(portfolioName);
              view.showPortfolioCreatedSuccessfully(this.portfolioName);
              //br.readLine();
            }
          }
        } else {
          String ticker = portfolioNames[0];
          if (!operation.isTickerValid(ticker)) {
            throw new IllegalArgumentException();
          }
          int quantity = Integer.parseInt(portfolioNames[1]);
          this.helper = new addStockToPortfolioHelper(this.portfolioName, ticker, quantity, this.operation, this.view);
          this.helper.createPortfolio();
        }
      }
    } catch (Exception ex) {
      view.showInvalidFileError();
    }
    operation.writeToCSV(operation.getPortfolio());
  }
}
