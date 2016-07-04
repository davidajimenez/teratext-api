package au.edu.rmit.its.teratext_api.commands;

/**
 * Command to count records in Teratext database.
 * @author e67997
 *
 */
public class CountCommand extends Command {

	@Override
	public void execute(String... args) {
		System.out.println("In Count command:" + args[0]);

	}

}
