package MyJob.MyJob.Dao;

import lombok.Data;

@Data
public class MyJobDaoResponse {
	private Long id;
	private String jobTitle;
	private String jobDescription;
	private String languageSupported;
	private String exceptionInfo;
}
