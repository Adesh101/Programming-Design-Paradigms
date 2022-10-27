package Model.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User implements IUser{
    private Scanner in = new Scanner(System.in);
    private String accountId;
    private String firstname;
    private String lastname;
    private float initialBalance;

  @Override
  public void setAccountId(String accountId) {
    try{
      if(accountId.length() > 5)
        throw new IllegalArgumentException("Please enter a valid 5-digit account number.");
      this.accountId = accountId;
    } catch (IllegalArgumentException e) {
      System.out.println("Please enter a valid 5-digit account number.");
      setAccountId(in.next());
    }
  }

  @Override
  public String getAccountId() {
    return accountId;
  }

  @Override
  public void setInitialBalance(String initialBalance) {
    float checkInput = -1;
    try{
      checkInput = Float.parseFloat(initialBalance);
      this.initialBalance = checkInput;
    } catch (NumberFormatException e) {
      System.out.println("Please enter a valid number!");
      setInitialBalance(in.next());
    }
  }

  @Override
  public float getInitialBalance() {
    return initialBalance;
  }

  @Override
  public String getFirstname() {
    return firstname;
  }

  @Override
  public void setFirstname(String firstname) throws IllegalArgumentException {
    try{
      boolean allLetters = firstname.chars().allMatch(Character::isLetter);
      if (!allLetters)
        throw new IllegalArgumentException();
      this.firstname = firstname;
    } catch (IllegalArgumentException e){
      System.out.println("Please enter a valid first name!");
      setFirstname(in.next());
    }
  }

  @Override
  public String getLastname() {
    return lastname;
  }

  @Override
  public void setLastname(String lastname) {
    try{
      boolean allLetters = lastname.chars().allMatch(Character::isLetter);
      if (!allLetters)
        throw new IllegalArgumentException();
      this.lastname = lastname;
    } catch (IllegalArgumentException e) {
      System.out.println("Please enter a valid last name!");
      setLastname(in.next());
    }
  }


}
