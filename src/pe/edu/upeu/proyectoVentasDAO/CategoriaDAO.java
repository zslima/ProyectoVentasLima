/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.proyectoVentasDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pe.edu.upeu.proyectoventasConfig.Conexion;
import pe.edu.upeu.proyectoVentas.modelo.Categoria;

/**
 *
 * @author admin-harold.rojas
 */
public class CategoriaDAO {
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    int id;
    Categoria ct = new Categoria();
    public ArrayList<Categoria> listarCategoria(){
    ArrayList<Categoria> lista = new ArrayList();
     sql = "SELECT *FROM Categoria";
    
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(ct.loadCategoria(rs));            
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
        }    
    return lista;
    }

    public int DevolverIdCategoria(String cat){
        int idcat=0;
         sql = "SELECT *FROM Categoria WHERE categoria='"+cat+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            idcat = rs.getInt("idCategoria");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR:" +e);
        }
    return idcat;
    }
}
