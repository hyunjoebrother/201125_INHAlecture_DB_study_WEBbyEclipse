package examples.dto;

// DTO

// data ���� ����, ������ data object (ĸ��ȭ�� object)
// ��������θ� ����
// column�� ��������� ó��
// ��������� private����. public getter/setter �ʼ�

public class Job {
	private Integer jobId;
	private String description;
	// ������� �ۼ��ϸ� ������, getter, setter,  toString �Լ� source �ڵ� �ۼ��ȴ�


	
	// ������ constructor
	public Job(Integer jobId, String description) {
		super();
		this.jobId = jobId;
		this.description = description;
	}

	
	
	// �� ������� ���� getter/setter
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

