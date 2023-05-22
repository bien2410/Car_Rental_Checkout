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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CarRental;
import model.Contract;
import model.Mortgage;
import model.MortgageDetail;

/**
 *
 * @author ADMIN
 */
public class MortgageDetailDAO extends DAO{
    
    public MortgageDetailDAO() {
        super();
    }
    
    public ArrayList<MortgageDetail> showMortgageDetailInContract(String idContract) throws SQLException{
        String sql = "SELECT c2.id, c2.name, c1.quantity, c1.note FROM tblmortgagedetail c1, tblmortgage c2 where c1.idMortgage = c2.id and c1.idContract = ? and c1.isReturned = 0;";
        ArrayList<MortgageDetail> result = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, idContract);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Mortgage mortgage = new Mortgage(rs.getString("c2.id"), rs.getString("c2.name"));
            MortgageDetail mortgageDetail = new MortgageDetail();
            mortgageDetail.setQuantity(rs.getInt("c1.quantity"));
            mortgageDetail.setNote(rs.getString("c1.note"));
            mortgageDetail.setMortgage(mortgage);
            result.add(mortgageDetail);
        }
        return result;
    }
    
    public boolean returnMortgage(Contract contract, ArrayList<MortgageDetail> listMortgageDetailChoosed){
        String sql = "UPDATE tblmortgagedetail SET isReturned = 1 WHERE idMortgage = ? and idContract = ?;";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            for(MortgageDetail m : listMortgageDetailChoosed){
                ps.setString(1, m.getMortgage().getId());
                ps.setString(2, contract.getId());
                ps.execute();
            }
            con.setAutoCommit(true);
        }
        catch(SQLException e){
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(CarRentalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
        finally{
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(CarRentalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
}
