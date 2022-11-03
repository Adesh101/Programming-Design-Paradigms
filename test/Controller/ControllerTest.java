package Controller;

import static org.junit.Assert.*;

import Model.Operation.IOperation;
import Model.Operation.MockModel;
import View.IView;
import View.View;
import java.io.PrintStream;
import java.io.StringReader;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
  private IOperation model;
  private Controller controller;
  private IView view;
  private Readable in;
  private StringBuilder log;
  private Appendable out;

  @Before
  public void setUp(){
    log = new StringBuilder();
    model=new MockModel(log);
    out = new StringBuilder();

  }
  @Test
  public void testCreatePortfolio(){
    in=new StringReader("1 1 abc 6");
    view = new View(in,out);
    controller = new Controller(model,view);
    controller.go();
    assertEquals("Portfolio name: abc"
        + "Portfolio abc Created Succesfully",log.toString());

  }
  @Test
  public void testCreateMultiplePortfolios(){
    in=new StringReader("1 1 abc 1 1 bcd 6");
    view = new View(in,out);
    controller = new Controller(model,view);
    controller.go();
    assertEquals("Portfolio name: abc"
        + "Portfolio abc Created Succesfully"
        + "Portfolio name: bcd"
        + "Portfolio bcd Created Succesfully",log.toString());
  }
  @Test
  public void testCreateMultiplePortfoliosFromConsoleThenDisplay(){

    in=new StringReader("1 1 abc 1 1 bcd 3 6");
    view = new View(in,out);
    controller = new Controller(model,view);
    controller.go();
    assertEquals("Portfolio name: abc"
            + "Portfolio abc Created Succesfully"
            + "Portfolio name: bcd"
            + "Portfolio bcd Created Succesfully"
            + "Portfolio List"
            + "Portfolio List"
        ,log.toString());
   // assertEquals(,out.toString());

  }
  @Test
  public void testShowALlPortfolios(){
    in = new StringReader("3 6");
    view = new View(in,out);
    controller= new Controller(model,view);
    controller.go();
    assertEquals("Portfolio List"
        + "Portfolio List",log.toString());
  }
  // needs work
  @Test
  public void testPortfolioComposition(){
    in = new StringReader("1 1 abc 2 abc GOOG 10 N 5 abc 6");
    view = new View(in,out);
    controller = new Controller(model,view);
    controller.go();
    assertEquals("Portfolio: abc",log.toString());

  }
  @Test
  public void testCreatePortfolioAndMultipleStocks(){
    in = new StringReader("");
  }


}