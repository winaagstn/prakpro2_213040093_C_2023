/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;
import Table.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author wina agustina
 */
class MyTableModel extends AbstractTableModel{
//    Berfungsi menginisialisasi nama kolom untuk tabel
    private String[] columnNames = {"Nama","Nomor HP", "Jenis Kelamin", "Alamat" };
//    Berfungsi untuk menginisialisasi ArrayList yang berisi String
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    
//    Berfungsi untuk mengembalikan panjang nama kolom
    public int getColumnCount(){
        return columnNames.length;
    }
//    Berfungsi untuk mengembalikan ukuran data
    public int getRowCount(){
        return data.size();
    }
//    Berfungsi untuk mengembalikan panjang kolom nama dengan parameter kolom
    public String getColumnName(int col){
        return columnNames[col];
    }
    public Object getValueAt(int row, int col){
        List<String> rowItem = data.get(row);
        return rowItem.get(col);
    }
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        this.fireTableCellUpdated(row, col);
    } 

    public void add (ArrayList<String> value){
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public boolean isCellEditable(int row, int col){
        return false;
    }
    
    public void removeRow(int row, int col){
       List<String> rowItem = data.get(row);
    }
        
}


}
