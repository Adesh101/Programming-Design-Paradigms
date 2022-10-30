package Model.Portfolio;

import Model.Operation.Operation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Portfolio implements IPortfolio{

  private String name;
  private HashMap<String, HashMap<String, List<String>>> portfolios = new HashMap<String, HashMap<String, List<String>>>();
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
  public HashMap<String, HashMap<String, List<String>>> getPortfolio() {
    System.out.println(portfolios);
    return portfolios;
  }

//  @Override
//  public void setNewPortfolioName(String name){
//
//  }

  @Override
  public void fetchStockPrice(String ticker) {

  }

  @Override
  public void setPortfolioName(String ticker) {
    Portfolio portfolio = new Portfolio(ticker);
  }

  @Override
  public void addStocksToPortfolio(String ticker, int quantity, double price) {
    if(portfolios.containsKey(this.name)){
      if(portfolios.get(this.name).containsKey(ticker)){
        double existingPrice = Double.parseDouble(portfolios.get(this.name).get(ticker).get(0));
        //Recheck existingPrice+price
        portfolios.get(this.name).get(ticker).set(0, String.valueOf((existingPrice+price)/2));
        int existingNoOfStocks = Integer.parseInt(portfolios.get(this.name).get(ticker).get(1));
        portfolios.get(this.name).get(ticker).set(1, String.valueOf(existingNoOfStocks+quantity));
        double existingTotalStockValue = Double.parseDouble(portfolios.get(this.name).get(ticker).get(2));
        portfolios.get(this.name).get(ticker).set(2, String.valueOf(existingTotalStockValue + (quantity*price)));
        this.totalValue = totalValue + (quantity*price);
      } else {
        portfolios.get(this.name).put(ticker, new ArrayList<String>());
        portfolios.get(this.name).get(ticker).add(String.valueOf(price));
        portfolios.get(this.name).get(ticker).add(String.valueOf(quantity));
        portfolios.get(this.name).get(ticker).add(String.valueOf(quantity*price));
        this.totalValue = totalValue + (quantity*price);
      }
    } else {
      portfolios.put(this.name, new HashMap<String, List<String>>());
    }
  }

  @Override
  public HashMap<String, List<String>> getPortfolioComposition() {
    return this.portfolios.get(this.name);
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
  public Set<String> getPortfolioNames() {
//    ArrayList<String> names= new ArrayList<String>();
//    for(String s : portfolios.keySet()){
//      System.out.println(s);
//      names.add(s);
//    }
    System.out.println(portfolios);
    return portfolios.keySet();


  }
}
