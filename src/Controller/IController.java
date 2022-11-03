package Controller;

import Model.Operation.IOperation;

/**
 * This is an interface for the Controller.
 */
public interface IController {

  /**
   * This is a method starts the program.
   */
  void go(IOperation operation);
}
