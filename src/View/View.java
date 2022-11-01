package View;

import java.io.PrintStream;


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

  @Override
  public void showError() {
    out.println("Enter valid input");
  }
  @Override
  public void showMenu(){
    out.println("1. Create new portfolio");
    out.println("2. Add stocks to newly created portfolio");
    out.println("3. View all portfolio names");
    out.println("4. View amount by date");
    out.println("5. View Composition of Portfolio");
    out.println("6. Quit");
    out.println("Enter valid choice");
  }
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
  public void showConfirmation(double price){
    out.println("The current price of the stock is: "+price);
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
  public void showOrderCompleted(){
    out.println("Order Completed.");
  }
  @Override
  public void showMenuMessage() {
    out.println("Portfolio locked!");
    out.println("Going to the main menu.");
  }

  @Override
  public void showPortfolioNames(String[] names) {
    for(int i=0;i<names.length;i++){
      out.println(i+1 + " " + names[i]);
    }
  }

  @Override
  public void showEnterPortfolioToAddStocks() {
    out.println("Enter portfolio name to add stocks!");
  }

  @Override
  public void showValidPortfolio() {
    out.println("Portfolio found!");
  }

  @Override
  public void showPortfolioMessage() {
    out.println("Enter portfolio name : ");
  }

  @Override
  public void showValidQuantity() {
    out.println("Quantity cannot be fractional. Please enter whole numbers!");
  }

  @Override
  public void showStockPortfolio(String[][] composition) {
    System.out.println("Your portfolio composition is: ");
    for(int i=0;i<composition.length;i++){
      int j=0;
      System.out.println("Ticker : "+ composition[i][j]+" Buy Price : "+composition[i][++j]+" Quantity : "+composition[i][++j]+" Current Value : "+composition[i][++j]);
    }
  }

  @Override
  public void showAllPortfolioNames(String names){
    out.println(names);

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
  public void showPortfolioLockedError() {
    out.println("This portfolio is locked");
    out.println("Enter unlocked portfolio name or create a new portfolio");
  }

  @Override
  public void showFractionalShareError() {
    out.println("Fractional shares purchase not allowed");
  }

  @Override
  public void showPortfolioExists() {
    out.println("Portfolio already exists");
  }

  @Override
  public void showPortfolioCreatedSuccessfully(String name) {
    out.println("Portfolio "+name+" Created Succesfully");
  }

  @Override
  public void showNoPortfoliosPresent() {
    out.println("No portfolios Found");
  }

}
