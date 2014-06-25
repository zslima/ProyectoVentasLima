/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.proyectoVentasDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import pe.edu.upeu.proyectoventasConfig.Conexion;

/**
 *
 * @author admin-harold.rojas
 */
public class ProductoDAO {
    private int op = 0;
    Connection cx;
    Statement st;
    public int registrarProducto(int idc, String prod, double precio, int cant){
        try {
            String sql = "INSERT INTO Producto VALUES(null, '"+prod+"', '"+precio+"', '"+cant+"','"+idc+"')";
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            op = st.executeUpdate(sql);
            cx.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR:" +ex);
            
        }
        return op;
    }
    
}
