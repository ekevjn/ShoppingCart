/**
 * 
 */
package Beans;

import java.util.List;

/**
 * @author megapunk
 *
 */
public class ManBean {
	private List<String> mName;

	
	public ManBean(List<String> mName) {
		super();
		this.mName = mName;
	}

	public ManBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<String> getmName() {
		return mName;
	}

	public void setmName(List<String> mName) {
		this.mName = mName;
	}

	@Override
	public String toString() {
		return "ManBean [mName=" + mName + "]";
	}
	
	
}
