package Model.Portfolio;

import Model.Operation.Operation;
import java.io.PrintStream;
import java.util.Scanner;

public class Portfolio implements IPortfolio{
  private Scanner in = new Scanner(System.in);
  private Operation operation;
  @Override
  public void setPortfolioChoice(int choice) {
    try{
      boolean invalidChoice = !(choice == 1 || choice == 2);
      if(invalidChoice)
        throw new IllegalArgumentException();
      if(choice == 1)
        createPortfolio();
      else
        getPortfolio();
    } catch (IllegalArgumentException e){
        System.out.println("Invalid choice. Please enter valid choice to proceed");
        setPortfolioChoice(in.nextInt());
    }

  }
  @Override
  public void getTicker(){

  }
  @Override
  public void getQuantity(){

  }
  @Override
  public String getOrderConfirmation(String choice){
    try{
      if(choice.toUpperCase()=="Y")
        createPortfolio();
      else if (choice.toUpperCase()=="N")
        operation.quit();
      else
        throw new IllegalArgumentException();
    }
    catch (IllegalArgumentException e){
      System.out.println("Invalid Response. Enter Valid Response Again");
      getOrderConfirmation(in.next());
    }
    return choice;
  }
  @Override
  public void getNewPortfolioName(){

  }
  @Override
  public void createPortfolio(){
    //addSock()
    //sellStock()


  }

  @Override
  public void lockPortfolio() {

  }

  @Override
  public void getPortfolio() {

  }
}
