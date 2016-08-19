/**
 * 
 */
package Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.BilldetailBean;
import Beans.CartBean;
import Beans.CusbillBean;
import Beans.LoginBean;
import Entities.ProductEntity;

/**
 * @author megapunk
 *
 */
public interface ProductService {
	List<String>  getManList() throws ClassNotFoundException, SQLException;
	List<ProductEntity> getProductList(String cname) throws ClassNotFoundException, SQLException;
	List<ProductEntity> getAllProduct() throws ClassNotFoundException, SQLException;
	List<LoginBean> getAllCustomer() throws ClassNotFoundException, SQLException;
	ProductEntity getProduct(String pId) throws ClassNotFoundException, SQLException;
	boolean processCheckout(CartBean cartBean, LoginBean loginBean) throws ClassNotFoundException, SQLException;
	List<CusbillBean> getAllCusBill() throws ClassNotFoundException, SQLException;
	List<BilldetailBean> getCusBillDetail(String billId) throws ClassNotFoundException, SQLException;
	boolean changeBillStatus(String billID, String stt) throws ClassNotFoundException, SQLException;
}
