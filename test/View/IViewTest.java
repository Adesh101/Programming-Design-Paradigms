package View;

import static org.junit.Assert.*;

import Controller.Controller;
import Model.Operation.IOperation;
import Model.Operation.MockModel;
import java.io.PrintStream;
import java.io.StringReader;
import org.junit.Before;
import org.junit.Test;

public class IViewTest {
  private IOperation model;
  private Controller controller;
  private IView view;
  private Readable in=new StringReader("");
  private Appendable out;
  private PrintStream out2=new PrintStream(System.out);


  @Before
  public void setUp() {
    out = new StringBuilder();
  }

  @Test
  public void checkMenuOption() {
//    try {
      view = new View(in,out);
      view.showMenu();
      String expectedString = "1. Create new portfolio\n"
          + "2. Add stocks to newly created portfolio\n"
          + "3. View all portfolio names\n"
          + "4. View amount by date\n"
          + "5. View Composition of Portfolio\n"
          + "6. Quit\n"
          + "Enter valid choice\n";
      assertEquals(expectedString, out.toString());
    //}
  }
}