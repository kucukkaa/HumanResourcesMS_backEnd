package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="user_id")
@AllArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
@NoArgsConstructor
public class Candidate extends User {

	
	
	//@Column(name="user_id")
	//private int userId;
	
	@Column(name="first_name")
	private String firstName;
	
	
	@Column(name="last_name")
	private String lastName;	
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;	
	
	@Column(name="citizen_id")
	private String citizenId;	
	
	@Column(name="is_email_ok")
	private boolean isEmailOk = false;	
	
	@OneToMany(mappedBy="candidate")
	@JsonIgnore
	private List<CandidateResume> candidateResume;
}
