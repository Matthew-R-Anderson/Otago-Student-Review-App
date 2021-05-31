/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Hall;
import domain.Review;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author mattanderson
 */
public class HallJdbcDAO implements HallDAO {

    private String uri = DbConnection.getDefaultConnectionUri();

    public HallJdbcDAO() {

    }

    public HallJdbcDAO(String uri) {
        this.uri = uri;
    }

    @Override
    public Collection<Hall> getHalls() {
        String sql = "select * from Hall";
        try ( Connection dbCon = DriverManager.getConnection(uri);  PreparedStatement prepstate = dbCon.prepareStatement(sql)) {

            ResultSet rs = prepstate.executeQuery();
            List<Hall> halls = new ArrayList<>();

            while (rs.next()) {
                String hallId = rs.getString("Hall_ID");
                String title = rs.getString("Hall_Title");
                String description = rs.getString("Description");
//                Collection<Reviews> reviews = rs.getObject("Review");
                Collection<Review> reviews = getReviews(title);

                Hall hall = new Hall(hallId, title, description, reviews);
                halls.add(hall);
            }

            return halls;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public Collection<Review> getReviews(String title) {
        String sql = "select * from review where code = ?";
        try ( Connection dbCon = DriverManager.getConnection(uri);  PreparedStatement prepstate = dbCon.prepareStatement(sql)) {
            
            prepstate.setString(1, title);
            ResultSet rs = prepstate.executeQuery();
            Collection<Review> reviews = new ArrayList<>(); 
            
            while (rs.next()) {
                Review r = new Review();
                
                String review = rs.getString("Review");
                r.setReview(review);
                
                reviews.add(r);
            }
            return reviews;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }

    }

    @Override
    public void saveHall(Hall hall) {

        String sql = "insert into Hall (Hall_ID, Hall_Title, Description) values (?, ?, ?)";

        try ( Connection dbCon = DriverManager.getConnection(uri);  PreparedStatement prepstate = dbCon.prepareStatement(sql);) {
            prepstate.setString(1, hall.getHallId());
            prepstate.setString(2, hall.getTitle());
            prepstate.setString(3, hall.getDescription());
//            prepstate.setObject(4, hall.getReviews());

            prepstate.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }

    }

    @Override
    public void removeHall(Hall hall) {
        String sql = "remove from Hall where Hall_ID = ?";
    }

    @Override
    public Hall searchByID(String id) {

        String sql = "select * from Hall where Hall_ID = ?";

        try ( Connection dbCon = DriverManager.getConnection(uri);  PreparedStatement prepstate = dbCon.prepareStatement(sql);) {

            prepstate.setString(1, id);

            ResultSet rs = prepstate.executeQuery();

            if (rs.next()) {
                String hallID = rs.getString("Hall_ID");
                String halltitle = rs.getString("Hall_Title");
                String description = rs.getString("Description");
                Collection<Review> reviews = getReviews(hallID);

                Hall hall = new Hall();
                hall.setHallId(hallID);
                hall.setTitle(halltitle);
                hall.setDescription(description);
                hall.setReviews(reviews);
                return hall;

            } else {
                return null;
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }

    }

    @Override
    public Hall searchByName(String name) {

        String sql = "select * from Hall where Hall_Title = ?";

        try ( Connection dbCon = DriverManager.getConnection(uri);  PreparedStatement prepstate = dbCon.prepareStatement(sql);) {

            prepstate.setString(1, name);

            ResultSet rs = prepstate.executeQuery();

            if (rs.next()) {
                String hallID = rs.getString("Hall_ID");
                String halltitle = rs.getString("Hall_Title");
                String description = rs.getString("Description");
                Collection<Review> reviews = getReviews(halltitle);

                Hall hall = new Hall();
                hall.setHallId(hallID);
                hall.setTitle(halltitle);
                hall.setDescription(description);
                hall.setReviews(reviews);
                return hall;

            } else {
                return null;
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

}
