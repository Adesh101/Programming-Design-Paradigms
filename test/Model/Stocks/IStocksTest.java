package Model.Stocks;

import static org.junit.Assert.*;

import org.junit.Test;

public class IStocksTest {

@Test
  public void testGetPriceByDate(){
  IStocks stocks=new Stocks();
//  stocks.callStockAPIByDate("GOOG","2022-03-15");
//  assertEquals(1184.46	,stocks.getStockCurrentPriceByDate("GOOG"),0.0);
  stocks.callStockAPIByDate("META","2022-10-10");
  assertEquals(133.55	,stocks.getStockCurrentPriceByDate("META"),0.0);
  stocks.callStockAPIByDate("META","2022-09-05");
  assertEquals(133.55	,stocks.getStockCurrentPriceByDate("META"),0.0);
  stocks.callStockAPIByDate("META","2022-08-05");
  assertEquals(133.55	,stocks.getStockCurrentPriceByDate("META"),0.0);
  stocks.callStockAPIByDate("AAPL","2022-07-05");
  assertEquals(133.55	,stocks.getStockCurrentPriceByDate("META"),0.0);
  stocks.callStockAPIByDate("AAPL","2022-06-05");
  assertEquals(133.55	,stocks.getStockCurrentPriceByDate("META"),0.0);
  stocks.callStockAPIByDate("AAPL","2022-05-05");
  assertEquals(133.55	,stocks.getStockCurrentPriceByDate("META"),0.0);
}
}