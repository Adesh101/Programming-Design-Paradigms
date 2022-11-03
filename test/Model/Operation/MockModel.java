package Model.Operation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MockModel implements IOperation {
  private StringBuilder log;
  public MockModel(StringBuilder log){
    this.log=log;
  }
  @Override
  public String createNewPortfolio(String portfolioName) {
    log.append("Portfolio "+portfolioName+" Created Succesfully");
    return "Portfolio Created Successfully";
  }

  @Override
  public void addStockToPortfolio(String portfolioName, String ticker, int quantity, double price) {
      log.append("Portfolio Name: " + portfolioName + " Stock :" + ticker + " Quantity: " + quantity + " Price: "+ price);
  }

  @Override
  public boolean getPortfolio(String name) {
    log.append("Portfolio: " +name);
    return false;
  }

  @Override
  public String[] getExistingPortfolios() {
    log.append("Portfolio List");
    return new String[0];
  }

  @Override
  public String[][] getStocksMap(String name) {
    log.append("Portfolio name: "+name);
    return new String[0][];
  }

  @Override
  public int getMapSize(String portfolioName) {
    log.append("Portfolio name: " + portfolioName);
    return 0;
  }

  @Override
  public double getCurrentPrice(String ticker) {
    log.append("Ticker: "+ ticker);
    return 0;
  }

  @Override
  public boolean checkPortfolioAlreadyExists(String name) {
    log.append("Portfolio name: "+name);
    return false;
  }

  @Override
  public boolean isTickerValid(String ticker) {
    log.append("Ticker: "+ticker);
    return false;
  }

  @Override
  public boolean isQuantityValid(String quantity) {
    log.append("Quantity: "+ quantity);
    return false;
  }

  @Override
  public void writeToCSV(HashMap<String, HashMap<String, List<String>>> portfolios) {
    log.append("Hashmap: "+ portfolios);
  }

  @Override
  public List<String> getStockNamesFromPortfolio() {
    return null;
  }

  @Override
  public HashMap<String, HashMap<String, List<String>>> getPortfolio() {
    return null;
  }

  @Override
  public void callStockAPIHelper(String ticker) {
    log.append("Ticker: "+ ticker);
  }

  @Override
  public double callStockAPIByDateHelper(HashMap<String, List<String>> map, String date) {
    log.append("Map: "+ map + "Date: "+date);
    return 0;
  }

  @Override
  public void getAmountByDate(String Date) {
    log.append("Date: "+Date);
  }

  @Override
  public void getCurrentPriceByDate(String ticker, String date) {
    log.append("Ticker: "+ticker+"Date: "+ date);
  }

  @Override
  public double getPortfolioByDate(String portfolioName, String date) {
    log.append("Portfolio Name: "+ portfolioName + " Date: "+date);
    return 0;
  }

  @Override
  public String getExistingPortfoliosHelper() {
    return null;
  }
}
