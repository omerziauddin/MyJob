package MyJob.MyJob.Dao;

import lombok.Data;

@Data
public class MyJobDaoRequest {
	private String jobTitle;
	private String jobDescription;
	private String languageSupported;
}
