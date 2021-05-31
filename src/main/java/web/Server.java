/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import dao.*;
import java.util.concurrent.CompletableFuture;
import org.jooby.Jooby;
import org.jooby.json.Gzon;

/**
 *
 * @author Finley
 */
public class Server extends Jooby{
    PaperDAO paperDao = new PaperJdbcDAO();
    StudentDAO studentDao = new StudentJdbcDAO();
    TutorDAO tutorDao = new TutorJdbcDAO();
    LibraryDAO libraryDao = new LibraryJdbcDAO();
    HallDAO hallDao = new HallJdbcDAO();
    ReviewDAO reviewDao = new ReviewJdbcDAO();
    
    
    Server(){
        port(8080);
        use(new Gzon());
        use(new PaperModule(paperDao));
        use(new StudentModule(studentDao));
        use(new LibraryModule(libraryDao));
        use(new HallModule(hallDao));
        use(new ReviewModule(reviewDao));
        use(new TutorModule(tutorDao));
        use(new ReviewModule(reviewDao));
        use(new AssetModule()); 
    }
    
    
    public static void main(String[] args) throws Exception {
        System.out.println("\nStarting Server.");

        Server server = new Server();

        CompletableFuture.runAsync(() -> {
            server.start();
        });

        server.onStarted(() -> {
            System.out.println("\nPress Enter to stop the server.");
        });

        // wait for user to hit the Enter key
        System.in.read();
        System.exit(0);
    }


    
}
