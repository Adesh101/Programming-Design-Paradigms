package model.operation;

import java.util.HashMap;
import java.util.List;

/**
 * This is an interface for the operations to be performed.
 */
public interface IOperation {

  /**
   * This method adds a new portfolio name to the hashmap.
   * @param: portfolioName name of the new portfolio
   */
  void createNewPortfolio(String portfolioName);

  /**
   * This method adds a stock to the existing portfolio.
   * @param: portfolioName name of the portfolio in which stock is to be added
   * @param: ticker symbol of the stock to be added
   * @param: quantity of the stock to be added
   * @param: price of the stock to be added
   */
  void addStockToPortfolio(String portfolioName, String ticker, int quantity, double price);


  /**
   * This method returns all the existing portfolios.
   * @return: portfolios
   */
  String getExistingPortfolios();

  /**
   * This method returns the number of stocks stored in a portfolio.
   * @return: returns the count as integer
   * @param: portfolioName name of the portfolio
   */
  int getMapSize(String portfolioName);

  /**
   * This method returns the current price of the stock.
   * @return: returns the price in double
   * @param: ticker symbol of the stock whose price needs to be fetched
   */
  double getCurrentPrice(String ticker);

  /**
   * This method check whether a portfolio already exists.
   * @return: returns true if the portfolio already exists else returns false
   * @param: name of the portfolio to be checked
   */
  boolean checkPortfolioAlreadyExists(String name);

  /**
   * This method checks whether the ticker is valid.
   * @return: returns true if ticker is valid else returns false
   * @param: ticker stock of the symbol
   */
  boolean isTickerValid(String ticker);

  /**
   * This method will write the portfolio data to a csv file.
   * @param: portfolios (hashmap)
   */
  void writeToCSV(HashMap<String, HashMap<String, List<String>>> portfolios);

  /**
   * This method will read input from a particular file.
   * @param: fileName
   * @return: parsed string input
   */
  String readFromFile(String fileName);

  /**
   * Returns a list of portfolio names.
   * @return: arraylist of portfolios
   */
  List<String> getStockNamesFromPortfolio();

  /**
   * Fetches data of a particular portfolio.
   * @return: portfolio data
   */
  HashMap<String, HashMap<String, List<String>>> getPortfolioMap();

  /**
   * This method fetches a particular portfolio value on a given date.
   * @param: map
   * @param: date
   * @return: value of portfolio
   */
  double callStockAPIByDateHelper(HashMap<String, List<String>> map, String date);

  /**
   * Fetches the data of a particular portfolio.
   * @param: portfolioName
   * @return: string parsed data
   */
  String getPortfolioComposition(String portfolioName);

  /**
   * Fetches portfolio data on a particular date.
   * @param: portfolioName
   * @param: date
   * @return: total value of portfolio
   */
  double getPortfolioByDate(String portfolioName, String date);
}
