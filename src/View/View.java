package View;

import java.io.PrintStream;

public class View implements IView {

  private PrintStream out;

  public View(PrintStream out){
    this.out = out;
  }

  @Override
  public void showWelcomeMessage() {
    out.println("Welcome! Enter following details:");
  }

  @Override
  public void showFirstName() {
    out.println("Enter first name:");
  }

  @Override
  public void showLastName() {
    out.println("Enter last name:");
  }

  @Override
  public void showAccountID() {
    out.println("Enter account id:");
  }

  @Override
  public void showInitialBalance() {
    out.println("Enter initial balance:");
  }

  @Override
  public void showError() {
    out.println("Enter valid input");
  }

  @Override
  public void showStockMenu() {
    out.println("Select one of the option:");
    out.println("1. Buy a stock");
    out.println("2. Sell a stock");
  }

  @Override
  public void showStockBuy() {
    out.println("Enter stock ticker to buy:");
  }

  @Override
  public void showStockSell() {
    out.println("Enter stock ticker to sell:");
  }

  @Override
  public void showTickerError() {
    out.println("Please enter a valid ticker!");
  }

  @Override
  public void showCreateNew() {
    out.println("To create new portfolio, Enter 1");
  }

  @Override
  public void showExisting() {
    out.println("To manage existing portfolio, Enter 2");
  }
}
