package Controller.actions;

import Model.Operation.IOperation;

/**
 * This is a public interface for the actions to be performed.
 */
public interface IActions {

  /**
   *  This is a method to execute the actions.
   */
  String go(IOperation operation);
}
