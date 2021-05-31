package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author William Duggan
 */
public class Paper {

    private String paperId;
    private String code;
    private String title;
    private String description;
    private String department;
    private Collection<Review> reviews;

    public Paper(String paperId, String code, String title, String description,String department, Collection reviews) {
        this.paperId = paperId;
        this.code = code;
        this.title = title;
        this.description = description;
        this.department = department;
        this.reviews = reviews;

    }
    // Added Constructor can use above code but this is easier.

    public Paper() {
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public void addReview(Review review) {

    }

    @Override
    public String toString() {
        return "ID =" + paperId + ", Name =" + title + ", Code =" + code + ", Description =" + description + ", department=" + department + ", Reviews =" + reviews.toString();
    }

}
