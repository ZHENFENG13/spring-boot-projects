package com.my.blog.website.utils.backup;

import java.util.ArrayList;

public class FKCollection extends ArrayList<FK>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -972085209611643212L;
	
	public boolean isReferenced(Table referenceTable){
		 for(FK fk : this){
			 if(fk.getReferenceTable().equals(referenceTable)){
				 return true;
			 }
		 }
		 return false;
	}
}
