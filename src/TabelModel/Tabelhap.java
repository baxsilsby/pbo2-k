/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelModel;

import Model.ModelHomeAdmin;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author maula
 */
public class Tabelhap extends AbstractTableModel{

    private ArrayList<ModelHomeAdmin> list = new ArrayList<>();    
    private final String[] header = {"Hasil Pertanian","",""};
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public String getColumnName(int column){
      return header[column];  
    }
    
    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelHomeAdmin modelhap = list.get(rowIndex);
        switch(columnIndex){
            case 0 : return modelhap.getHasilpertanian();
            case 1 : return "";
            case 2 : return "";
            default : return null;
        }
    }
    
    public void simpan(ModelHomeAdmin modelhap){
        list.add(modelhap);
        fireTableRowsInserted(list.size()-1,list.size()-1);
    }
    
    public ModelHomeAdmin getOne(int row){
        return list.get(row);
    }
    
    public void ubah(int index, ModelHomeAdmin modelhap){
        list.set(index, modelhap);
        fireTableRowsUpdated(index, index);
    }
    
    public void hapus(int i){
        list.remove(i);
        fireTableRowsDeleted(i,i);
    }
}
