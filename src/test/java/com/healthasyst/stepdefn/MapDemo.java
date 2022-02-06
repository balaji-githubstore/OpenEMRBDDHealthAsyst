package com.healthasyst.stepdefn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		HashMap<String, String> map1=new HashMap<String, String>();
		map1.put("firstname", "jack");
		map1.put("empname", "bala");
		
		
		System.out.println(map1.get("empid"));

		HashMap<String, String> map2=new HashMap<String, String>();
		map2.put("empid", "102");
		map2.put("empname", "jack");
		
		
		List<HashMap<String, String>> lists=new ArrayList<HashMap<String,String>>();
		
		
		lists.add(map1);
		lists.add(map2);
		
		System.out.println(lists.get(0).get("firstname"));
		
	}

}








