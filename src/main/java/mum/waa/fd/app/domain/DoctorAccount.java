package mum.waa.fd.app.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import mum.waa.fd.app.util.FamilyDoctorConstants;

@Entity
@Table(name = "DoctorAccount")
public class DoctorAccount extends Account {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int doctorId;

	@NotBlank(message = FamilyDoctorConstants.EMPTY_VALIDATION)
	@Column(name = "LICENSE_NUMBER")
	private String licenseNumber;

	@NotNull
	@Column(name = "SPECIALIZATION")
	private Specialization specialization;

	@Valid
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "DOCTOR_ID")
	private List<Appointment> appointmentList;

	public DoctorAccount(String firstName, String lastName, String phone, String email, String password,
			Address address, String licenseNumber, Specialization specialization) {
		super(firstName, lastName, phone, email, password, address);
		this.licenseNumber = licenseNumber;
		this.specialization = specialization;
		appointmentList = new ArrayList<Appointment>();
	}

	/**
	 * @return the doctorId
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * @param doctorId
	 *            the doctorId to set
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * @return the licenseNumber
	 */
	public String getLicenseNumber() {
		return licenseNumber;
	}

	/**
	 * @param licenseNumber
	 *            the licenseNumber to set
	 */
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	/**
	 * @return the specialization
	 */
	public Specialization getSpecialization() {
		return specialization;
	}

	/**
	 * @param specialization
	 *            the specialization to set
	 */
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	/**
	 * @return the appointmentList
	 */
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	/**
	 * @param appointmentList
	 *            the appointmentList to set
	 */
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
}
