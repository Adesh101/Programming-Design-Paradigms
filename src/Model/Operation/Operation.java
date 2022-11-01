package Model.Operation;

import Model.Portfolio.IPortfolio;
import Model.Stocks.IStocks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Operation implements IOperation {
  protected HashMap<String, HashMap<String, List<String>>> portfolios = new HashMap<String, HashMap<String, List<String>>>();
  protected String portfolioName;
  protected double totalValue;
  protected IStocks stocks;
  protected IPortfolio portfolio;

  public Operation(IStocks stocks, IPortfolio portfolio) {
    this.portfolioName = "";
    this.totalValue = 0;
    this.portfolio = portfolio;
    this.stocks = stocks;
  }

  @Override
  public String createNewPortfolio(String portfolioName) {
    //Have to handle exception
    if(!portfolios.containsKey(portfolioName))
      this.portfolios.put(portfolioName, new HashMap<String, List<String>>());
    this.portfolioName = portfolioName;
    return this.portfolioName;
  }

  @Override
  public void addStockToPortfolio(String portfolioName, String ticker, int quantity, double price) {

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
  }

  @Override
  public boolean getPortfolio(String name) {
    if(!portfolios.containsKey(name))
      return false;
    return true;
  }
  @Override
  public boolean checkPortfolioAlreadyExists(String name){
    if(portfolios.containsKey(name))
      return true;
    return false;
  }

  @Override
  public String[] getExistingPortfolios() {
    //return portfolio.getPortfolioNames().toString();
    String[] names = new String[portfolios.size()];
    int i =0;
    for ( String key : portfolios.keySet() ) {
      names[i]=key;
      i++;
    }
    return names;
  }

  @Override
  public double getCurrentPrice(String ticker) {
    return stocks.getStockCurrentPrice(ticker);
  }

  @Override
  public void callStockAPIHelper(String ticker) {
    stocks.callStockAPI(ticker);
  }
  @Override
  public boolean isTickerValid(String ticker){
    String[] stockData = stocks.callStockAPI(ticker);
    if (stockData.length == 1)
      return false;
    return true;
  }

  @Override
  public boolean isQuantityValid(String quantity) {
    for (int i = 0; i < quantity.length(); i++) {
      char ch = quantity.charAt(i);
      if(!Character.isDigit(ch))
        return false;
    }
    return true;
  }

  @Override
  public double callStockAPIByDateHelper(HashMap<String, List<String>> map, String date) {
    double currentValue = 0;
    for (String string: map.keySet()) {
      stocks.callStockAPIByDate(string, date);
      double tempValue = stocks.getStockCurrentPriceByDate(string);
      tempValue *= Double.parseDouble(map.get(string).get(0));
      currentValue += tempValue;
    }
    return currentValue;
  }

  @Override
  public void getAmountByDate(String Date) {

  }

  @Override
  public void getCurrentPriceByDate(String ticker, String date) {

  }
  @Override
  public String[][] getStocksMap(String name){
    HashMap<String, List<String>> stocksMap=new HashMap<String, List<String>>();
    stocksMap=this.portfolios.get(name);
    String[][] composition = new String[stocksMap.size()][4];
    int i=0;
    for(String string : stocksMap.keySet()){
      int j=0;
      composition[i][j] = string.toString();
      composition[i][++j] = stocksMap.get(string).get(0);
      composition[i][++j] = stocksMap.get(string).get(1);
      composition[i][++j] = stocksMap.get(string).get(2);
      i++;
    }
    return composition;
  }

  @Override
  public int getMapSize(String portfolioName) {
    return this.portfolios.get(portfolioName).size();
  }

//  @Override
//  public String[] getPortfolioComposition(String portfolioName) {
//    String[] composition = new String[4*this.portfolios.get(portfolioName).size()];
////    return this.portfolios.get(portfolioName);
////    for (String string: this.portfolios.get(portfolioName).keySet()){
////      String ticker = string.toString();
////      String price = this.portfolios.get(portfolioName).get(string).get(0);
////      String quantity = this.portfolios.get(portfolioName).get(string).get(1);
////      String currentValue = this.portfolios.get(portfolioName).get(string).get(2);
////    }
//   int i=0;
//    for (String string: this.portfolios.get(portfolioName).keySet()){
//      composition[i] = string.toString();
//      //String ticker = string.toString(); // ticker
//      composition[i+1] = this.portfolios.get(portfolioName).get(string).get(0); // price
//      composition[i+2] = this.portfolios.get(portfolioName).get(string).get(1); //quantity
//      composition[i+3] = this.portfolios.get(portfolioName).get(string).get(2); //currentValue
//    i++;
//    }
//    return composition;
//  }

  @Override
  public double getPortfolioByDate(String portfolioName, String date) {
    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    double totalValueByDate = 0;
    for (String string: this.portfolios.get(portfolioName).keySet()) {
      map.put(string, new ArrayList<>());
      map.get(string).add(portfolios.get(portfolioName).get(string).get(1));
    }
    double finalValue = callStockAPIByDateHelper(map, date);
    return finalValue;
  }

  @Override
  public void quit(){

  }
}
