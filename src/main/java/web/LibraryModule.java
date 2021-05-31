/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import dao.LibraryDAO;
import org.jooby.Jooby;

/**
 *
 * @author Finley
 */
public class LibraryModule extends Jooby {
    public LibraryModule(LibraryDAO libraryDao){
       get("/api/libraries", () -> libraryDao.getLibraries());
       
       get("/api/libraries/:id", (req) -> {
        String id = req.param("id").value();
        return libraryDao.searchByID(id);
        });
       
       
       get("/api/libraries/:name", (req) -> {
        String name = req.param("name").value();
        return libraryDao.searchByName(name);
        });
    
    }
    
}
