package Controller.actions;

import Model.Portfolio.IPortfolio;
import View.View;
import java.io.InputStream;
import java.util.Scanner;

public class PortfolioController implements IActions{

  private Scanner in;
  private IPortfolio portfolio;
  private View view;

  public PortfolioController(IPortfolio portfolio, View view, InputStream in){
    this.portfolio = portfolio;
    this.view = view;
    this.in = new Scanner(in);
  }

  public void go() {
    view.showCreateNew();
    view.showExisting();
    portfolio.setPortfolioChoice(in.nextInt());
  }
}
