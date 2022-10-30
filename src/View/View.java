package View;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;

public class View implements IView {

  private PrintStream out;

  public View(PrintStream out){
    this.out = out;
  }

  public void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  @Override
  public void showWelcomeMessage() {
    out.println("Welcome! Enter the number denoting the operation to be performed:");
  }

//  @Override
//  public void showFirstName() {
//    out.println("Enter first name:");
//  }
//
//  @Override
//  public void showLastName() {
//    out.println("Enter last name:");
//  }
//
//  @Override
//  public void showAccountID() {
//    out.println("Enter account id:");
//  }
//
//  @Override
//  public void showInitialBalance() {
//    out.println("Enter initial balance:");
//  }

  @Override
  public void showError() {
    out.println("Enter valid input");
  }
  @Override
  public void showMenu(){
    out.println("1. Create new portfolio");
    out.println("2. View existing portfolios"); // all portfolio names
    out.println("3. View stocks held in the portfolio"); // portflio name from user
    out.println("4. View invested amount of specific portfolio");
    out.println("5. View current amount of specific portfolio");
    out.println("6. View amount of specific portfolio by date");
    out.println("7. View transaction history");
  }
  // Create New Portfolio
  @Override
  public void showEnterNewPortfolioName(){
    out.println("Enter a name for the new portfolio");
  }
  @Override
  public void showTicker(){
    out.println("Enter ticker of the stock you wish to buy.");
  }
  @Override
  public void showQuantity(){
    out.println("Enter quantity of the stock you want to buy.");
  }
  @Override
  public void showConfirmation(){
    out.println("The current price of the stock is"); // getprice from stocks
    out.println("Are you sure you want to proceed with the transaction?(Y/N)");
  }
  @Override
  public void showOrderConfirmationDeclined(){
    out.println("Your order was cancelled.");
  }

  @Override
  public void showPostConfirmation(){
    out.println("Order placed successfully!");
    out.println("Do you wish to add more stocks?(Y/N)");
  }

  @Override
  public void showQuit(){
    out.println("Do you want to quit?(Y/N)");
  }

  @Override
  public void showStockMenu() {
    out.println("Select one of the option:");
    out.println("1. Buy a stock");
    out.println("2. Sell a stock");
  }

  @Override
  public void showCurrentPrice(double text) {
    out.println("The price of the current stock is : "+text);
    out.println("Are you sure you wish to proceed with the transaction?(Y/N)");
  }

  @Override
  public void showOrderCancelled() {
    out.println("Order cancelled!");
    out.println("Going back to the main menu");
    clearScreen();
  }

  @Override
  public void showStockPortfolio(HashMap<String, List<String>> map, double value) {
    System.out.println("Your portfolio composition is: ");
    System.out.println("Ticker : Buy Price : Quantity : Current Value");
    for (String string : map.keySet()) {
      String ticker = string.toString();
      String price = map.get(string).get(0);
      String quantity = map.get(string).get(1);
      String currentValue = map.get(string).get(2);
      System.out.println(ticker + " : " + price + " : " + quantity + " : " + currentValue);
    }
    System.out.println("Your total portfolio value is : " + value);
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

//  @Override
//  public void showCreateNew() {
//    out.println("To create new portfolio, Enter 1");
//  }
//
//  @Override
//  public void showExisting() {
//    out.println("To manage existing portfolio, Enter 2");
//  }
}
