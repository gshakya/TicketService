package com.TicketService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TicketService.Model.Staff;

@Repository
public interface IStaffRepository extends JpaRepository<Staff, Long>{
	
	@Query("select s from Staff s where s.name like %:name%")
	public List<Staff> findByNameLike(@Param("name") String name);
	
	@Query("select s from Staff s where s.email like %:email%")
	public List<Staff> findByEmailLike(String email);
	
	@Query("Select s from Staff s where s.name like %:name% and s.email like %:email%")
	public List<Staff> findStaffByNameAndEmail(String name , String email);
	
	@Query("select s from Staff s where s.id =:id")
	public Staff findById(@Param("id") long id);
	
	@Query("Delete from Staff where id = :id")
	public Long deleteById(@Param("id")Long id);
	
	@Modifying
	@Query("Update Staff Set name =:name, address =:address, email =:email where id =:id")
	public void updateById(@Param("id")long id, @Param("name")String name, @Param("address")String address, @Param("email")String email);
	
	@Query(value="Insert into Staff (name, address, email) Values(:name, :address, :email)", nativeQuery=true)
    public void add(@Param("name")String name, @Param("address")String address, @Param("email")String email);
}
