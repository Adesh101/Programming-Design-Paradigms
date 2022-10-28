package Model.Portfolio;

public interface IPortfolio {
  void setPortfolioChoice(int choice);
  void createPortfolio();
  void getNewPortfolioName();
  void getTicker();
  void getQuantity();
  String getOrderConfirmation(String choice);


  public void lockPortfolio();

  public void getPortfolio();
}
