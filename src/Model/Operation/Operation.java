package Model.Operation;

import Model.Portfolio.IPortfolio;
import Model.Stocks.IStocks;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Operation implements IOperation {
  protected HashMap<String, HashMap<String, List<String>>> portfolios = new HashMap<String, HashMap<String, List<String>>>();
  protected String portfolioName;
  protected double totalValue;
  protected IStocks stocks;
  protected IPortfolio portfolio;
  private static final String CSV_SEPARATOR = ",";


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
        int existingNoOfStocks = Integer.parseInt(portfolios.get(portfolioName).get(ticker).get(0));
        portfolios.get(portfolioName).get(ticker).set(0, String.valueOf(existingNoOfStocks+quantity));
        double existingPrice = Double.parseDouble(portfolios.get(portfolioName).get(ticker).get(1));
        portfolios.get(portfolioName).get(ticker).set(1, String.valueOf((existingPrice+price)/2));
        double existingTotalStockValue = Double.parseDouble(portfolios.get(portfolioName).get(ticker).get(2));
        portfolios.get(portfolioName).get(ticker).set(2, String.valueOf(existingTotalStockValue + (quantity*price)));
        this.totalValue = totalValue + (quantity*price);
      } else {
        portfolios.get(portfolioName).put(ticker, new ArrayList<String>());
        portfolios.get(portfolioName).get(ticker).add(String.valueOf(quantity));
        portfolios.get(portfolioName).get(ticker).add(String.valueOf(price));
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
    String[] names = new String[portfolios.size()];
    int i =0;
    for ( String key : portfolios.keySet() ) {
      names[i]=key;
      i++;
    }
    return names;
  }
  @Override
  public String getExistingPortfoliosHelper(){
    String s="";
    String[] names = new String[this.getExistingPortfolios().length];
    for(int i=0;i<names.length;i++) {
      s = this.getExistingPortfolios()[i]+ "\n"+s;
    }
    return s;
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
  public void writeToCSV(HashMap<String, HashMap<String, List<String>>> portfolios) {
    try
    {
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("stonks.csv"), "UTF-8"));
      for (String portfolioName : portfolios.keySet())
      {
        StringBuffer oneLine = new StringBuffer();
        oneLine.append("Portfolio Name");
        oneLine.append(CSV_SEPARATOR);
        oneLine.append(portfolioName);
        oneLine.append("\n");
        oneLine.append("Stock");
        oneLine.append(CSV_SEPARATOR);
        oneLine.append("Quantity");
        oneLine.append(CSV_SEPARATOR);
        oneLine.append("Price");
        oneLine.append(CSV_SEPARATOR);
        oneLine.append("Total");
        oneLine.append(CSV_SEPARATOR);
        oneLine.append("\n");
        for (String stockData : portfolios.get(portfolioName).keySet()) {
          oneLine.append(stockData);
          oneLine.append(CSV_SEPARATOR);
          for (String metaStockData : portfolios.get(portfolioName).get(stockData)) {
            oneLine.append(metaStockData);
            oneLine.append(CSV_SEPARATOR);
          }
        }
        bw.write(oneLine.toString());
        bw.newLine();
      }
      bw.flush();
      bw.close();
    } catch (IOException e) {
      System.out.println("ABC");
    }
  }

  @Override
  public List<String> getStockNamesFromPortfolio() {
    List<String> list = new ArrayList<String>();
    for (String portfolioName: this.portfolios.keySet()) {
      for(String stockName: this.portfolios.get(portfolioName).keySet()) {
        list.add(stockName.toString());
      }
    }
    return list;
  }

  @Override
  public HashMap<String, HashMap<String, List<String>>> getPortfolio() {
    return this.portfolios;
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

//  @Override
//  public void quit(){
//
//  }
}
