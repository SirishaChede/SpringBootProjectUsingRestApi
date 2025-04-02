package com.example.demo.RestAPI.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Books_api")
public class BookEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookid;
	private String BookName;
	private String Author;
	private int price;

}
