package Model.Portfolio;

import Model.Operation.Operation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Portfolio implements IPortfolio{

  private String name;
  private HashMap<String, List<String>> stocks = new HashMap<String, List<String>>();
  private double totalValue;

  public Portfolio(String name){
    this.name = name;
    this.totalValue = 0;
  }

  private Scanner in = new Scanner(System.in);
  private Operation operation;

  @Override
  public void getTicker(){

  }
  @Override
  public void getQuantity(){

  }

  @Override
  public String getOrderConfirmation(String choice) {
    return null;
  }

  @Override
  public void getNewPortfolioName(){

  }

  @Override
  public void fetchStockPrice(String ticker) {

  }

  @Override
  public void addStocksToPortfolio(String ticker, int quantity, double price) {
    if(stocks.containsKey(ticker)){
      double existingPrice = Double.parseDouble(stocks.get(ticker).get(0));
      stocks.get(ticker).set(0, String.valueOf((existingPrice+price)/2));
      int existingNoOfStocks = Integer.parseInt(stocks.get(ticker).get(1));
      stocks.get(ticker).set(1, String.valueOf(existingNoOfStocks+quantity));
      double existingTotalStockValue = Double.parseDouble(stocks.get(ticker).get(2));
      stocks.get(ticker).set(2, String.valueOf(existingTotalStockValue + (quantity*price)));
      this.totalValue = totalValue + (quantity*price);
    } else {
      stocks.put(ticker, new ArrayList<String>());
      stocks.get(ticker).add(String.valueOf(price));
      stocks.get(ticker).add(String.valueOf(quantity));
      stocks.get(ticker).add(String.valueOf(quantity*price));
      this.totalValue = totalValue + (quantity*price);
    }
  }

  @Override
  public HashMap<String, List<String>> getPortfolioComposition() {
    return this.stocks;
  }

  @Override
  public double totalPortfolioValue() {
    return this.totalValue;
  }

  @Override
  public void createPortfolio(){
    //addSock()
    //sellStock()


  }

  @Override
  public void lockPortfolio() {

  }

  @Override
  public void getPortfolio() {

  }
}
