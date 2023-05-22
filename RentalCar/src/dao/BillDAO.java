/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO.con;
import java.sql.*;
import java.text.SimpleDateFormat;
import model.Bill;

/**
 *
 * @author ADMIN
 */
public class BillDAO extends DAO{

    public BillDAO() {
        super();
    }
    
    public void addBill(Bill bill) throws SQLException{
        String sql = "INSERT INTO tblbill (id, day, note, idUser, idContract) VALUES (?, ?, ?, ?, ?);";
                
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, getBillId());
        ps.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(bill.getDay()));
        ps.setString(3, "");
        ps.setInt(4, bill.getUser().getId());
        ps.setString(5, bill.getContract().getId());
        ps.execute();
    }
    
    private String getBillId() throws SQLException{
        String sql = "SELECT MAX(id) FROM tblbill";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String id = "HD0";
        if (rs.next()) {
            id = rs.getString(1);
        }
        String stt = id.substring(2);
        int sttNew = Integer.parseInt(stt) + 1;
        return "HD" + sttNew;
    }
    
}
