package Controller.actions;

import Model.Operation.IOperation;
import View.IView;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class createNewPortfolio implements IActions {
  private Scanner in;
  private IView view;
  private IOperation operation;
  protected String portfolioName;
  private addStockToPortfolioHelper helper;

  public createNewPortfolio(IOperation operation, IView view) {
    this.operation = operation;
    this.in = new Scanner(System.in);
    this.view = view;
    this.portfolioName = "";
  }

  @Override
  public void go() {
    int option = 0;
    view.showPortfolioMenuOption();
    try {
      option = in.nextInt();
    } catch (InputMismatchException ex) {
      view.showError();
    }
    while(true) {
      if (option == 1) {
        view.showEnterNewPortfolioName();
        in.nextLine();
        this.portfolioName = in.nextLine(); //Check why nextline here is not working
        if(operation.checkPortfolioAlreadyExists(portfolioName)){
          view.showPortfolioExists();
        }
        operation.createNewPortfolio(portfolioName);
        view.showPortfolioCreatedSuccessfully(portfolioName);
        break;
      } else if (option == 2) {
        view.showFileName();
        String fileName = in.next();
        String line = "";
        String splitBy = ",";
        try {
          BufferedReader br = new BufferedReader(new FileReader(fileName));
          while ((line = br.readLine()) != null)   //returns a Boolean value
          {
            String[] portfolioNames = line.split(splitBy);    // use comma as separator
            if (portfolioNames.length == 1) {
              if (portfolioNames[0].length() != 0) {
                if(operation.checkPortfolioAlreadyExists(portfolioNames[0])){
                  view.showPortfolioExists();
                }
                this.portfolioName = portfolioNames[0];
                operation.createNewPortfolio(portfolioName);
                view.showPortfolioCreatedSuccessfully(this.portfolioName);
              }
            } else {
              String ticker = portfolioNames[0];
              int quantity = Integer.parseInt(portfolioNames[1]);
              this.helper = new addStockToPortfolioHelper(this.portfolioName, ticker, quantity, this.operation, this.view);
              this.helper.createPortfolio();
            }
          }
        } catch (Exception ex) {
            view.showError();
          }
        operation.writeToCSV(operation.getPortfolio());
        break;
      } else {
        view.showError();
      }
    }
  }
}
