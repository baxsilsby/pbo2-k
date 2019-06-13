/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.ModelHomeAdmin;
import TabelModel.Tabelhap;
import TabelModel.Tabeljhap;
import UI.HomeAdmin;
import Button.Button;
import TabelModel.Tabelda;
import TabelModel.Tabelha;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author maula
 */
public class ControllerHomeAdmin {
    private HomeAdmin hap;
    private ModelHomeAdmin modelhap;
    private Tabelhap tblhap;
    private Tabeljhap tbljhap;
    private Tabelda tblda;
    private Tabelha tblha;
    private boolean isUpdate=false;
    private int row = -1;
    public ControllerHomeAdmin(HomeAdmin hap){
        this.hap = hap;
        tblhap = new Tabelhap();
        tbljhap = new Tabeljhap();
        tblda = new Tabelda();
        tblha = new Tabelha();
        hap.getTabelha().setModel(tblha);
        hap.getTabelhap().setModel(tblhap);
        hap.getTabelhap().getColumnModel().getColumn(1).setCellRenderer(new Button("ubah",Color.GREEN));
        hap.getTabelhap().getColumnModel().getColumn(2).setCellRenderer(new Button("hapus",Color.RED));
        hap.getTabelhap().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (hap.getTabelhap().getSelectedColumn()==1) {
                    row = hap.getTabelhap().getSelectedRow();
                    hap.ubahhap();
                    setDatahap();
                }else if (hap.getTabelhap().getSelectedColumn()==2) {
                    row = hap.getTabelhap().getSelectedRow();
                    hapushap();
                }
            }
        });
        hap.getTabeljhap().setModel(tbljhap);
        hap.getTabeljhap().getColumnModel().getColumn(2).setCellRenderer(new Button("ubah",Color.GREEN));
        hap.getTabeljhap().getColumnModel().getColumn(3).setCellRenderer(new Button("hapus",Color.RED));
        hap.getTabeljhap().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (hap.getTabeljhap().getSelectedColumn()==2) {
                    row = hap.getTabeljhap().getSelectedRow();
                    hap.ubahjhap();
                    setDatajhap();
                }else if (hap.getTabeljhap().getSelectedColumn()==3) {
                    row = hap.getTabeljhap().getSelectedRow();
                    hapusjhap();
                }
            }
        });
        hap.getTabelda().setModel(tblda);
        hap.getTabelda().getColumnModel().getColumn(7).setCellRenderer(new Button("ubah",Color.GREEN));
        hap.getTabelda().getColumnModel().getColumn(8).setCellRenderer(new Button("hapus",Color.RED));
        hap.getTabelda().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (hap.getTabelda().getSelectedColumn()==7) {
                    row = hap.getTabelda().getSelectedRow();
                    hap.ubahda();
                    setDatadaftaradmin();
                }else if (hap.getTabelda().getSelectedColumn()==8) {
                    row = hap.getTabelda().getSelectedRow();
                    hapusda();
                }
            }
        });
    }
    
    public void setDatahap(){
        ModelHomeAdmin modelhap = tblhap.getOne(row);
        hap.getHasilPertanian().setText(modelhap.getHasilpertanian());
        isUpdate=true;
    }
    public void setDatajhap(){
        ModelHomeAdmin modelhap = tbljhap.getOne(row);
        hap.getHasil().setSelectedItem(modelhap.getHasil());
        hap.getJenis().setText(modelhap.getJenishasil());
        isUpdate=true;
    }
    public void setDatadaftaradmin(){
        ModelHomeAdmin modelhap = tblda.getOne(row);
        hap.getNamaPengguna().setText(modelhap.getNamapengguna());
        hap.getPassword().setText(modelhap.getPassword());
        hap.getNama().setText(modelhap.getNama());
        hap.getEmail().setText(modelhap.getEmail());
        hap.getNoHP().setText(modelhap.getNohp());
        hap.getAlamat().setText(modelhap.getAlamat());
        hap.getDaerah().setSelectedItem(modelhap.getDaerah());
        isUpdate=true;
    }
    
    public void batalhap(){
        isUpdate = false;
        row=-1;
        refreshhap();
    }
    public void bataljhap(){
        isUpdate = false;
        row=-1;
        refreshjhap();
    }
    public void bataldaftaradmin(){
        isUpdate = false;
        row=-1;
        refreshdaftaradmin();
    }
    
    public void simpanhap(){
        int jawab = JOptionPane.showOptionDialog(hap,"Anda Yakin Ingin Menambah Data?","Konfirmasi Tambah Data",
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
        if (jawab==JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(hap,"Data Berhasil Ditambahkan");
           
            modelhap = new ModelHomeAdmin();
            modelhap.setHasilpertanian(hap.getHasilPertanian().getText());
        }
        if (isUpdate) {
            tblhap.ubah(row, modelhap);
        }else {
            tblhap.simpan(modelhap);
        }
        refreshhap();
    }
    
    public void simpanjhap(){
        int jawab = JOptionPane.showOptionDialog(hap,"Anda Yakin Ingin Menambah Data?","Konfirmasi Tambah Data",
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
        if (jawab==JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(hap,"Data Berhasil Ditambahkan");
           
            modelhap = new ModelHomeAdmin();
            modelhap.setHasil(hap.getHasil().getSelectedItem().toString());
            modelhap.setJenishasil(hap.getJenis().getText());
        }
        if (isUpdate) {
            tbljhap.ubah(row, modelhap);
        }else {
            tbljhap.simpan(modelhap);
        }
        refreshjhap();
    }
    
    public void simpandaftaradmin(){
        int jawab = JOptionPane.showOptionDialog(hap,"Anda Yakin Ingin Menambah Data?","Konfirmasi Tambah Data",
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
        if (jawab==JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(hap,"Data Berhasil Ditambahkan");
           
            modelhap = new ModelHomeAdmin();
            modelhap.setNamapengguna(hap.getNamaPengguna().getText());
            modelhap.setPassword(hap.getPassword().getText());
            modelhap.setNama(hap.getNama().getText());
            modelhap.setEmail(hap.getEmail().getText());
            modelhap.setNohp(hap.getNoHP().getText());
            modelhap.setAlamat(hap.getAlamat().getText());
            modelhap.setDaerah(hap.getDaerah().getSelectedItem().toString());
        }
        if (isUpdate) {
            tblda.ubah(row, modelhap);
        }else {
            tblda.simpan(modelhap);
        }
        refreshdaftaradmin();
    }
    
    public void simpanprofil(){
        int jawab = JOptionPane.showOptionDialog(hap,"Anda Yakin Ingin Menambah Data?","Konfirmasi Tambah Data",
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
        if (jawab==JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(hap,"Data Berhasil Ditambahkan");
           
            modelhap = new ModelHomeAdmin();
            modelhap.setNamapenggunadiri(hap.getNamaPenggunaDiri().getText());
            modelhap.setPassworddiri(hap.getPasswordDiri().getText());
            modelhap.setNamadiri(hap.getNamaDiri().getText());
            modelhap.setEmaildiri(hap.getEmailDiri().getText());
            modelhap.setNohpdiri(hap.getNoHPDiri().getText());
            modelhap.setAlamatdiri(hap.getAlamatDiri().getText());
        }
    }
    
    public void refreshhap(){
        hap.getHasilPertanian().setText("");
        isUpdate=false;
    }
    public void refreshjhap(){
        hap.getHasil().setSelectedItem("");
        hap.getJenis().setText("");
        isUpdate=false;
    }
    public void refreshdaftaradmin(){
        hap.getNamaPengguna().setText("");
        hap.getPassword().setText("");
        hap.getNama().setText("");
        hap.getEmail().setText("");
        hap.getNoHP().setText("");
        hap.getAlamat().setText("");
        hap.getDaerah().setSelectedItem("");
        isUpdate=false;
    }
    private void hapushap(){
        tblhap.hapus(row);
    }
    private void hapusjhap(){
        tbljhap.hapus(row);
    }
    private void hapusda(){
        tblda.hapus(row);
    }
}
