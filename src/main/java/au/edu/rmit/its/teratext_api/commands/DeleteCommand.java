package au.edu.rmit.its.teratext_api.commands;

/**
 * Command to delete records in Teratext database.
 * @author e67997
 *
 */
public class DeleteCommand extends Command {

	@Override
	public void execute(String... args) {
		System.out.println("In Delete command:" + args[0]);

	}

}
