package Controller;

import Controller.actions.IActions;
import Controller.actions.addStockToPortfolio;
import Controller.actions.showAmountOfPortfolioByDate;
import Controller.actions.showComposition;
import Controller.actions.showExistingPortfolios;
import Model.Operation.IOperation;
import View.IView;
import java.util.Scanner;
import Controller.actions.createNewPortfolio;

public class Controller implements IController {
  private IOperation operation;
  private IView view;
  private IActions action;
  private Scanner in;

  public Controller(IOperation operation, IView view) throws IllegalArgumentException {
    if(operation == null || view == null)
      throw new IllegalArgumentException();
    this.operation = operation;
    this.view = view;
    this.in = new Scanner(System.in);
  }

  @Override
  public void go() {
    view.showMenu();
    int menuOption = in.nextInt();
    boolean flag=false;
    while(!flag) {
      flag=true;
      switch (menuOption) {
        case 1:
          action = new createNewPortfolio(operation, view);
          action.go();
          view.showMenu();
          menuOption = in.nextInt();
          flag = false;
          break;
        case 2:
          if(operation.getExistingPortfolios().length==0){
            view.showNoPortfoliosPresent();
          }
          else {
            action = new addStockToPortfolio(operation, view);
            action.go();
          }
          flag = false;
          view.showMenu();
          menuOption = in.nextInt();
          break;
        case 3:
          action = new showExistingPortfolios(operation, view);
          action.go();
          flag = false;
          view.showMenu();
          menuOption = in.nextInt();
          break;
        case 4:
          action = new showAmountOfPortfolioByDate(operation, view);
          action.go();
          flag = false;
          view.showMenu();
          menuOption = in.nextInt();
          break;
        case 5:
          action = new showComposition(operation, view);
          action.go();
          flag = false;
          view.showMenu();
          menuOption = in.nextInt();
          break;
        case 6:
          flag=true;
          break;
        default:
          System.out.println("Invalid Response. ");
          flag=false;
          menuOption= in.nextInt();
      }
    }
    //action.go();

  }
}
