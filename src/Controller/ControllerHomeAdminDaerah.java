/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.ModelHomeAdminDaerah;
import TabelModel.Tabelha;
import UI.HomeAdminDaerah;
import Button.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author maula
 */
public class ControllerHomeAdminDaerah {
    private HomeAdminDaerah hap;
    private ModelHomeAdminDaerah modelhapd;
    private Tabelha tblha;
    private boolean isUpdate=false;
    private int row = -1;
    
    public ControllerHomeAdminDaerah(HomeAdminDaerah hap){
        this.hap = hap;
        tblha = new Tabelha();
        hap.getTabelhapd().setModel(tblha);
        hap.getTabelhapd().getColumnModel().getColumn(4).setCellRenderer(new Button("ubah",Color.GREEN));
        hap.getTabelhapd().getColumnModel().getColumn(5).setCellRenderer(new Button("hapus",Color.RED));
        hap.getTabelhapd().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (hap.getTabelhapd().getSelectedColumn()==4) {
                    row = hap.getTabelhapd().getSelectedRow();
                    hap.ubahha();
                    setDataha();
                }else if (hap.getTabelhapd().getSelectedColumn()==5) {
                    row = hap.getTabelhapd().getSelectedRow();
                    hapusha();
                }
            }
        });
    }
    
    public void setDataha(){
        ModelHomeAdminDaerah modelhapd = tblha.getOne(row);
        hap.getHasil().setSelectedItem(modelhapd.getHasilPertanian());
        hap.getJenis().setSelectedItem(modelhapd.getJenisHasil());
        hap.getTanggal().setText(modelhapd.getTanggal());
        hap.getHarga().setText(modelhapd.getHarga());
        isUpdate=true;
    }
    
    public void simpanha(){
        int jawab = JOptionPane.showOptionDialog(hap,"Anda Yakin Ingin Menambah Data?","Konfirmasi Tambah Data",
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
        if (jawab==JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(hap,"Data Berhasil Ditambahkan");
           
            modelhapd = new ModelHomeAdminDaerah();
            modelhapd.setHasilPertanian(hap.getHasil().getSelectedItem().toString());
            modelhapd.setJenisHasil(hap.getHasil().getSelectedItem().toString());
            modelhapd.setTanggal(hap.getTanggal().getText());
            modelhapd.setHarga(hap.getHarga().getText());
        }
        if (isUpdate) {
            tblha.ubah(row, modelhapd);
        }else {
            tblha.simpan(modelhapd);
        }
        refreshha();
    }
    
    public void batalha(){
        isUpdate = false;
        row=-1;
        refreshha();
    }
    
    public void refreshha(){
        hap.getHasil().setSelectedItem("");
        hap.getJenis().setSelectedItem("");
        hap.getTanggal().setText("");
        hap.getHarga().setText("");
        isUpdate=false;
    }
    
    private void hapusha(){
        tblha.hapus(row);
    }
}
