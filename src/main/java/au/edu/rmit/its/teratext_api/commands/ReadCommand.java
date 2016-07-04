package au.edu.rmit.its.teratext_api.commands;

public class ReadCommand extends Command {

	@Override
	public void execute(String... args) {
		System.out.println("In Read Command:" + args[0]);

	}

}
