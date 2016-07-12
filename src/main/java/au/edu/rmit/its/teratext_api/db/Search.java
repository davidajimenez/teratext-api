package au.edu.rmit.its.teratext_api.db;

import java.util.ArrayList;
import java.util.List;

import com.teratext.dbs.record.Record;
import com.teratext.dbs.retrieve.CclQuery;
import com.teratext.dbs.retrieve.PresentRequest;
import com.teratext.dbs.retrieve.PresentResponse;
import com.teratext.dbs.retrieve.SearchRequest;
import com.teratext.dbs.retrieve.SearchResponse;

import au.edu.rmit.its.utils.Messages;
import au.edu.rmit.its.utils.PrintUtils;

public class Search {

	/**
	 * Executes search based on supplied query.
	 * 
	 * @param query
	 * @return
	 */
	public static long count(String query) {
		SearchRequest searchReq = new SearchRequest();
		searchReq.setDatabase(Messages.getString("ddm.database.string.name"));
		searchReq.setResultSet("1");
		searchReq.setQuery(new CclQuery(query));

		TTConnection.getInstance();
		SearchResponse searchResp = TTConnection.getConnection().execute(searchReq);
		System.out.println("NumFound : " + searchResp.getResultCount());

		long presentNumber = searchResp.getResultCount();

		return presentNumber;
	}

	/**
	 * Presents records based on a query
	 * @param query
	 * @return
	 */
	public static List<Record> presentRecords(String query) {

		List<Record> results = new ArrayList<Record>();

		SearchRequest searchReq = new SearchRequest();
		searchReq.setDatabase(Messages.getString("ddm.database.string.name"));
		searchReq.setResultSet("1");
		searchReq.setQuery(new CclQuery(query));

		TTConnection.getInstance();
		SearchResponse searchResp = TTConnection.getConnection().execute(searchReq);
		System.out.println("NumFound : " + searchResp.getResultCount());

		long presentNumber = searchResp.getResultCount();

		if (presentNumber > 0) {

			PresentRequest presentReq = new PresentRequest();
			presentReq.setResultSet("1");
			presentReq.setElementSet("F");
			presentReq.setPosition(1);
			presentReq.setRecordCount(presentNumber);

			TTConnection.getInstance();
			PresentResponse presentResp = TTConnection.getConnection().execute(presentReq);

			for (Record rec : presentResp.getRecords()) {
				results.add(rec);
			}
		}
		return results;
	}

	/**
	 * Prints to the console the list of Records.
	 * @param records
	 */
	public static void printPresentRecords(List<Record> records) {
		for (Record rec : records) {
			PrintUtils.printRecord(rec, rec.getName(), 0);
		}
	}
}
