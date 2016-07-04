package au.edu.rmit.its.teratext_api.commands;

import java.util.HashMap;

/**
 * Controller for the commands to be used by the Teratext API App.
 * @author e67997
 *
 */
public class CommandController {
	private HashMap<TTAppCommands, Command> commands;

	public HashMap<TTAppCommands, Command> getCommands() {
		return commands;
	}

	public CommandController(HashMap<TTAppCommands, Command> commands) {
		this.commands = commands;
	}
}
