/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelModel;
import Model.ModelHomeAdminDaerah;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author maula
 */
public class Tabelha extends AbstractTableModel{
    
    private ArrayList<ModelHomeAdminDaerah> list = new ArrayList<>();    
    private final String[] header = {"Hasil Pertanian","Jenis","Tanggal Diperbarui","Harga (/kg) (Rp)","",""};
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
        ModelHomeAdminDaerah modelhap = list.get(rowIndex);
        switch(columnIndex){
            case 0 : return modelhap.getHasilPertanian();
            case 1 : return modelhap.getJenisHasil();
            case 2 : return modelhap.getTanggal();
            case 3 : return modelhap.getHarga();
            case 4 : return "";
            case 5 : return "";
            default : return null;
        }
    }
    
    public void simpan(ModelHomeAdminDaerah modelhap){
        list.add(modelhap);
        fireTableRowsInserted(list.size()-1,list.size()-1);
    }
    
    public ModelHomeAdminDaerah getOne(int row){
        return list.get(row);
    }
    
    public void ubah(int index, ModelHomeAdminDaerah modelhap){
        list.set(index, modelhap);
        fireTableRowsUpdated(index, index);
    }
    
    public void hapus(int i){
        list.remove(i);
        fireTableRowsDeleted(i,i);
    }
    
}
