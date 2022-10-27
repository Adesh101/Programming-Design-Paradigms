package Controller;

import Model.Portfolio.IPortfolio;
import View.IPortfolioView;
import java.io.InputStream;
import java.util.Scanner;

public class PortfolioController implements IPortfolioController {

  private Scanner in;
  private IPortfolio portfolio;
  private IPortfolioView view;

  public PortfolioController(IPortfolio portfolio, IPortfolioView view, InputStream in){
    this.portfolio = portfolio;
    this.view = view;
    this.in = new Scanner(in);
  }
  @Override
  public void go() {
    view.showCreateNew();
    view.showExisting();
    portfolio.setPortfolioChoice(in.nextInt());

  }
}
