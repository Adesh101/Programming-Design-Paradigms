package View;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class View implements IView {

  private Appendable out;
  private Scanner scanner;

  public View(Readable in, Appendable out) throws IllegalArgumentException {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Input or output cannot be null.");
    }
    Readable read = in;
    this.out = out;
    scanner = new Scanner(read);
  }

  @Override
  public String fetchInput() {
    return nextInput();
  }

  private String nextInput() throws IllegalArgumentException {
    try {
      return this.scanner.next();
    }
    catch (Exception e) {
      throw new IllegalArgumentException("Invalid input.");
    }
  }

  public void displayInput(String input) {
    try {
      out.append(input).append("\n");
    }
    catch (IOException e) {
      throw new IllegalArgumentException("Invalid input.");
    }
  }

  @Override
  public void showWelcomeMessage() {
    StringBuilder sb = new StringBuilder();
    sb.append("Welcome! Enter the number denoting the operation to be performed:");
    displayInput(sb.toString());
  }

  @Override
  public void showError() {
    displayInput("Enter valid input");
  }

  @Override
  public void showMenu(){
    StringBuilder sb = new StringBuilder();
    sb.append("1. Create new portfolio\n");
    sb.append("2. Add stocks to newly created portfolio\n");
    sb.append("3. View all portfolio names\n");
    sb.append("4. View amount by date\n");
    sb.append("5. View Composition of Portfolio\n");
    sb.append("6. Quit\n");
    sb.append("Enter valid choice");
    displayInput(sb.toString());
  }

  @Override
  public String showEnterNewPortfolioName(){
    displayInput("Enter a name for the new portfolio");
    return nextInput();
  }

  @Override
  public String showTicker(){
    displayInput("Enter ticker of the stock you wish to buy.");
    return nextInput();
  }

  @Override
  public int showQuantity(){
    while(true) {
      displayInput("Enter quantity of the stock you want to buy.");
      String quantity = nextInput();
      try{
        int quantityInt = Integer.parseInt(quantity);
        return quantityInt;
      } catch (InputMismatchException ex) {
        displayInput("Please enter whole numbers!");
      }
    }
  }

  @Override
  public String showPostConfirmation(){
    displayInput("Order placed successfully!");
    while(true) {
      displayInput("Do you wish to add more stocks?(Y/N)");
      String confirmation = nextInput();
      if (confirmation.equals("Y") || confirmation.equals("N")) {
        return confirmation;
      }
      displayInput("Invalid input. Enter valid input!");
    }
  }

  @Override
  public String showQuit() {
    while (true) {
      displayInput("Do you want to quit?(Y/N)");
      String confirmation = nextInput();
      if (confirmation.equals("Y") || confirmation.equals("N")) {
        return confirmation;
      }
      displayInput("Invalid input. Enter valid input!");
    }
  }

  @Override
  public String showStockMenu() {
      StringBuilder sb = new StringBuilder();
      sb.append("Select one of the option:");
      sb.append("1. Buy a stock");
      sb.append("2. Sell a stock");
      displayInput(sb.toString());
      while (true) {
        String option = nextInput();
        if (option.equals("1") || option.equals("2")) {
          return option;
        }
      displayInput("Invalid input. Enter valid input!");
    }
  }

  @Override
  public String showPortfolioMenuOption() {
    StringBuilder sb = new StringBuilder();
    sb.append("1. Create new portfolio through console\n");
    sb.append("2. Create new portfolio through file");
    displayInput(sb.toString());
    while (true) {
      String option = nextInput();
      if (option.equals("1") || option.equals("2")) {
        return option;
      }
      displayInput("Invalid input. Enter valid input!");
    }
  }

  @Override
  public void showInvalidPortfolioName() {
    displayInput("Please enter a valid portfolio name!");
  }

  @Override
  public String showFileName() {
    displayInput("Enter file name");
    return nextInput();
  }

  @Override
  public void showInvalidFileError() {
    displayInput("Invalid file.");
  }

  @Override
  public void showOrderCompleted(){
    displayInput("Order Completed.");
  }

  @Override
  public void showMenuMessage() {
    displayInput("Portfolio locked!");
    displayInput("Going to the main menu.");
  }

  @Override
  public void showPortfolioNames(String[] names) {
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<names.length;i++){
      sb.append(i+1 + " " + names[i]).append("\n");
    }
    displayInput(sb.toString());
  }

  @Override
  public void showEnterPortfolioToAddStocks() {
    displayInput("Enter portfolio name to add stocks!");
  }

  @Override
  public void showValidPortfolio() {
    displayInput("Portfolio found!");
  }

  @Override
  public void showPortfolioMessage() {
    displayInput("Enter portfolio name : ");
  }

  @Override
  public void showStockPortfolio(String[][] composition) {
    StringBuilder sb = new StringBuilder();
    sb.append("Your portfolio composition is: \n");
    for(int i=0;i<composition.length;i++){
      int j=0;
      sb.append("Ticker : ");
      sb.append(composition[i][j]);
      sb.append(" Quantity: ");
      sb.append(composition[i][++j]);
      sb.append(" Buy Price : ");
      sb.append(composition[i][++j]);
      sb.append(" Current Value : ");
      sb.append(composition[i][++j]);
      sb.append("\n");
    }
    displayInput(sb.toString());
  }

  @Override
  public void showAllPortfolioNames(String names){
    displayInput(names);
  }

  @Override
  public void showTickerError() {
    displayInput("Please enter a valid ticker!");
  }

  @Override
  public void showPortfolioLockedError() {
    displayInput("This portfolio is locked");
    displayInput("Enter unlocked portfolio name or create a new portfolio");
  }

  @Override
  public void showPortfolioExists() {
    displayInput("Portfolio already exists");
  }

  @Override
  public void showPortfolioCreatedSuccessfully(String name) {
    displayInput("Portfolio "+ name +" created succesfully.");
  }

  @Override
  public void showNoPortfoliosPresent() {
    displayInput("No portfolios Found");
  }
}
