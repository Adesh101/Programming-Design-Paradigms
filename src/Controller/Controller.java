package Controller;

import Model.User.IUser;
import View.IView;
import java.io.InputStream;
import java.util.Scanner;

public class Controller implements IController {

  private Scanner in;
  private IUser user;
  private IView view;


  public Controller(IUser user, IView view, InputStream in){
    this.user = user;
    this.view = view;
    this.in = new Scanner(in);
  }


  @Override
  public void go() {

  }
}
