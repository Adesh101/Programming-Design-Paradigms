package Controller;

import Model.Operation.IOperation;
import Model.Operation.Operation;

/**
 * This is an interface for the Controller.
 */
public interface IController {

  /**
   *  This is a method starts the program.
   */
  void go(IOperation operation);
}
