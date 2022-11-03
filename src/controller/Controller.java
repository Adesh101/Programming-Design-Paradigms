package controller;

import controller.actions.IActions;
import controller.actions.AddStockToPortfolio;
import controller.actions.CreateNewPortfolio;
import controller.actions.CreateNewPortfolioCSV;
import controller.actions.ShowAmountOfPortfolioByDate;
import controller.actions.ShowComposition;
import controller.actions.ShowExistingPortfolios;
import model.operation.IOperation;
import view.IView;

/**
 * This is the main controller of the program. This controller will handle input and pass them to
 * the appropriate child controllers.
 */
public class Controller implements IController {

  private IOperation operation;
  private IView view;
  private IActions action;

  /**
   * Constructor for the main controller.
   *
   * @param: operation
   * @param: view
   * @throws: IllegalArgumentException
   */
  public Controller(IOperation operation, IView view) throws IllegalArgumentException {
    if (operation == null || view == null) {
      throw new IllegalArgumentException();
    }
    this.operation = operation;
    this.view = view;
  }

  @Override
  public void operate(IOperation operation) {
    view.showWelcomeMessage();
    view.showMenu();
    String menuOption = "";
    try {
      while (true) {
        try {
          menuOption = view.fetchInput();
          break;
        } catch (Exception ex) {
          System.out.println("PLEASE ENTER A NUMBER FROM THE FOLLOWING OPTIONS PRESENTED ABOVE.");
          view.fetchInput();
        }
      }
      boolean flag = false;
      while (!flag) {
        flag = true;
        try {
          switch (menuOption) {
            case "1":
              String option = view.showPortfolioMenuOption();
              if (option.equals("1")) {
                action = new CreateNewPortfolio(view.showEnterNewPortfolioName());
                view.displayInput(action.operate(operation));
              } else if (option.equals("2")) {
                String fileName = view.showFileName();
                action = new CreateNewPortfolioCSV(fileName);
                view.displayInput(action.operate(operation));//;
              }
              view.showMenu();
              menuOption = view.fetchInput();
              flag = false;
              break;
            case "2":
              String continueAdditionOfStocks = "Y";
              String input = "";
              while (continueAdditionOfStocks.equalsIgnoreCase("Y")
                  || continueAdditionOfStocks.equalsIgnoreCase("y")) {
                input = view.showEnterPortfolioToAddStocks();
                action = new AddStockToPortfolio(input, view.showTicker(), view.showQuantity());
                view.displayInput(action.operate(operation));
                continueAdditionOfStocks = view.showPostConfirmation();
              }
              operation.writeToCSV(input);
              flag = false;
              view.showMenu();
              menuOption = view.fetchInput();
              break;
            case "3":
              action = new ShowExistingPortfolios();
              view.displayInput(action.operate(operation));
              flag = false;
              view.showMenu();
              menuOption = view.fetchInput();
              break;
            case "4":
              action = new ShowAmountOfPortfolioByDate(view.showEnterNewPortfolioName(),
                  view.showDate());
              view.displayInput(action.operate(operation));
              flag = false;  //NEED TO ADD FUNCTION FOR DATE VALIDATION.6
              view.showMenu();
              menuOption = view.fetchInput();
              break;
            case "5":
              action = new ShowComposition(view.showEnterNewPortfolioName());
              view.displayInput(action.operate(operation));
              flag = false;
              view.showMenu();
              menuOption = view.fetchInput();
              break;
            case "6":
              flag = true;
              break;
            default:
              System.out.println("INVALID RESPONSE.");
              flag = false;
              menuOption = view.fetchInput();
          }
        } catch (Exception ex) {
          view.displayInput(ex.getMessage());
          view.showMenu();
          menuOption = view.fetchInput();
          flag = false;
          flag = false;
        }
      }
    } catch (Exception ex) {
      view.displayInput(ex.getMessage());
      view.showMenu();
    }
  }
}
