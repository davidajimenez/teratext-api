package au.edu.rmit.its.teratext_api.commands;

/**
 * Command to create records in Teratext database.
 * @author e67997
 *
 */
public class CreateCommand extends Command {

	@Override
	public void execute(String... args) {
		System.out.println("In Create command:" + args[0]);

	}

}
