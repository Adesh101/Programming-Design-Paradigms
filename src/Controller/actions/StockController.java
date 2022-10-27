package Controller.actions;

import Model.Stocks.IStocks;
import View.View;
import java.io.InputStream;
import java.util.Scanner;

public class StockController implements IActions{
  private Scanner in;
  private IStocks stock;
  private View view;

  public StockController(IStocks stock, View view, InputStream in){
    this.stock = stock;
    this.view = view;
    this.in = new Scanner(in);
  }

  public void go() {
    view.showStockMenu();
    //stock.
  }
}
