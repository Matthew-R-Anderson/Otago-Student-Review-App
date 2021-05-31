/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.TutorDAO;
import org.jooby.Jooby;


/**
 *
 * @author mattanderson
 */
public class TutorModule extends Jooby {
    
    public TutorModule (TutorDAO tutorDao){
        get("/api/tutors", () -> tutorDao.getTutors());
        
        get("/api/tutors/:id", (req) -> {
        String id = req.param("id").value();
        return tutorDao.searchByID(id);
    });
        get("/api/tutors/:name", (req) -> {
        String name = req.param("name").value();
        return tutorDao.searchByName(name);
    });
    }
}
