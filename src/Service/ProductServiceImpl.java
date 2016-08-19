package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.BilldetailBean;
import Beans.CartBean;
import Beans.CusbillBean;
import Beans.LoginBean;
import Entities.CartEntity;
import Entities.ProductEntity;

public class ProductServiceImpl implements ProductService {

	@Override
	public List<String> getManList() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/home/megapunk/main");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			String query = "select cname from product group by cname;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			List<String> manList = new ArrayList<String>();
			while (rs.next()) {
				manList.add(rs.getString("cname"));
			}
			if (!manList.isEmpty()) {
				return manList;
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
		return null;
	}

	public List<ProductEntity> getProductList(String c) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/home/megapunk/main");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			String query = "select * from product where cname=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, c);
			ResultSet rs = preparedStatement.executeQuery();
			List<ProductEntity> pList = new ArrayList<ProductEntity>();
			while (rs.next()) {
				ProductEntity productEntity = new ProductEntity(String.valueOf(rs.getInt("id")), rs.getString("pname"),
						String.valueOf(rs.getFloat("price")), rs.getString("cname"), rs.getString("description"));
				pList.add(productEntity);
			}
			if (!pList.isEmpty()) {
				return pList;
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
		return null;
	}

	public ProductEntity getProduct(String pId) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/home/megapunk/main");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			String query = "select * from product where id=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pId);
			ResultSet rs = preparedStatement.executeQuery();
			ProductEntity productEntity = null;
			while (rs.next()) {
				productEntity = new ProductEntity(String.valueOf(rs.getInt("id")), rs.getString("pname"),
						String.valueOf(rs.getFloat("price")), rs.getString("cname"), rs.getString("description"));
			}
			if (productEntity != null) {
				return productEntity;
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
		return null;
	}

	@Override
	public boolean processCheckout(CartBean cartBean, LoginBean loginBean) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/home/megapunk/main");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			String query = "insert into bill values (null,?,?,datetime(),'Wait')";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, loginBean.getFullname());
			preparedStatement.setFloat(2, cartBean.getTotalprice());
			preparedStatement.executeUpdate();
			
			for(CartEntity cartEntity : cartBean.getcList()){
				query = "insert into billdetail select null, id, ?, ? from bill order by id desc limit 1;";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(cartEntity.getpId()));
				preparedStatement.setInt(2, cartEntity.getQuanlity());
				preparedStatement.executeUpdate();
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
		return true;
	}

	@Override
	public List<ProductEntity> getAllProduct() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		List<ProductEntity> productEntities= new ArrayList<ProductEntity>();
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/home/megapunk/main");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			String query = "select * from product;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			ProductEntity productEntity = null;
			while (rs.next()) {
				productEntity = new ProductEntity(String.valueOf(rs.getInt("id")), rs.getString("pname"),
						String.valueOf(rs.getFloat("price")), rs.getString("cname"), rs.getString("description"));
				productEntities.add(productEntity);
			}
			if (productEntities != null) {
				return productEntities;
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
		return null;
	}

	@Override
	public List<LoginBean> getAllCustomer() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		List<LoginBean> loginBeans = new ArrayList<LoginBean>();
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/home/megapunk/main");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			String query = "select * from account where isadmin=0;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				LoginBean loginBean = new LoginBean();
				loginBean.setUserName(rs.getString("username"));
				loginBean.setFullname(rs.getString("fullname"));
				loginBean.setRollnumber(rs.getString("rollnumber"));
				loginBeans.add(loginBean);
			}
			if (loginBeans != null) {
				return loginBeans;
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
		return null;
	}

	@Override
	public List<CusbillBean> getAllCusBill() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		List<CusbillBean> cusbillBeans = new ArrayList<CusbillBean>();
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/home/megapunk/main");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			String query = "select * from bill;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				CusbillBean cusbillBean = new CusbillBean();
				cusbillBean.setId(rs.getString("id"));
				cusbillBean.setCusName(rs.getString("customername"));
				//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				cusbillBean.setCreatedDate(rs.getString("createdate"));
				cusbillBean.setTotalbill(String.valueOf(rs.getString("total")));
				cusbillBean.setStatus(rs.getString("status"));
				
				cusbillBeans.add(cusbillBean);
			}
			if (cusbillBeans != null) {
				return cusbillBeans;
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
		return null;
	}

	@Override
	public List<BilldetailBean> getCusBillDetail(String billId) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		List<BilldetailBean> billdetailBeans = new ArrayList<BilldetailBean>();
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/home/megapunk/main");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			String query = "select b.id, p.pname, b.quanlity, (b.quanlity * p.price) as total from product as p, billdetail as b where b.bid = ? and b.pid = p.id;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(billId));
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				BilldetailBean billdetailBean = new BilldetailBean();
				billdetailBean.setId(rs.getString("id"));
				billdetailBean.setPname(rs.getString("pname"));
				billdetailBean.setQuanlity(rs.getString("quanlity"));
				billdetailBean.setTotal(rs.getString("total"));
				billdetailBean.setBid(billId);
				billdetailBeans.add(billdetailBean);
			}
			if (billdetailBeans != null) {
				return billdetailBeans;
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
		return null;
	}

	@Override
	public boolean changeBillStatus(String billID, String stt) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		List<LoginBean> loginBeans = new ArrayList<LoginBean>();
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/home/megapunk/main");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			String query = "update bill set status=? where id=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(2, Integer.parseInt(billID));
			preparedStatement.setString(1, stt);
			preparedStatement.executeUpdate();
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
		return true;
	}

}
