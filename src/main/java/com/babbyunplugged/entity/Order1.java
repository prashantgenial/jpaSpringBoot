package com.babbyunplugged.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Order1 {

	@Id
	@GeneratedValue
	private Long id ;
	private String description ;
	
	
	@CreationTimestamp
	private LocalDateTime createdDate ;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate ;
	
	@OneToMany(mappedBy="order")
	private List<Note> notes = new ArrayList<>();
	
	public Order1() {}

	public Order1(String description) {
		super();
		this.description = description;
	}

	public List<Note> getNotes() {
		return notes;
	}
	
	public void addNotes(Note note) {
		this.notes.add(note);
	}
	
	public void removeNotes(Note note) {
		this.notes.remove(note);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", description=" + description + ", createdDate=" + createdDate
				+ ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}
	
	

}
