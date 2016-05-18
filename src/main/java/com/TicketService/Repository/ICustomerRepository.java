package com.TicketService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TicketService.Model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

	@Query("select c from Customer c  join c.userInfo i where i.username=:username")
	public Customer findCustomerByUserName(@Param("username") String userName);

	@Query("select c from Customer c where c.name like %:name%")
	public List<Customer> findByNameLike(@Param("name") String name);

	@Query("select c from Customer c where c.email like %:email%")
	public List<Customer> findByEmailLike(@Param("email") String email);

	@Query("Select c from Customer c where c.name like %:name% and c.email like %:email%")
	public List<Customer> findCustomerByNameAndEmail(@Param("name") String name, @Param("email") String email);

	@Query("select c from Customer c where c.id =:id")
	public Customer findById(@Param("id") long id);

	@Query("Delete from Customer where id = :id")
	public Long deleteById(@Param("id") Long id);

	@Modifying
	@Query("Update Customer Set name =:name, address =:address, email =:email where id =:id")
	public void updateById(@Param("id") long id, @Param("name") String name, @Param("address") String address,
			@Param("email") String email);

	@Query(value = "Insert into Customer (name, address, email) Values(:name, :address, :email)", nativeQuery = true)
	public void add(@Param("name") String name, @Param("address") String address, @Param("email") String email);
}