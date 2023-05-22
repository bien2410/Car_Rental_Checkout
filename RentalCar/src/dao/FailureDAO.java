/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Client;
import model.Contract;
import model.Failure;

/**
 *
 * @author ADMIN
 */
public class FailureDAO  extends DAO{
    
    public FailureDAO(){
        super();
    }
    
    public ArrayList<Failure> showFailure() throws SQLException{
        String sql = "SELECT * FROM tblfailure;";
        ArrayList<Failure> result = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Failure failure = new Failure();
            failure.setId(rs.getInt("id"));
            failure.setName(rs.getString("name"));
            failure.setDescription(rs.getString("detail"));
            failure.setCompensation(rs.getFloat("compensation"));
            result.add(failure);
        }
        return result;
    }
}
