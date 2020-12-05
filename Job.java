package examples.dto;

// DTO

// data 전달 단위, 순수한 data object (캡슐화된 object)
// 멤버변수로만 구성
// column을 멤버변수로 처리
// 멤버변수는 private으로. public getter/setter 필수

public class Job {
	private Integer jobId;
	private String description;
	// 멤버변수 작성하면 생성자, getter, setter,  toString 함수 source 자동 작성된다


	
	// 생성자 constructor
	public Job(Integer jobId, String description) {
		super();
		this.jobId = jobId;
		this.description = description;
	}

	
	
	// 각 멤버변수 별로 getter/setter
	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	// toString()
	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", description=" + description + "]";
	}
	
}

