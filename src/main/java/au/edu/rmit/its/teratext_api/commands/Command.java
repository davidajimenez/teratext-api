package au.edu.rmit.its.teratext_api.commands;

/**
 * Abstract Command for Teratext API.
 * @author e67997
 *
 */
public abstract class Command {
	abstract public void execute(String... args);
}
