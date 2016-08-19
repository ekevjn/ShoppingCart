/**
 * 
 */
package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Beans.LoginBean;
import Common.ApplicationConstant;

/**
 * @author megapunk
 *
 */
public class AuthenServiceImpl implements AuthenService {

	@Override
	public LoginBean doLogin(String u, String p) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		LoginBean loginBean = new LoginBean();
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/home/megapunk/main");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			String query = "select * from account where username=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, u);
			preparedStatement.setString(2, p);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				loginBean.setUserName(rs.getString("username"));
				loginBean.setFullname(rs.getString("fullname"));
				loginBean.setRollnumber(rs.getString("rollnumber"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		return loginBean;
	}

	public boolean doRegister(String u, String p, String f, String r) throws ClassNotFoundException {

		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/home/megapunk/main");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			String query = "select * from account where username=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, u);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				return false;
			} else {
				query = "insert into account values(?,?,?,?,?)";
				PreparedStatement pStatement = connection.prepareStatement(query);
				pStatement.setString(1, u);
				pStatement.setString(2, p);
				pStatement.setBoolean(3, false);
				pStatement.setString(4, f);
				pStatement.setString(5, r);
				pStatement.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		return false;
	}

}
