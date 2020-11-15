package patterns;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class UserAdapter extends AbstractTableModel {
	
	public String[] columnNames = {"Event", "Question", "Event Date", "Bet(Euros)"};
	public ArrayList<AdapterRow> rowtable = new ArrayList<AdapterRow>();
	public int columncount = 4;
	public int rowcount;
	
	public UserAdapter() {
		this.rowcount = 0;
	}
	
	public void insertRow(AdapterRow row) {
		rowtable.add(rowcount, row);
		this.rowcount = rowtable.size();
	}

	@Override
	public int getRowCount() {
		return this.rowcount;
	}

	@Override
	public int getColumnCount() {
		return this.columncount;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		AdapterRow row = rowtable.get(rowIndex);
		Object val;
		switch(columnIndex) {
		case 0:
			val = row.getEvent();
			break;
		case 1:
			val = row.getQuestion();
			break;
		case 2:
			val = row.getDate();
			break;
		case 3:
			val = row.getBet();
			break;
		default:
			val = null;
			break;
		}
		return val;
		
	}
	
	public String getColumnName(int col) {
	      return columnNames[col];
	   }

}
