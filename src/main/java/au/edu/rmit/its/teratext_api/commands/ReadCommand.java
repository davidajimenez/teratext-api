package au.edu.rmit.its.teratext_api.commands;

import java.util.List;

import com.teratext.dbs.record.Record;

import au.edu.rmit.its.teratext_api.db.Search;

public class ReadCommand extends Command {

	@Override
	public void execute(String... args) {
		System.out.println("In Read Command:" + args[0]);
		
		List<Record> myRecords = Search.presentRecords(args[0]);
        
     // Print out all the retrieved records.
        Search.printPresentRecords(myRecords, true);
	}

}
