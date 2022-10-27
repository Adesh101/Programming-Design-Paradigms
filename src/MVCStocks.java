import Controller.IUserController;
import Controller.UserController;
import Model.User.IUser;
import Model.User.User;
import View.IUserView;
import View.UserView;


public class MVCStocks {

  public static void main(String[] args) {
    IUser user = new User();
    IUserView view = new UserView(System.out);
    IUserController controller = new UserController(user, view, System.in);
    controller.go();
  }
}
