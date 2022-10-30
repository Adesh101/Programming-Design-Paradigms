package Model.Portfolio;

import Model.Operation.Operation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Portfolio implements IPortfolio{

  protected String name;
  protected HashMap<String, HashMap<String, List<String>>> portfolios = new HashMap<String, HashMap<String, List<String>>>();
  protected double totalValue;

  public Portfolio(String name){
    this.name = name;
    this.totalValue = 0;
    this.portfolios.put(name, new HashMap<String, List<String>>());
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
  public Portfolio setPortfolioName(String ticker) {
    Portfolio portfolio = new Portfolio(ticker);
    return portfolio;
  }

  @Override
  public String getPortfolioName() {
    //return this.portfolios.ge
    return null;
  }

  @Override
  public void addStocksToPortfolio(String portfolioName, String ticker, int quantity, double price) {
    if(portfolios.containsKey(portfolioName)){
      if(portfolios.get(portfolioName).containsKey(ticker)){
        double existingPrice = Double.parseDouble(portfolios.get(portfolioName).get(ticker).get(0));
        //Recheck existingPrice+price
        portfolios.get(portfolioName).get(ticker).set(0, String.valueOf((existingPrice+price)/2));
        int existingNoOfStocks = Integer.parseInt(portfolios.get(portfolioName).get(ticker).get(1));
        portfolios.get(portfolioName).get(ticker).set(1, String.valueOf(existingNoOfStocks+quantity));
        double existingTotalStockValue = Double.parseDouble(portfolios.get(portfolioName).get(ticker).get(2));
        portfolios.get(portfolioName).get(ticker).set(2, String.valueOf(existingTotalStockValue + (quantity*price)));
        this.totalValue = totalValue + (quantity*price);
      } else {
        portfolios.get(portfolioName).put(ticker, new ArrayList<String>());
        portfolios.get(portfolioName).get(ticker).add(String.valueOf(price));
        portfolios.get(portfolioName).get(ticker).add(String.valueOf(quantity));
        portfolios.get(portfolioName).get(ticker).add(String.valueOf(quantity*price));
        this.totalValue = totalValue + (quantity*price);
      }
    } else {
      portfolios.put(portfolioName, new HashMap<String, List<String>>());
    }
  }

  @Override
  public Set<String> portfolioNames() {
    System.out.println(portfolios);
    return portfolios.keySet();
  }

  @Override
  public HashMap<String, List<String>> getPortfolioComposition(String portfolioName) {
    return this.portfolios.get(portfolioName);
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
  public ArrayList<String> getPortfolioNames() {
    ArrayList<String> names= new ArrayList<String>();
    for(String s : portfolios.keySet()){
      //System.out.println(s);
      names.add(s);
    }
    //System.out.println(portfolios);
    //return portfolios.keySet();
    return names;


  }
}
