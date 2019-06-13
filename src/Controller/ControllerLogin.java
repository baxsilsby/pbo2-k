/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelLogin;
import UI.Login;
import javax.swing.JOptionPane;

/**
 *
 * @author maula
 */
public class ControllerLogin {
    private Login lgn;
    private ModelLogin modellgn;
    
    public ControllerLogin(Login lgn){
        this.lgn = lgn;
        modellgn = new ModelLogin();
    }
    
    public String cekakun(){
    if (lgn.getUsername().getText().equals(modellgn.getUsernamepusat()) && lgn.getPassword().getText().equals(modellgn.getPasswordpusat())) {
        return "pusat";
    }else if(lgn.getUsername().getText().equalsIgnoreCase(modellgn.getUsernamedaerah()) && lgn.getPassword().getText().equalsIgnoreCase(modellgn.getPassworddaerah())){
        return "daerah";
    }else {
        return "salah";
    }
    }
}
