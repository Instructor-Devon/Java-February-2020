package org.worldwidedev.sup.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="weddings")
public class Wedding {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String bride;
	@NotBlank
	private String groom;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Future
	private Date date;
	private String address;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User planner;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="rsvps",
		joinColumns = @JoinColumn(name="wedding_id"),
		inverseJoinColumns = @JoinColumn(name="user_id")
	)
	private List<User> guests;
	
	public Wedding() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBride() {
		return bride;
	}
	public void setBride(String bride) {
		this.bride = bride;
	}
	public String getGroom() {
		return groom;
	}
	public void setGroom(String groom) {
		this.groom = groom;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User getPlanner() {
		return planner;
	}
	public void setPlanner(User planner) {
		this.planner = planner;
	}
	public List<User> getGuests() {
		return guests;
	}
	public void setGuests(List<User> guests) {
		this.guests = guests;
	}
	
}
