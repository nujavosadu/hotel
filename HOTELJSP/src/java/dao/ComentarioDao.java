/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbUtil;


/**
 *
 * @author oscar
 */
public class ComentarioDao {
    
    
    private Connection connection;

    public ComentarioDao() {
        connection = DbUtil.getConnection();
    }

    public void addComentario(String name,String mail,String msg) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into comentario(nombre,mail,mensaje) values (?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, mail);
            preparedStatement.setString(3, msg);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
