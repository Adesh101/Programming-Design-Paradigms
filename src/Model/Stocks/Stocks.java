package Model.Stocks;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Stocks implements IStocks{

  @Override
  public String[] callStockAPI(String ticker) {
    String apiKey = "W0M1JOKC82EZEQA8";
    URL url = null;

    try {
      url = new URL("https://www.alphavantage"
          + ".co/query?function=GLOBAL_QUOTE"
          + "&outputsize=1"
          + "&symbol"
          + "=" + ticker + "&apikey="+apiKey+"&datatype=csv");
    }
    catch (MalformedURLException e) {
      throw new RuntimeException("the alphavantage API has either changed or "
          + "no longer works");
    }

    InputStream in = null;
    StringBuilder output = new StringBuilder();

    try {
      in = url.openStream();
      int b;

      while ((b=in.read())!=-1) {
        output.append((char)b);
      }
    }
    catch (IOException e) {
      throw new IllegalArgumentException("No price data found for "+ticker);
    }

    String[] introduction = output.toString().split(",");
    //return Double.parseDouble(introduction[13]);
    return introduction;
  }

  @Override
  public double getStockCurrentPrice(String ticker) {
    return 0;
  }

  @Override
  public String getCurrentDate(String date) {
    return null;
  }

}
