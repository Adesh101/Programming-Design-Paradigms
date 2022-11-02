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
  private Appendable out;
  private PrintStream out2=new PrintStream(System.out);

//  @Before
//  public void setUp(){
//    StringBuilder log = new StringBuilder();
//    model=new MockModel(log);
//    out = new StringBuilder();
//
//  }
  @Test
  public void testone(){
    out = new StringBuilder();
    in=new StringReader("1 1 abc 1 1 bcd 3 6");
    StringBuilder log = new StringBuilder();
    model = new MockModel(log,12345);
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
  public void testInvalidConstructor(){}

  @Test
  public void testCreateMultiplePortfoliosFromConsoleThenDisplay(){
    String expected="Welcome! Enter the number denoting the operation to be performed:\n"
        + "1. Create new portfolio\n"
        + "2. Add stocks to newly created portfolio\n"
        + "3. View all portfolio names\n"
        + "4. View amount by date\n"
        + "5. View Composition of Portfolio\n"
        + "6. Quit\n"
        + "Enter valid choice\n"
        + "1. Create new portfolio through console\n"
        + "2. Create new portfolio through file\n"
        + "Enter a name for the new portfolio\n"
        + "Portfolio abc created succesfully.\n"
        + "1. Create new portfolio\n"
        + "2. Add stocks to newly created portfolio\n"
        + "3. View all portfolio names\n"
        + "4. View amount by date\n"
        + "5. View Composition of Portfolio\n"
        + "6. Quit\n"
        + "Enter valid choice\n"
        + "1. Create new portfolio through console\n"
        + "2. Create new portfolio through file\n"
        + "Enter a name for the new portfolio\n"
        + "Portfolio bcd created succesfully.\n"
        + "1. Create new portfolio\n"
        + "2. Add stocks to newly created portfolio\n"
        + "3. View all portfolio names\n"
        + "4. View amount by date\n"
        + "5. View Composition of Portfolio\n"
        + "6. Quit\n"
        + "Enter valid choice\n"
        + "No portfolios Found\n"
        + "\n"
        + "1. Create new portfolio\n"
        + "2. Add stocks to newly created portfolio\n"
        + "3. View all portfolio names\n"
        + "4. View amount by date\n"
        + "5. View Composition of Portfolio\n"
        + "6. Quit\n"
        + "Enter valid choice\n";
    in=new StringReader("1 1 abc 1 1 bcd 3 6");
    view = new View(in,out);
    controller = new Controller(model,view);
    controller.go();
    assertEquals(expected,out.toString());
  }

}