package Service;

import java.io.IOException;

import Beans.LoginBean;

public interface AuthenService {
	LoginBean doLogin(String u, String p) throws ClassNotFoundException; 
	boolean doRegister(String u, String p, String f, String r) throws ClassNotFoundException;
}
