package au.edu.rmit.its.teratext_api;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import au.edu.rmit.its.teratext_api.commands.Command;
import au.edu.rmit.its.teratext_api.commands.CommandController;
import au.edu.rmit.its.teratext_api.commands.CountCommand;
import au.edu.rmit.its.teratext_api.commands.CreateCommand;
import au.edu.rmit.its.teratext_api.commands.DeleteCommand;
import au.edu.rmit.its.teratext_api.commands.ReadCommand;
import au.edu.rmit.its.teratext_api.commands.TTAppCommands;
import au.edu.rmit.its.teratext_api.commands.UpdateCommand;
import au.edu.rmit.its.utils.Messages;

/**
 * Teratext API application.
 *
 */
public class TTApp {

	private final static Logger logger = Logger.getLogger(TTApp.class);
	private static CommandController controller;
	
	/**
	 * Initializes the command controller
	 */
	private static void init(){
		HashMap<TTAppCommands,Command> commands = new HashMap<TTAppCommands,Command>();
		commands.put(TTAppCommands.CREATE, new CreateCommand());
		commands.put(TTAppCommands.READ, new ReadCommand());
		commands.put(TTAppCommands.UPDATE, new UpdateCommand());
		commands.put(TTAppCommands.DELETE, new DeleteCommand());
		commands.put(TTAppCommands.COUNT, new CountCommand());
		
		controller = new CommandController(commands);
	}

	/**
	 * Desktop app to interact with a Teratext application.
	 * @param args
	 */
	public static void main(String[] args) {
		init();
		Scanner scanner = new Scanner(System.in);
		try {
			String blufile = "";
			System.out.print(Messages.getString("prompt.initial.message"));
			try {
				int itemCode = scanner.nextInt();
				switch (itemCode) {
				case 1:
					scanner.nextLine();
					System.out.println(Messages.getString("prompt.create.choice.message"));
					String query = scanner.nextLine();
					controller.getCommands().get(TTAppCommands.CREATE).execute(query);
					logger.info(Messages.getString("log.message.create.file.message", query, blufile));
					break;
				case 2:
					scanner.nextLine();
					System.out.println(Messages.getString("prompt.read.choice.message"));
					query = scanner.nextLine();
					controller.getCommands().get(TTAppCommands.READ).execute(query);
					logger.info(Messages.getString("log.message.read.message", query));
					break;
				case 6:
					System.out.println(Messages.getString("prompt.bye.choice.message"));
					break;
				default:
					System.out.println(Messages.getString("prompt.error.wrong.choice"));
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println(Messages.getString("prompt.error.wrong.choice"));
			}
		} catch (Exception e) {
			logger.error(Messages.getString("message.exception.general"));
			e.printStackTrace(System.err);
		} finally {
			scanner.close();
		}
	}
}
