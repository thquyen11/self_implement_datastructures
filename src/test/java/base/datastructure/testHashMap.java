package base.datastructure;

import base.datastructure.qHashMap;

public class testHashMap {

	public static void main(String[] args) {
//		String[] ar = new String[4];
		qHashMap map = new qHashMap<>(10);
		map.put("MXBIN", "a");
		map.put("MXLOG", "b");
		map.put("MXBKP", "c");
		map.put("MX", "d");
		map.put("MXTRANSIT", "e");
//		map.displayMap();
				
		map.put("MXBIN", "a");
		map.displayMap();

	}

}
