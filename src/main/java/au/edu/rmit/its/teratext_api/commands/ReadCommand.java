package au.edu.rmit.its.teratext_api.commands;

import com.teratext.dbs.retrieve.CclQuery;
import com.teratext.dbs.retrieve.PresentRequest;
import com.teratext.dbs.retrieve.PresentResponse;
import com.teratext.dbs.record.Record;
import com.teratext.dbs.retrieve.SearchRequest;
import com.teratext.dbs.retrieve.SearchResponse;

import au.edu.rmit.its.teratext_api.db.TTConnection;
import au.edu.rmit.its.utils.Messages;
import au.edu.rmit.its.utils.PrintUtils;

public class ReadCommand extends Command {

	@Override
	public void execute(String... args) {
		System.out.println("In Read Command:" + args[0]);
		
        SearchRequest searchReq = new SearchRequest();
        searchReq.setDatabase(Messages.getString("ddm.database.string.name"));
        searchReq.setResultSet("1");
        searchReq.setQuery(new CclQuery(CclQuery.termSafe(args[0])));
        
        SearchResponse searchResp = TTConnection.getInstance().getConnection().execute(searchReq);
        System.out.println("NumFound : " + searchResp.getResultCount());
        
        // Present at most ten matching records.
        long presentNumber = searchResp.getResultCount();
        if (presentNumber > 10)
        {
            presentNumber = 10;
        }
        
        PresentRequest presentReq = new PresentRequest();
        presentReq.setResultSet("1");
        presentReq.setElementSet("F");
        presentReq.setPosition(1);
        presentReq.setRecordCount(presentNumber);
        
        PresentResponse presentResp = TTConnection.getInstance().getConnection().execute(presentReq);
        
     // Print out all the retrieved records.
        for (Record rec : presentResp.getRecords())
        {
            PrintUtils.printRecord(rec, rec.getName(), 0);
        }
	}

}
