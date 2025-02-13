package commande;

import model.Game;
import model.validator.Validator;

/**
 * This class represents a command that tests a validator during a round when executed
 * and untests the validator when unexecuted.
 */
public class TestValidatorCommand implements Command {

  /**
   * The validator to be tested or untested.
   */
  private Validator validator;

  /**
   * The game containing the round to which the validator is applied.
   */
  private Game game;

  /**
   * Constructor for the TestValidatorCommand class.
   *
   * @param validator The validator to be tested or untested.
   * @param game      The game containing the round to which the validator is applied.
   */
  public TestValidatorCommand(Validator validator, Game game) {
    this.validator = validator;
    this.game = game;
  }

  /**
   * Executes the command by testing the specified validator during the current round.
   */
  @Override
  public void execute() {
    game.getRound().testValidator(this.validator);
  }

  /**
   * Unexecutes the command by untesting the specified validator during the current round.
   */
  @Override
  public void unexecute() {
    game.getRound().unTestValidator(this.validator);
  }
}

