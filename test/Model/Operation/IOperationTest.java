package Model.Operation;

import static org.junit.Assert.*;

import Model.Portfolio.IPortfolio;
import Model.Stocks.IStocks;
import View.IView;
import org.junit.Before;
import org.junit.Test;

public class IOperationTest {

  private IStocks stocks;
  private IPortfolio portfolio;
  private IView view;
  private IOperation operation= new Operation(stocks, portfolio);


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


