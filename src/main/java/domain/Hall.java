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
 * @author William Duggan
 */
public class Hall {

    private String hallId;
    private String title;
    private String description;
//    private String reviews;
//    private ArrayList<Review> reviews = new ArrayList<Review>();
//    private Multimap reviews = HashMultimap.create();
//    Collection<String> reviews = new ArrayList<>();
    private Collection<Review> reviews;

    public Hall(String hallId, String title, String description, Collection reviews) {
        this.hallId = hallId;
        this.title = title;
        this.description = description;
        this.reviews = reviews;
    }

    public Hall(String hallId, String title, String description) {
        this.hallId = hallId;
        this.title = title;
        this.description = description;
    }

    // Added empty Constructor can use above code but this is easier.
    public Hall() {
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {

    }

    @Override
    public String toString() {
        return "ID =" + hallId + ", Name =" + title + ", Description =" + description + ", Reviews =" + reviews;
    }

    

}
