package com.my.blog.website.utils.backup;

import java.util.ArrayList;

public class TableCollection extends ArrayList<Table> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5824322959198795936L;

	/**
	 * Sort tables according to constraints
	 */
	public void sort(){
		for(int i = 0 ; i < size(); ){
			boolean corrupted = false;
			for(int j = i + 1; j < size(); j++){
				if(get(i).isReferenced(get(j))){
					Table table = get(i);
					remove(table);
					add(table);
					corrupted = true;
					break;
				}
			}
			if(!corrupted){
				i++;
			}
		}
	}
}
