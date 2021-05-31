/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author caothihoangngan
 */
public class Tutor {

    private String tutor_ID;

    private String name;
    private String email;
    //private ArrayList<String> paperList = new ArrayList<>();
    private String description;
    private Collection<Review> reviews;

    public Tutor(String tutor_ID, String name, String email, String description, Collection reviews) {
        this.tutor_ID = tutor_ID;
        this.name = name;
        this.email = email;
        this.description = description;
        this.reviews = reviews;
        
    }

    public Tutor() {
    }

    
    
    
    public String getTutor_ID() {
        return tutor_ID;
    }

    public void setTutor_ID(String tutor_ID) {
        this.tutor_ID = tutor_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public ArrayList<String> getPaper() {
//        return paperList;
//    }
//
//    public void setPaper(ArrayList<String> paper) {
//        this.paperList = paper;
//    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }

    

    @Override
    public String toString() {
        return "ID =" + tutor_ID + ", Name =" + name + ", Email =" + email + ", Description =" + description + ", Reviews =" + reviews.toString();
    }

}
