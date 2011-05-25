import java.sql.*;

public class DataManager {
	private static DataManager mInstance;
	private Connection mConnection;

	public DataManager() {
		// TODO Auto-generated constructor stub
		init();
	}

	/**
	 * Get the instance
	 * 
	 * @return
	 */
	public static DataManager getInstance() {
		if (null == mInstance) {
			mInstance = new DataManager();
		}

		return mInstance;
	}

	private void init() {
		try {
			mConnection = null;
			// Class.forName("org.gjt.mm.mysql.Driver");
			Class.forName("com.mysql.jdbc.Driver");
		}

		catch (ClassNotFoundException cnfex) {
			System.err.println("Load jdbc driver error");
			cnfex.printStackTrace();
			System.exit(1); // terminate program
		}
	}

	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/mysql";
		String username = "root";
		String password = "mysql";

		try {
			mConnection = null;
			mConnection = DriverManager.getConnection(url, username, password);
		} catch (SQLException sqlex) {
			System.err.println("SQLException");
			sqlex.printStackTrace();
			System.exit(1); // terminate program
		}

		return mConnection;
	}

}
