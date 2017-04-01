package com.my.blog.website.utils.backup.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataTable extends ArrayList<Row> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3057968190529400383L;

	public static DataTable execute(Connection connection, String query)
			throws SQLException {
		return parse(connection.prepareStatement(query).executeQuery());
	}

	public static DataTable parse(ResultSet resultSet) throws SQLException {
		ResultSetMetaData metaData = resultSet.getMetaData();
		DataTable dataTable = new DataTable();
		dataTable.columns = new ColumnCollection();

		int colCount = metaData.getColumnCount();
		for (int i = 1; i <= colCount; i++) {
			Column column = new Column();
			column.setCatalogName(metaData.getCatalogName(i));
			column.setColumnClassName(metaData.getColumnClassName(i));
			column.setDisplaySize(metaData.getColumnDisplaySize(i));
			column.setLabel(metaData.getColumnLabel(i));
			column.setName(metaData.getColumnName(i));
			column.setPrecision(metaData.getPrecision(i));
			column.setScale(metaData.getScale(i));
			column.setSchemaName(metaData.getSchemaName(i));
			column.setTableName(metaData.getTableName(i));
			column.setType(metaData.getColumnType(i));
			column.setTypeName(metaData.getColumnTypeName(i));
			dataTable.columns.add(column);
		}

		while (resultSet.next()) {
			Object[] data = new Object[colCount];
			for (int i = 1; i <= data.length; i++) {
				data[i - 1] = resultSet.getObject(i);
			}
			dataTable.add(new Row(dataTable, data));
		}
		resultSet.close();
		return dataTable;
	}

	private ColumnCollection columns;

	public ColumnCollection getColumns() {
		return columns;
	}

	@Override
	public String toString() {
		String s = columns.toString() + "\n";
		if (size() == 0) {
			s += "Rows is empty\n";
		} else {
			s += "Rows : {" + String.valueOf(get(0));
			for (int i = 1; i < size(); i++) {
				s += "\n" + String.valueOf(get(i));
			}
			s += "}\n";
		}
		return s;
	}
}
