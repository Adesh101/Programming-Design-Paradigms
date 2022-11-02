import Controller.IController;
import Controller.Controller;
import Model.Operation.IOperation;
import Model.Operation.Operation;
import Model.Portfolio.IPortfolio;
import Model.Portfolio.Portfolio;
import Model.Stocks.IStocks;
import Model.Stocks.Stocks;
import View.IView;
import View.View;
import java.io.InputStreamReader;


public class MVCStocks {

  public static void main(String[] args) {
    IStocks stocks = new Stocks();
    IPortfolio portfolio = new Portfolio("");
    IOperation operation = new Operation(stocks, portfolio);
    IView view = new View(new InputStreamReader(System.in), System.out);
    IController controller = new Controller(operation, view);
    controller.go();
  }
}
