package kodlamaio.hrms.entities.dtos;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateResumeDto {

	private int userId;
	private String firstName;
	private String lastName;
	private String schoolName;	
	private String schoolDepartment;
	private LocalDate schoolStartedDate;
	private LocalDate schoolEndedDate;
	private String companyName;
	private String companyDepartmentName;
	private LocalDate jobStartedDate;
	private LocalDate jobEndedDate;
	private String language;
	private int languageLevel;
	private String progLanguageName;
	private String summary;
	private String github;
	private String linkedin;
	
	
}
