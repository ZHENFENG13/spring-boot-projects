package com.my.blog.website.utils.backup;


public class Table {
	private String name;
	private ColumnCollection columns;
	private FKCollection constraints;
	
	public String getName() {
		return name;
	}

	public Table(String name) {
		this.name = name;
		this.columns = new ColumnCollection();
		this.constraints = new FKCollection();
	}
	
	public ColumnCollection getColumns() {
		return columns;
	}
	
	public FKCollection getConstraints() {
		return constraints;
	}

	@Override
	public String toString() {
		return "Table [name=" + name + "]";
	}
	
	public boolean isReferenced(Table referenceTable){
		return constraints.isReferenced(referenceTable);
	}
}
