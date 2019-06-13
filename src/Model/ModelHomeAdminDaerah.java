/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author maula
 */
public class ModelHomeAdminDaerah {
    private String hasilPertanian,jenisHasil,tanggal,harga;
    
    public ModelHomeAdminDaerah(){
        
    }
    
    //get
    public String getHasilPertanian() {
        return hasilPertanian;
    }

    public String getJenisHasil() {
        return jenisHasil;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getHarga() {
        return harga;
    }

    //set
    public void setHasilPertanian(String hasilPertanian) {
        this.hasilPertanian = hasilPertanian;
    }

    public void setJenisHasil(String jenisHasil) {
        this.jenisHasil = jenisHasil;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
    
    
    
}
