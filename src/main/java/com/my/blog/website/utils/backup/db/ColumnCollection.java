package com.my.blog.website.utils.backup.db;

import java.util.ArrayList;

public class ColumnCollection extends ArrayList<Column>{

	private static final long serialVersionUID = -3399188477563370223L;

	public int indexByLabel(String label){
		for(int i = 0; i < this.size(); i++){
			if(get(i).getLabel().equals(label)){
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public String toString() {
		if(size() == 0){
			return "Columns is empty";
		}
		String s = "Columns : {" + String.valueOf(get(0).getLabel());
		for(int i = 1; i < size(); i++){
			s += ", " + String.valueOf(get(i).getLabel());
		}
		s += "}";
		return s;
	}
}
