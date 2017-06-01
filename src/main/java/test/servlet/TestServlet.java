package test.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//https://dev64.wordpress.com/2012/03/23/simple-servlet-using-maven/
//http://www.java2ee.ru/servlets/index.html
public class TestServlet extends HttpServlet {

	private String responseTemplate =
			"<html>\n" +
					"<body>\n" +
					"<h2>Hello from Test Servlet</h2>\n" +
					"</body>\n" +
					"</html>";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setStatus(200);
		response.getWriter().write(responseTemplate);
	}
}
