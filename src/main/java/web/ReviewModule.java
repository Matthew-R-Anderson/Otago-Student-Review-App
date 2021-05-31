/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;


import dao.ReviewDAO;
import domain.Review;
import dao.StudentJdbcDAO;
import domain.Student;
import org.jooby.Jooby;
import org.jooby.Result;
import org.jooby.Status;

/**
 *
 * @author dugwi731
 */
public class ReviewModule extends Jooby {

	// StudentDAO studentDao = new StudentJdbcDAO();

	public ReviewModule(ReviewDAO reviewDao) {
		post("/api/review", (req, rsp) -> {
			Review review = req.body().to(Review.class);
                        System.out.println(review);
			reviewDao.saveReview(review);
                        rsp.status(Status.CREATED).send(review);
		});
                
                
              
                
                
              
	}
}
