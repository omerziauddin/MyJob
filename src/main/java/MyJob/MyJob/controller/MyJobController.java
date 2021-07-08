package MyJob.MyJob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MyJob.MyJob.Dao.MyJobDaoRequest;
import MyJob.MyJob.Dao.MyJobDaoResponse;
import MyJob.MyJob.service.MyJobService;
@RequestMapping("/job")
@RestController
public class MyJobController {
  @Autowired
  public MyJobService service;
  // why u have added api here dont do it again 
  @PostMapping
  public MyJobDaoResponse create(@RequestBody MyJobDaoRequest request) throws Exception
  {
	  return service.create(request);
  }
  @DeleteMapping("/All")
  public String deleteAll()
  {
	  service.deleteAll();
	  return "All Deleted successfully";
  }
  
}
