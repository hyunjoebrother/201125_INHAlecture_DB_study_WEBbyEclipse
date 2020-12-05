package examples.dao;

//DAO

// DB에 연결하여 CRUD 작업하는 클래스

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import examples.dto.Job;



public class JobDAO {
	private static String dburl = "jdbc:mysq://localhost/dbdesign?serverTimezone=Asia/Seoul";
	private static String dbUser = "dbuser";
	private static String dbpasswd = "dbuser123!";
	
	
	
	public Job getJob(Integer jobId)
	{
		Job job = null;
		
		// 1. JDBC 드라이버 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		// 2. 질의문 설정
		String sql = "select job_id, description from job where job_id = ?";
		
		// 3. MySQL 연결 및 질의 수행
		// 아래와 같이 try문에 conn, ps를 여는 코드를 넣으면 finally 블럭에서 close를 안해줘도 된다
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql))
						{
					// 4. 질의문 설정 및 ResultSet 처리
					ps.setInt(1, jobId);
					
					try (ResultSet rs = ps.executeQuery())
					{
						if(rs.next())
						{
							int id = rs.getInt(1);
							String description = rs.getString(2);
							job = new Job(id, description);
						}
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
						}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return job;				
	}
	
	
	
	public int addJob(Job job)
	{
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결성공!!!");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		String sql = "insert into job (job_id, description) values (?, ?)";
		
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql))
						{
					ps.setInt(1, job.getJobId());
					ps.setString(2, job.getDescription());
					
					insertCount = ps.executeUpdate();					
					}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return insertCount;			
	}

	
	
	public int deleteJob(Integer jobId)
	{
		int deleteCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		String sql = "delete from job where job_id = ?";
		
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql))
						{
					ps.setInt(1, jobId);
					deleteCount = ps.executeUpdate();					
					}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return deleteCount;			
	}
	
	
	
	public int updateJob(Job job)
	{
		int updateCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		String sql = "update job set description = ? where job_id = ?";
		
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql))
						{
					ps.setString(1, job.getDescription());
					ps.setInt(2, job.getJobId());
					
					updateCount = ps.executeUpdate();					
					}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return updateCount;			
	}
	
	
	// 모든 job들 list로 
	public List<Job> getJobs()
	{
		List<Job> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		String sql = "select description, job_id from job order by job_id, desc"; // 내림차순
		
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql))
						{
					try (ResultSet rs = ps.executeQuery())
					{
						while (rs.next())
						{
							String description = rs.getString(1);
							int id = rs.getInt("job_id");
							Job job = new Job(id, description);
							// list에 반복할 때마다 Job 인스턴트를 생성하여 list에 추가한다.
							list.add(job);
						}
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					
				}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return list;			
	}
}
