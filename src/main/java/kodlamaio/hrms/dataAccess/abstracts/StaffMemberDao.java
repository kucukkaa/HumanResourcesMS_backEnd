package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.StaffMember;

public interface StaffMemberDao extends JpaRepository<StaffMember, Integer> {

}
