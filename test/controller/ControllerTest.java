package controller;

import static org.junit.Assert.assertEquals;

import model.operation.IOperation;
import model.operation.MockModel;
import view.IView;
import view.View;
import java.io.StringReader;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test Controller.
 */
public class ControllerTest {

  private IOperation model;
  private Controller controller;
  private IView view;
  private Readable in;
  private StringBuilder log;
  private Appendable out;

  @Before
  public void setUp() {
    log = new StringBuilder();
    model = new MockModel(log);
    out = new StringBuilder();

  }

  @Test
  public void testCreatePortfolio() {
    in = new StringReader("1 1 abc 6");
    view = new View(in, out);
    controller = new Controller(model, view);
    controller.operate(model);
    assertEquals("Portfolio name: abc"
        + "Portfolio abc Created Succesfully", log.toString());

  }

  @Test
  public void testCreateMultiplePortfolios() {
    in = new StringReader("1 1 abc 1 1 bcd 6");
    view = new View(in, out);
    controller = new Controller(model, view);
    //controller.go();
    assertEquals("Portfolio name: abc"
        + "Portfolio abc Created Succesfully"
        + "Portfolio name: bcd"
        + "Portfolio bcd Created Succesfully", log.toString());
  }

  @Test
  public void testCreateMultiplePortfoliosFromConsoleThenDisplay() {

    in = new StringReader("1 1 abc 1 1 bcd 3 6");
    view = new View(in, out);
    controller = new Controller(model, view);
    //controller.go();
    assertEquals("Portfolio name: abc"
            + "Portfolio abc Created Succesfully"
            + "Portfolio name: bcd"
            + "Portfolio bcd Created Succesfully"
            + "Portfolio List"
            + "Portfolio List", log.toString());
    // assertEquals(,out.toString());

  }

  @Test
  public void testShowALlPortfolios() {
    in = new StringReader("3 6");
    view = new View(in, out);
    controller = new Controller(model, view);
    //controller.go();
    assertEquals("Portfolio List"
        + "Portfolio List", log.toString());
  }

  // needs work
  @Test
  public void testPortfolioComposition() {
    model = new MockModel(log);
    in = new StringReader("1 1 abc 6");
    view = new View(in, out);
    controller = new Controller(model, view);
    controller.operate(model);
    assertEquals("PORTFOLIO abc CREATED SUCCESSFULLY.", log.toString());
  }

  @Test
  public void testAddStocks() {
    model = new MockModel(log);
    in = new StringReader("1 2 ascsa 2 ascsa GOOG 10 N 6");
    view = new View(in, out);
    controller = new Controller(model, view);
    controller.operate(model);
    assertEquals("PORTFOLIO abc CREATED SUCCESSFULLY. \n"
            + "PORTFOLIO: abcTICKER: GOOGTICKER: GOOGPORTFOLIO NAME:"
            + " abc STOCK: GOOG QUANTITY: 10 PRICE: 0.0\n"
            + "PORTFOLIO: abcTICKER: METATICKER: METAPORTFOLIO NAME:"
            + " abc STOCK: META QUANTITY: 100 PRICE: 0.0\n"
            + "PORTFOLIO: abcTICKER: AAPLTICKER: AAPLPORTFOLIO NAME:"
            + " abc STOCK: AAPL QUANTITY: 17 PRICE: 0.0\n",
        log.toString());
  }

}