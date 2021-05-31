/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import domain.Review;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Finley
 */
public class ReviewJdbcDAO implements ReviewDAO {
    private String uri = DbConnection.getDefaultConnectionUri();;
    
    public ReviewJdbcDAO(){}
    
    public ReviewJdbcDAO(String uri){
        this.uri = uri;
    }

    @Override
    public void saveReview(Review review){
        
        String sql = "insert into review (Code, Review) values (?,?)";
        try (
        //get connection to database
        Connection dbCon = DriverManager.getConnection(uri);  
        
        //create the statement
        PreparedStatement stmt = dbCon.prepareStatement(sql)){
        //copy the data from the student domain object into the SQL parameters
//        stmt.setString (1, "MANT101");
//        stmt.setString (2, "Best Paper I ever seen");
        stmt.setString (1, review.getReview());
        stmt.setString (2, review.getCode());
        
        stmt.executeUpdate();

    
        } catch(SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
   }

