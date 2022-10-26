package Controller;

import Model.User.IUser;
import View.IUserView;
import java.io.InputStream;
import java.util.Scanner;


public class UserController implements IUserController {
  private Scanner in;
  private IUser user;
  private IUserView view;

  public UserController(IUser user, IUserView view, InputStream in){
    this.user = user;
    this.view = view;
    this.in = new Scanner(in);
  }

  @Override
  public void go() {
    boolean flag = false;
    while(!flag){
      view.showWelcomeMessage();
      view.showFirstName();
      user.setFirstname(in.next());
      view.showLastName();
      user.setLastname(in.next());
      view.showAccountID();
      user.setAccountId(in.next());
      view.showInitialBalance();
      user.setInitialBalance(in.nextFloat());
      flag = true;
    }
  }
}
