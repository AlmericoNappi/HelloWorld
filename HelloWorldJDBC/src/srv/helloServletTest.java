package srv;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejbTestRemote;

/**
 * Servlet implementation class helloServletTest
 */
@WebServlet("/helloServletTest")
public class helloServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
//	@Resource(mappedName = "java:jboss/exported/nomeprogetto/nomeclasse!nomepackage.nomeinterfacciaremote")
	@Resource(mappedName = "java:jboss/exported/HelloWorldJDBC/ejbTest!com.ejbTestRemote")
	private ejbTestRemote bs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public helloServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(bs.prova());
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
