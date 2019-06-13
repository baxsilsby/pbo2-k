/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import TabelModel.Tabelha;
import UI.HomeUser;

/**
 *
 * @author maula
 */
public class ControllerHomeUser {
    private HomeUser hom;
    private Tabelha tblha;
    private String username,password;
    
    public ControllerHomeUser(HomeUser hom){
        this.hom = hom;
        tblha = new Tabelha();
        hom.getTabelha().setModel(tblha);
    }
    
    public String getKabupaten(){
        String a = hom.getDaerah().getSelectedItem().toString();
        return a;
    }
}
