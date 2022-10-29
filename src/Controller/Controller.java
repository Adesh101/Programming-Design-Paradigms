package Controller;

import Controller.actions.IActions;
import Model.Portfolio.IPortfolio;
import Model.Stocks.IStocks;
import Model.User.IUser;
import View.IView;
import Controller.actions.createPortfolio;
import java.io.InputStream;
import java.util.Scanner;

public class Controller implements IController {

  private InputStream in;
  private Scanner in2;
  private IUser user;
  private IView view;
  private IActions action;
  private IPortfolio p;
  private IStocks stock;

  public Controller(IView view, InputStream in, IStocks stock, IPortfolio p, IActions action){
    //this.user = user;
    this.p = p;
    this.stock = stock;
    this.view = view;
    this.action=action;
    this.in2 = new Scanner(in);
  }

  //private createPortfolio cP = new createPortfolio(p, view, stock, in);


  @Override
  public void go() {
    action.go();

  }
}
