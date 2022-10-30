import Controller.IController;
import Controller.Controller;
import Model.Operation.IOperation;
import Model.Operation.Operation;
import View.IView;
import View.View;


public class MVCStocks {

  public static void main(String[] args) {
    //IUser user = new User();
//    IStocks stock = new Stocks("");
//    InputStream in = null;
//    Portfolio portfolio = new Portfolio("");
//    IView view = new View(System.out);
//    IActions action = new createNewPortfolio(portfolio, view, stock, in);
//    IController controller = new Controller(view, System.in, stock, portfolio, action);
//    controller.go();
    IOperation operation = new Operation();
    IView view = new View(System.out);
    IController controller = new Controller(operation, view);
    controller.go();
  }
}
