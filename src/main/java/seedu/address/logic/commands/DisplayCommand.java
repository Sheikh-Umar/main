//@@author Sheikh-Umar
package seedu.address.logic.commands;

import seedu.address.model.person.NameContainsKeywordsPredicate;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class DisplayCommand extends Command {

    public static final String COMMAND_WORD = "display";
    public static final String COMMAND_ALIAS = "disp";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Displays List list or Contacts list.\n"
            + "Parameters: [KEYWORD]\n"
            + "Example: " + COMMAND_WORD + " Lead";

    private final NameContainsKeywordsPredicate predicate;

    public DisplayCommand(NameContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute() {
        model.updateFilteredPersonList(predicate);
        return new CommandResult(getMessageForPersonListShownSummary(model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DisplayCommand // instanceof handles nulls
                && this.predicate.equals(((DisplayCommand) other).predicate)); // state check
    }
}
//@@author
