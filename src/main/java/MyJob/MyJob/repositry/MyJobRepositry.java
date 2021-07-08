package MyJob.MyJob.repositry;

import org.springframework.data.repository.CrudRepository;

import MyJob.MyJob.Entity.MyJobEntity;

public interface MyJobRepositry extends CrudRepository<MyJobEntity, Long> {

}
