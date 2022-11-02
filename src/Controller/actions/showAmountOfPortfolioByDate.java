package Controller.actions;

import Model.Operation.IOperation;
import View.IView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class showAmountOfPortfolioByDate implements IActions {
  private Scanner in;
  private IView view;
  private IOperation operation;
  public showAmountOfPortfolioByDate(IOperation operation, IView view){
   this.operation = operation;
   this.in = new Scanner(System.in);
   this.view=view;
  }

  @Override
  public void go() {
    view.showPortfolioMessage();
    String portfolioName = in.nextLine();
    if(operation.getPortfolio(portfolioName)) {
      view.showValidPortfolio();
      System.out.println("Enter the date at which you want to see portfolio value:");
      String date = in.nextLine();
      while(true) {
        if(isValid(date)) {
          double value = operation.getPortfolioByDate(portfolioName, date);
          System.out.println("Total portfolio value: " + value);
          break;
        } else {
          System.out.println("Please enter a valid date!");
          date = in.nextLine();
        }
      }
    }
  }

  public static boolean isValid(String text) {
    if (text == null || !text.matches("\\d{4}-[01]\\d-[0-3]\\d"))
      return false;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    df.setLenient(false);
    try {
      df.parse(text);
      return true;
    } catch (ParseException ex) {
      return false;
    }
  }
}
