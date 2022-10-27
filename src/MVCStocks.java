import Model.User.IUser;
import Model.User.User;
import View.IView;
import View.View;


public class MVCStocks {

  public static void main(String[] args) {
    IUser user = new User();
    IView view = new View(System.out);
    IUserController controller = new UserController(user, view, System.in);
    controller.go();
  }
}
