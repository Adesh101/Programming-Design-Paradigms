package Controller;

import Controller.actions.IActions;
import Controller.actions.addStockToPortfolio;
import Controller.actions.createNewPortfolio;
import Controller.actions.createNewPortfolioCSV;
import Controller.actions.showAmountOfPortfolioByDate;
import Controller.actions.showComposition;
import Controller.actions.showExistingPortfolios;
import Model.Operation.IOperation;
import View.IView;

public class Controller implements IController {
  private IOperation operation;
  private IView view;
  private IActions action;

  public Controller(IOperation operation, IView view) throws IllegalArgumentException {
    if(operation == null || view == null)
      throw new IllegalArgumentException();
    this.operation = operation;
    this.view = view;
  }

//  @Override
//  public void go() {
//    while(true) {
//      view.showMenu();
//      String menuOption = view.fetchInput();
//      if(menuOption.equals("q"))
//        view.displayInput("Exiting program");
//        break;
//      switch (menuOption) {
//        case "1":
//          String option = view.showPortfolioMenuOption();
//          if (option.equals("1")) {
//            action = new createNewPortfolio(operation, view);
//            action.go();
//          } else if (option.equals("2")) {
//            String fileName = view.showFileName();
//            action = new createNewPortfolioCSV(operation, view, fileName);
//            action.go();
//          }
//          view.showMenu();
//          menuOption = view.fetchInput();
//          flag = false;
//          break;
//        case "2":
//          if(operation.getExistingPortfolios().length==0){
//            view.showNoPortfoliosPresent();
//          }
//          else {
//            action = new addStockToPortfolio(operation, view);
//            action.go();
//          }
//          flag = false;
//          view.showMenu();
//          menuOption = view.fetchInput();
//          break;
//        case "3":
//          action = new showExistingPortfolios(operation, view);
//          action.go();
//          flag = false;
//          view.showMenu();
//          menuOption = view.fetchInput();
//          break;
//        case "4":
//          action = new showAmountOfPortfolioByDate(operation, view);
//          action.go();
//          flag = false;
//          view.showMenu();
//          menuOption = view.fetchInput();
//          break;
//        case "5":
//          action = new showComposition(operation, view);
//          action.go();
//          flag = false;
//          view.showMenu();
//          menuOption = view.fetchInput();
//          break;
//        case "6":
//          flag=true;
//          break;
//        default:
//          System.out.println("Invalid Response. ");
//          flag=false;
//          menuOption= view.fetchInput();
//      }
//    }
//  }
  @Override
  public void go(IOperation operation) {
    view.showWelcomeMessage();
    view.showMenu();
    String menuOption = "";
    try {
      while(true) {
        try {
          menuOption = view.fetchInput();
          break;
        } catch (Exception ex) {
          System.out.println("Please enter a number from the following options presented above.");
          view.fetchInput();
        }
      }
      boolean flag=false;
      while(!flag) {
        flag=true;
        switch (menuOption) {
          case "1":
            String option = view.showPortfolioMenuOption();
            if (option.equals("1")) {
              action = new createNewPortfolio(view.showEnterNewPortfolioName());
              view.displayInput(action.go(operation));
            } else if (option.equals("2")) {
              String fileName = view.showFileName();
              action = new createNewPortfolioCSV(fileName);
              view.displayInput(action.go(operation));//;
            }
            view.showMenu();
            menuOption = view.fetchInput();
            flag = false;
            break;
          case "2":
            String continueAdditionOfStocks = "Y";
            while(continueAdditionOfStocks.equals("Y")) {
              action = new addStockToPortfolio(view.showEnterPortfolioToAddStocks(), view.showTicker(), view.showQuantity());
              view.displayInput(action.go(operation));
              continueAdditionOfStocks = view.showPostConfirmation();
            }
            flag = false;
            view.showMenu();
            menuOption = view.fetchInput();
            break;
          case "3":
            action = new showExistingPortfolios();
            view.displayInput(action.go(operation));
            flag = false;
            view.showMenu();
            menuOption = view.fetchInput();
            break;
          case "4":
            action = new showAmountOfPortfolioByDate(view.showEnterNewPortfolioName(), view.showDate());
            view.displayInput(action.go(operation));
            flag = false;  //NEED TO ADD FUNCTION FOR DATE VALIDATION.6
            view.showMenu();
            menuOption = view.fetchInput();
            break;
          case "5":
            action = new showComposition(view.showEnterNewPortfolioName());
            view.displayInput(action.go(operation));
            flag = false;
            view.showMenu();
            menuOption = view.fetchInput();
            break;
          case "6":
            flag=true;
            break;
          default:
            System.out.println("Invalid Response. ");
            flag=false;
            menuOption= view.fetchInput();
        }
      }
    } catch (Exception ex) {
      view.displayInput(ex.getMessage());
      view.showMenu();
      view.fetchInput();
    }
  }
}
