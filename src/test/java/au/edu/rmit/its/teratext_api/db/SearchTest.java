package au.edu.rmit.its.teratext_api.db;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.teratext.dbs.record.Record;

public class SearchTest {
	@Test
	public void testSearchWord(){
		String query = "Hernandez";
		long numberOfResults = Search.count(query);
		assertTrue(numberOfResults == 25);
	}
	
	@Test
	public void testSearch(){
		String query = "SIMID=93y5odr1yhoe1";
		long numberOfResults = Search.count(query);
		assertTrue(numberOfResults == 3);
	}
	
	@Test
	public void testSearchStatusAndType(){
		String query = "Type=StaffProfile and status=A";
		long numberOfResults = Search.count(query);
		assertTrue(numberOfResults > 0);
	}
	
	@Test
	public void testSearchStatusAndTypeAndVisibility(){
		String query = "Type=StaffProfile and status=D and visibility=A";
		long numberOfResults = Search.count(query);
		assertTrue(numberOfResults > 0);
	}
	
	@Test
	public void testPresent(){
		String query = "SIMID=93y5odr1yhoe1";
		List<Record> myRecords = Search.presentRecords(query);
		for(Record myRecord : myRecords) {
			String myRecordStr = myRecord.toString();
			System.out.println(myRecordStr);
		}
		assertTrue(myRecords.size() == 3);
	}
}
