package net.viralpatel.maven;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class MovieActionServlet
 */
public class MovieActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			Movie localMovie = ExternalMovieInformation.getMovieInformation(request.getParameter("movieName"));
			
			request.setAttribute("movieName", localMovie.getTitle().toString());
			request.setAttribute("movieGenre", localMovie.getGenre().toString());
			request.setAttribute("movieRating", localMovie.getRated().toString());
			request.setAttribute("moviePoster", localMovie.getPoster().toString());
			
			response.setContentType("text/html");
			request.getRequestDispatcher("/movie.jsp").forward(request, response);
		}catch(Exception e){
			
			System.out.println("Something happened Error: " + e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
