package MyJob.MyJob.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="job")
public class MyJobEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String jobTitle;
private String jobDescription;
private String languageSupported;
private String exceptionInfo;
}
