package Model.Operation;

import static org.junit.Assert.*;

import Controller.actions.addStockToPortfolioHelper;
import Model.Portfolio.IPortfolio;
import Model.Stocks.IStocks;
import Model.Stocks.Stocks;
import View.IView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class IOperationTest {

  private IStocks stocks;
  private IPortfolio portfolio;
  private IView view;
  private IOperation operation;

  @Before
  public void setUp() {
    this.stocks = new Stocks();
  }

  @Test
  public void checkSaveFileToCSV() throws IOException {
    this.stocks = new Stocks();
    this.operation = new Operation(this.stocks, portfolio);
    HashMap<String, HashMap<String, List<String>>> portfolios = new HashMap<>();
    portfolios.put("College Savings", new HashMap<String, List<String>>());
    portfolios.get("College Savings").put("GOOG", new ArrayList<String>());
    portfolios.get("College Savings").get("GOOG").add(0, "10");
    this.operation.isTickerValid("GOOG");
    portfolios.get("College Savings").get("GOOG").add(1, String.valueOf(this.operation.getCurrentPrice("GOOG")));
    portfolios.get("College Savings").put("META", new ArrayList<String>());
    portfolios.get("College Savings").get("META").add(0, "10");
    operation.isTickerValid("META");
    portfolios.get("College Savings").get("META").add(1, String.valueOf(this.operation.getCurrentPrice("META")));
    operation.writeToCSV(portfolios);

    BufferedReader br = new BufferedReader(new FileReader("stonks.csv"));
    String line = "";
    StringBuilder finalResult = new StringBuilder();
    while ((line = br.readLine()) != null)   //returns a Boolean value
    {
      finalResult.append(line);
    }
    assertEquals(finalResult.toString(), "Portfolio Name,College SavingsStock,Quantity,Price,Total,GOOG,10,87.07,META,10,90.54,");
  }


//  @Before
//  public void setUp() {
//
//    operation
//    operation.createNewPortfolio("College Savings");
//    operation.createNewPortfolio("Job Funds");
//    operation.createNewPortfolio("Family Savings");
//    operation.createNewPortfolio("Retirement Savings");
//
//  }
//  @Test
//  public void testNullPortfolio(){}
//  @Test
//  public void testEmptyPortfolioName(){
//    operation.createNewPortfolio("");
//
//  }
//  @Test
//  public void testExistingPortfolio(){
//    operation.createNewPortfolio("Job Funds");
//    operation.createNewPortfolio("Job Funds");
//  }
  @Test
  public void testPortfolioCreation(){
    operation.createNewPortfolio("College Savings");
    operation.createNewPortfolio("Retirement Funds");
    operation.createNewPortfolio("abc");
    assertEquals("College Savings\nRetirement Funds\nabc\n",operation.getExistingPortfoliosHelper());
  }

//  @Test
//  public void testPortfolioComposition(){
//    operation.createNewPortfolio("College Savings");
//    operation.addStockToPortfolio("College Savings","GOOG",5,20.00);
//    assertEquals("1",view.showStockPortfolio(operation.getStocksMap("College Savings")).);
//  }



}


