package View;

import java.io.PrintStream;

public class PortfolioView implements IPortfolioView {

  private PrintStream out;

  @Override
  public void showCreateNew() {
    out.println("To create new portfolio, Enter 1");
  }

  @Override
  public void showExisting() {
    out.println("To manage existing portfolio, Enter 2");
  }
}
