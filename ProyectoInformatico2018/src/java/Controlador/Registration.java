/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Usuario;
/**
 *
 * @author arken
 */
public class Registration{
    
    private static IDao<Usuario> userDao = new UsuarioDao();
    
    public Registration(){
    }
    
    public static void save(Usuario user){
        userDao.save(user);
    }
    
}
