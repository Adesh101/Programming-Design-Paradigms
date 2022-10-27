package Controller.actions;

import Model.User.IUser;
import View.View;
import java.io.InputStream;
import java.util.Scanner;


public class UserController implements IActions{
  private Scanner in;
  private IUser user;
  private View view;


  public UserController(IUser user, View view, InputStream in){
    this.user = user;
    this.view = view;
    this.in = new Scanner(in);
  }

  public void go() {
    view.showWelcomeMessage();
    view.showFirstName();
    user.setFirstname(in.next());
    view.showLastName();
    user.setLastname(in.next());
    view.showAccountID();
    user.setAccountId(in.next());
    view.showInitialBalance();
    user.setInitialBalance(in.next());
//    view.showCreationSuccess();
  }
}

