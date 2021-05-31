/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Collection;

/**
 *
 * @author William Duggan
 */
public class Library {
    
    private String libraryId;
    private String name;
    private String description;
    private Collection<Review> reviews;
    

    public Library(String libraryId, String name, String description, Collection reviews) {
        this.libraryId = libraryId;
        this.name = name;
        this.description = description;
        this.reviews = reviews;
    }
    
    // Added empty Constructor can use above code but this is easier.
    public Library(){}


    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "ID =" + libraryId + ", Name =" + name + ", Description =" + description + ", Reviews =" + reviews.toString();
    }
    
}

