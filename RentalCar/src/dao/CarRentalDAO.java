package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Car;
import model.CarRental;
import model.Contract;
import model.Failure;
import model.FailureDetail;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class CarRentalDAO extends DAO{

    public CarRentalDAO() {
        super();
    }
    
    public ArrayList<CarRental> showCarRentalInContract(String idContract) throws SQLException{
        String sql = "SELECT c2.id, c2.manufacturer, c2.type, c2.numberPlate, c1.dayStart, c1.dayEnd, c1.price FROM tblcarrental c1, tblcar c2 where c1.idCar = c2.id and c1.idContract = ? and c1.isReturned = 0;";
        ArrayList<CarRental> result = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, idContract);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Car car = new Car();
            car.setId(rs.getString("c2.id"));
            car.setManufacturer(rs.getString("c2.manufacturer"));
            car.setType(rs.getString("c2.type"));
            car.setNumberPlate(rs.getString("c2.numberPlate"));
            CarRental carRental = new CarRental();
            carRental.setDayStart(rs.getDate("c1.dayStart"));
            carRental.setDayEnd(rs.getDate("c1.dayEnd"));
            carRental.setTotalAmount(rs.getFloat("c1.price"));
            carRental.setCar(car);
            result.add(carRental);
        }
        return result;
    }
    
    public boolean addFailure(CarRental carRental){
        boolean result = true;
        String update = "UPDATE tblfailure SET name = ?, detail = ?, compensation = ? WHERE id = ?";
        String insert = "INSERT INTO tblfailure (id, name, detail, compensation) VALUES (?,?,?,?)";
        String addFailureDetail = "INSERT INTO tblfailuredetail (id, quantity, totalCompensation, idFailure, idCarRental) VALUES (?,?,?,?,?)";
        try{
            con.setAutoCommit(false);
            for(FailureDetail f : carRental.getFailures()){
                int tmp = 0;
                if(f.getFailure().getId() != 0){
                     PreparedStatement ps = con.prepareStatement(update);
                     ps.setString(1, f.getFailure().getName());
                     ps.setString(2, f.getFailure().getDescription());
                     ps.setFloat(3, f.getFailure().getCompensation());
                     ps.setInt(4, f.getFailure().getId());
                     tmp = f.getFailure().getId();
                     ps.executeUpdate();
                }
                else{
                    PreparedStatement ps = con.prepareStatement(insert);
                    ps.setString(2, f.getFailure().getName());
                    ps.setString(3, f.getFailure().getDescription());
                    ps.setFloat(4, f.getFailure().getCompensation());
                    ps.setInt(1, getFailureId());
                    tmp = getFailureId();
                    ps.execute();
                }
                PreparedStatement ps = con.prepareStatement(addFailureDetail);
                ps.setInt(1, getFailureDetailId());
                ps.setInt(2, f.getQuantity());
                ps.setFloat(3, f.getTotalCompensation());
                ps.setInt(4, tmp);
                ps.setInt(5, carRental.getId());
                ps.execute();
            }
            con.setAutoCommit(true);
        }
        catch(SQLException e){
            try {
                result = false;
                e.printStackTrace();
                con.rollback();
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(CarRentalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        finally{
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(CarRentalDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    private int getFailureId() throws SQLException{
        int tmp = 0;
        String sql = "SELECT max(id) FROM tblfailure;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
         if (rs.next()) {
            tmp = rs.getInt(1);
        }
         return tmp + 1;
    }
    
    private int getFailureDetailId() throws SQLException{
        int tmp = 0;
        String sql = "SELECT max(id) FROM tblfailuredetail;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
         if (rs.next()) {
            tmp = rs.getInt(1);
        }
         return tmp + 1;
    }
    
    public boolean returnCar(Contract contract, ArrayList<CarRental> listCarRentalChoosed){
        String sql = "UPDATE tblcarrental SET isReturned = 1 WHERE idCar = ? and idContract = ?;";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            for(CarRental c : listCarRentalChoosed){
                ps.setString(1, c.getCar().getId());
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
