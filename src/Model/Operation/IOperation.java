package Model.Operation;

import java.util.HashMap;
import java.util.List;

/**
 * This is an interface for the operations to be performed.
 */
public interface IOperation {

  /**
   * This method adds a new portfolio name to the hashmap
   *
   * @param portfolioName name of the new portfolio
   */
  void createNewPortfolio(String portfolioName);

  /**
   * This method adds a stock to the existing portfolio.
   * @param portfolioName name of the portfolio in which stock is to be added
   * @param ticker symbol of the stock to be added
   * @param quantity quantity of the stock to be added
   * @param price price of the stock to be added
   */
  void addStockToPortfolio(String portfolioName, String ticker, int quantity, double price);

  /**
   * This method checks whether the portfolio entered already exists.
   * @param name name of the portfolio which is to be checked
   * @return returns true if portfolio is present already else returns false
   */
  boolean getPortfolio(String name);

  /**
   * This method returns all the existing portfolios.
   *
   * @return returns string array containing names of all the portfolios
   */
  String getExistingPortfolios();

  /**
   * This method returns the entire composition of the portfolio.
   * @param name name of the portfolio
   * @return returns string array containing the information of stock held in the portfolio
   */
  String[][] getStocksMap(String name);

  /**
   * This method returns the number of stocks stored in a portfolio.
   * @param portfolioName name of the portfolio
   * @return returns the count as integer
   */
  int getMapSize(String portfolioName);

  /**
   * This method returns the current price of the stock
   * @param ticker symbol of the stock whose price needs to be fetched
   * @return returns the price in double
   */
  double getCurrentPrice(String ticker);

  /**
   * This method check whether a portfolio already exists.
   * @param name name of the portfolio to be checked
   * @return returns true if the portfolio already exists else returns false
   */
  boolean checkPortfolioAlreadyExists(String name);

  /**
   * This method checks whether the ticker is valid.
   * @param ticker stock of the symbol
   * @return returns true if ticker is valid else returns false
   */
  boolean isTickerValid(String ticker);

  /**
   *
   * @param quantity
   * @return
   */
  boolean isQuantityValid(String quantity);
  void writeToCSV(HashMap<String, HashMap<String, List<String>>> portfolios);
  String readFromFile(String fileName);

  List<String> getStockNamesFromPortfolio();

  HashMap<String, HashMap<String, List<String>>> getPortfolio();

  void callStockAPIHelper(String ticker);
  double callStockAPIByDateHelper(HashMap<String, List<String>> map, String date);

  void getAmountByDate(String Date);
  void getCurrentPriceByDate(String ticker, String date);
  //void getStocksInPortfolios();
  String getPortfolioComposition(String portfolioName);
  //void getCurrentAmountOfPortfolio();
  double getPortfolioByDate(String portfolioName, String date);
  String getExistingPortfoliosHelper();
  //void getTransactionHistory();
  //void quit();
}
