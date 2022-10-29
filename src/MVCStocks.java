import Controller.IController;
import Controller.Controller;
import Controller.actions.IActions;
import Controller.actions.createPortfolio;
import Model.Portfolio.Portfolio;
import Model.Stocks.Stocks;
import Model.Stocks.IStocks;
import Model.User.IUser;
import Model.User.User;
import Model.Stocks.IStocks;
import Model.Portfolio.IPortfolio;
import View.IView;
import View.View;
import java.io.InputStream;


public class MVCStocks {

  public static void main(String[] args) {
    //IUser user = new User();
    IStocks stock = new Stocks("");
    InputStream in = null;
    IPortfolio portfolio = new Portfolio("");
    IView view = new View(System.out);
    IActions action = new createPortfolio(portfolio, view, stock, in);
    IController controller = new Controller(view, System.in, stock, portfolio, action);
    controller.go();
  }
}
