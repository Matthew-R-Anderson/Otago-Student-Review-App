/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Finley
 */
public class Review {
    String review;
    String code;
    
    public String getReview() {
        return review;
    }

    public void setCode(String code){
        this.code = code;
    }
    
    public String getCode(){
        return code;
    }
    
    
    public void setReview(String review) {
        this.review = review;
    }
    
    
    
    
//    String paperid;
//    String libraryid;
//    String tutorid;
//    String hallid;
//    private Paper paper;
//    private Hall hall;
//    private Library library;
//    private Tutor tutor;
//
//    
//    
//    public String getReview() {
//        return review;
//    }
//
//    public void setReview(String review) {
//        this.review = review;
//    }
//    
//    public String getPaperid() {
//        return paperid;
//    }
//
//    public void setPaperid(String paperid) {
//        this.paperid = paperid;
//    }
//
//    public String getLibraryid() {
//        return libraryid;
//    }
//
//    public void setLibraryid(String libraryid) {
//        this.libraryid = libraryid;
//    }
//
//    public String getTutorid() {
//        return tutorid;
//    }
//
//    public void setTutorid(String tutorid) {
//        this.tutorid = tutorid;
//    }
//
//    public String getHallid() {
//        return hallid;
//    }
//
//    public void setHallid(String hallid) {
//        this.hallid = hallid;
//    }
//
//    @Override
//    public String toString() {
//        return "Review{" + "review=" + review + ", paperid=" + paperid + ", libraryid=" + libraryid + ", tutorid=" + tutorid + ", hallid=" + hallid + '}';
//    }
//    

    @Override
    public String toString() {
        return review + '\n';
    }

   
    
    
}
