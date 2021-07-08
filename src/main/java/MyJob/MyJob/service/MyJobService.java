package MyJob.MyJob.service;

import org.apache.tika.language.LanguageIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MyJob.MyJob.Dao.MyJobDaoRequest;
import MyJob.MyJob.Dao.MyJobDaoResponse;
import MyJob.MyJob.Entity.MyJobEntity;
import MyJob.MyJob.repositry.MyJobRepositry;
@Service
public class MyJobService {
	@Autowired
	public MyJobRepositry myJobRepositry;
	
	public MyJobDaoResponse create(MyJobDaoRequest request) throws Exception {
		MyJobEntity job=new MyJobEntity();
		job.setJobTitle(request.getJobTitle());
		job.setJobDescription(request.getJobDescription());
		job.setLanguageSupported(request.getLanguageSupported());
		
		String language=languageDetection(job.getJobDescription());
	 try {
		if(language.equalsIgnoreCase(job.getLanguageSupported()))
		{   job.setExceptionInfo("No exception");
		    job=myJobRepositry.save(job);
		    return toResponse(job);
		}
		
		else
			throw new Exception("Language Not Supported");
	 }
	 catch(Exception e)
	 {
		 job.setExceptionInfo("Language Not supported");
		 return toResponse(job);
	 }
	
		
	}
	private String languageDetection(String jobDescription) {
		LanguageIdentifier identifier = new LanguageIdentifier(jobDescription);
	     String language = identifier.getLanguage();
		return language;
	}

	public MyJobDaoResponse toResponse(MyJobEntity job) {
		
		MyJobDaoResponse response=new MyJobDaoResponse();
		response.setId(job.getId());
		response.setJobTitle(job.getJobTitle());
		response.setJobDescription(job.getJobDescription());
		response.setLanguageSupported(job.getLanguageSupported());
		response.setExceptionInfo(job.getExceptionInfo());
		
		return response;
		
		
	}

	public void deleteAll() {
		myJobRepositry.deleteAll();
		
	}

	
}
