package Model.User;

public class User implements IUser{
    private String accountId;
    private String firstname;
    private String lastname;
    private double initialBalance;

  @Override
  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  @Override
  public String getAccountId() {
    return accountId;
  }

  @Override
  public void setInitialBalcne(double initialBalance) {
    this.initialBalance = initialBalance;
  }

  @Override
  public double getInitialBalance() {
    return initialBalance;
  }

  @Override
  public String getFirstname() {
    return firstname;
  }

  @Override
  public void setFirstname(String firstname) throws IllegalArgumentException {
    boolean allLetters = firstname.chars().allMatch(Character::isLetter);
    if(allLetters)
      this.firstname = firstname;
    else
      throw new IllegalArgumentException("Please enter a valid name!");
  }

  @Override
  public String getLastname() {
    return lastname;
  }

  @Override
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
}
