/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Client;
import model.Contract;

/**
 *
 * @author ADMIN
 */
public class ContractDAO extends DAO{
    public ContractDAO(){
        super();
    }
    public ArrayList<Contract> searchContract(String ContractId, String ClientName) throws SQLException, ParseException{
        String sql = "SELECT c1.id, c2.name, c2.address, c2.tel, c1.day FROM tblcontract c1, tblclient c2 where c1.idClient = c2.id and c1.id LIKE ? and c2.name LIKE ?;";
        ArrayList<Contract> result = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "%" + ContractId + "%");
        ps.setString(2, "%" + ClientName + "%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Client client = new Client();
            client.setName(rs.getString("c2.name"));
            client.setAddress(rs.getString("c2.address"));
            client.setTel(rs.getString("c2.tel"));
            Contract contract = new Contract();
            contract.setId(rs.getString("c1.id"));
            contract.setDay(rs.getDate("c1.day"));
            contract.setClient(client);
            result.add(contract);
        }
        return result;
    }
}
