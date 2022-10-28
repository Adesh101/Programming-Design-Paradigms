import Controller.IController;
import Controller.Controller;
import Model.User.IUser;
import Model.User.User;
import View.IView;
import View.View;


public class MVCStocks {

  public static void main(String[] args) {
    IUser user = new User();
    IView view = new View(System.out);
    IController controller = new Controller(user, view, System.in);
    controller.go();
  }
}
