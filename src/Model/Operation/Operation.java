package Model.Operation;

import Model.Portfolio.IPortfolio;
import Model.Stocks.IStocks;
import Model.Stocks.Stocks;
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
      throw new IllegalArgumentException("Enter correct portfolio name!");
    return true;
  }

  @Override
  public void getExistingPortfolios() {

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
  public void getCurrentPriceByDate(String ticker, String date) {

  }

  @Override
  public void getPortfolioComposition() {

  }

  @Override
  public void getPortfolioByDate(String date) {

  }

  @Override
  public void quit(){

  }
}
