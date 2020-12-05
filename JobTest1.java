package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// DAO, DTO 추가

import examples.dto.Job;
import examples.dao.JobDAO;

import java.util.List;

/**
 * Servlet implementation class JobTest1
 */
@WebServlet("/JobTest1")
public class JobTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobTest1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DAO add doGet() 호출!");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		JobDAO dao = new JobDAO();
		
		// 1. getJob test
		Job job = null;
		job = dao.getJob(1);
		if(job == null)
			out.println("<h1> My Job is null </h1>");
		else
			out.println("<h1> My Job " + job.getJobId() + "번: "
					+ job.getDescription() + "!!! </h1>");
		
		
		// 2. addJob test
		Job job1 = new Job(8, "temp");
		
		int addCount = dao.addJob(job1);
		out.println("<h1> Insert : " + addCount + " row(s) </h1>");
		
		
		// 3. deleteJob test
	
		int delCount = dao.deleteJob(1);
		out.println("<h1> Delete : " + delCount + " row(s) </h1>");
		
		
		// 4. addJob test
		Job job2 = new Job(9, "updated");
				
		int updateCount = dao.updateJob(job2);
		out.println("<h1> Update : " + updateCount + " row(s) </h1>");
		
		
		// 5. getJobs test
		List<Job> jobList = dao.getJobs();
		
		for (Job job3 : jobList)
		{
			out.println("<h1> My Job " + job3.getJobId() + "번: "
					+ job3.getDescription() + "!!! </h1>");
		}
		
		
		out.close();
	}
		
}
