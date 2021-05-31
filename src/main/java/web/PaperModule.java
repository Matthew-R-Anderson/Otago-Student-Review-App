/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import dao.PaperDAO;
import dao.ReviewDAO;
import domain.Review;
import org.jooby.Jooby;
import org.jooby.Status;

/**
 *
 * @author Finley
 */
public class PaperModule extends Jooby {
    
    public PaperModule(PaperDAO paperDao){
        get("/api/papers", () -> paperDao.getPapers());
        
        get("/api/papers/:code", (req) -> {
            String code = req.param("code").value();
            return paperDao.searchByPaperCode(code);
        });
                
                
        get("/api/departments", () -> paperDao.getDepartments());
         
        get("/api/departments/:dept", (req) -> {
            String cat = req.param("dept").value();
            return paperDao.filterByDepartment(cat);
        });
        
//        post("/api/papers/review", (req, rsp) -> {
//            Review review = req.body().to(Review.class);
////          ReviewDAO.saveReview(review);
//            rsp.status(Status.CREATED);
//        });
    }
    
}
