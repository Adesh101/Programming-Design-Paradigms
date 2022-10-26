package Model.User;

public interface IUser {
  void setAccountId(String accountId);

  String getAccountId();

  void setInitialBalance(float initialBalance);

  double getInitialBalance();

  String getFirstname();

  void setFirstname(String firstname);

  String getLastname();

  void setLastname(String lastname);
}
