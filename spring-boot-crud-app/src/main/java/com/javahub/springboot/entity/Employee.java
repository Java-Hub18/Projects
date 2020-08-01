package com.javahub.springboot.entity;
import java.sql.Timestamp;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "eid", nullable = false, unique = true)
	private String empId;

	@NotNull(message = "Employee FirstName can't be blank.")
	@Size(min = 2, max = 50)
	@Column(name = "firstname", nullable = false)
	private String firstName;

	@NotNull(message = "Employee LastName can't be blank.")
	@Size(min = 2, max = 50)
	@Column(name = "lastname", nullable = false)
	private String lastName;

	@NotNull(message = "Employee Email can't be blank.")
	@Size(min = 10, max = 100)
	@Email(message = "Please Enter Valid Email.")
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@NotNull(message = "Employee Password can't be blank.")
	@Size(max = 60)
	@Column(name = "password", nullable = false)
	private String password;

	@NotNull(message = "Employee Gender can't be blank.")
	@Column(name = "gender", nullable = false)
	private String gender;

	@NotNull(message = "Employee DOB can't be blank.")
	@Past(message = "Please Select Past Date.")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "dob", nullable = false)
	private LocalDate dob;
	

	@NotNull(message = "Employee Department can't be blank.")
	@Size(min = 2, max = 50)
	@Column(name = "department", nullable = false)
	private String department;

	@NotNull(message = "Employee Designation can't be blank.")
	@Size(min = 2, max = 50)
	@Column(name = "designation", nullable = false)
	private String designation;

	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "created_date", nullable = false, updatable = false)
	private Timestamp createdDate;

	public Employee() {

	}

	public Employee(String empId, String firstName, String lastName, String email, String password, String gender,
			LocalDate dob, String department, String designation, Timestamp createdDate) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.department = department;
		this.designation = designation;
		this.createdDate = createdDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Timestamp getCreateDate() {
		return createdDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createdDate = createDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", gender=" + gender + ", dob=" + dob
				+ ", department=" + department + ", designation=" + designation + ", createDate=" + createdDate + "]";
	}

}
