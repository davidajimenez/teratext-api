package au.edu.rmit.its.teratext_api.commands;

/**
 * Command to update records in Teratext database.
 * @author e67997
 *
 */
public class UpdateCommand extends Command {

	@Override
	public void execute(String... args) {
		System.out.println("In Update command:" + args[0]);

	}

}
