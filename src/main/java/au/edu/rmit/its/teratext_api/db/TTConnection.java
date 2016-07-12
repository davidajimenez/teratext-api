package au.edu.rmit.its.teratext_api.db;

import org.apache.log4j.Logger;

import com.teratext.dbs.connection.Connection;
import com.teratext.dbs.connection.UninitializedConnection;
import com.teratext.dbs.exception.TtConnectionFailedException;
import com.teratext.dbs.exception.TtUnauthorizedException;

import au.edu.rmit.its.utils.Messages;

/**
 * Connection to Teratext database.
 * Uses singleton design pattern.
 * @author e67997
 *
 */
public class TTConnection {
	
	private static Connection c;
	private final static Logger logger = Logger.getLogger(TTConnection.class);
	
	private TTConnection(){
		try {
			// Connect to the server.
			UninitializedConnection uc = new UninitializedConnection();
			uc.setHost(Messages.getString("ddm.database.server"));
			uc.setPort(Integer.valueOf(Messages.getString("ddm.database.port")));
			uc.setAuthType(UninitializedConnection.AuthenticationType.ID);
			uc.setAuthIdUsername(Messages.getString("ddm.database.username"));
			uc.setAuthIdPassword(Messages.getString("ddm.database.password"));
			c = uc.getConnection();
		} catch (TtUnauthorizedException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (TtConnectionFailedException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static TTConnection instance = null;
	
	public static Connection getConnection(){
		return c;
	}
	
	public static TTConnection getInstance() {
		if (instance == null) {
			instance = new TTConnection();
		}
		return instance;
	}

}
