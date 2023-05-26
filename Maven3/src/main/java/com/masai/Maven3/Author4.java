package com.masai.Maven3;

import jakarta.persistence.*;

@Entity
public class Author4 {
	
	@Id
	private int id;
	private String name;
	private double rating ;
	public Author4(int id, String name, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
	}
	public Author4() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Author4 [id=" + id + ", name=" + name + ", rating=" + rating + "]";
	}
	
	

}
