package Model.Portfolio;

import java.io.PrintStream;
import java.util.Scanner;

public class Portfolio implements IPortfolio{
  private Scanner in = new Scanner(System.in);
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
