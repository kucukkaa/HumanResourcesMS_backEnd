package kodlamaio.hrms.entities.concretes;

import java.io.File;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidate_resumes")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_image")
	private String userImage;
	
	@Column(name="github")
	private String github;
	
	@Column(name="linkedin")
	private String linkedin;
	
	@Column(name="summary")
	private String summary;
	
	@Column(name="prog_lang_knowledge")
	private String programmingLanguageKnowlege;
	
	//@Column(name="user_id")
	//private int userId;	
	
	@OneToMany(mappedBy="candidateResume")
	private List<CandidateSchool> candidateSchool;
	
	@OneToMany(mappedBy="candidateResume")
	private List<JobExperience> jobExperience;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	//@JsonIgnore
	private Candidate candidate;
	
	@OneToMany(mappedBy="candidateResume")
	private List<Language> language;
}
