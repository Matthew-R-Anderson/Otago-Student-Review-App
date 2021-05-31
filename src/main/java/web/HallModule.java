/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.HallDAO;
import domain.Review;
import domain.Student;
import org.jooby.Jooby;
import org.jooby.Status;


/**
 *
 * @author mattanderson
 */
public class HallModule extends Jooby {
    
    public HallModule (HallDAO hallDao){
        get("/api/halls", () -> hallDao.getHalls());
        
        get("/api/halls/:id", (req) -> {
            
        String id = req.param("id").value();
        
        
        return hallDao.searchByID(id);
    });
    }
}
