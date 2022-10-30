package Controller;

import Controller.actions.IActions;
import Controller.actions.addStockToPortfolio;
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
          menuOption = in.nextInt();
          flag = false;
          break;
        case 2:
          action = new addStockToPortfolio(operation, view);
          action.go();
          flag = false;
          menuOption = in.nextInt();
          break;
        case 3:

          break;
        case 4:

          break;
        case 5:

          break;
        case 6:

          break;
        case 7:

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
