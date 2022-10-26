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
    view.showWelcomeMessage();
    view.showFirstName();
    user.setFirstname(in.next());
    user.setLastname(in.next());
    user.setAccountId(in.next());
    user.setInitialBalcne(in.nextDouble());
  }
}
