import java.util.ArrayList;

import com.sun.tools.corba.se.idl.toJavaPortable.Helper;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Deal inputDeal() {
		String tag = Helper.readString("Enter asset tag > ");
		String description = Helper.readString("Enter description > ");
		int zoom = Helper.readInt("Enter optical zoom > ");

		Deal item = new Deal(tag, description, zoom);
		return item;
		
	}
	public static void addDeal(ArrayList<Deal> dealList, Deal item) {
		
		dealList.add(item);
		System.out.println("Deal added");
	}
	
	public void RetrieveAllDeals() {
		
	}
}
