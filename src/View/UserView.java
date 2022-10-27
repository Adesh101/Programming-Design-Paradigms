package View;

import java.io.PrintStream;

public class UserView implements IUserView {

  private PrintStream out;

  public UserView(PrintStream out){
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
    out.println("Enter valid input");}
}
