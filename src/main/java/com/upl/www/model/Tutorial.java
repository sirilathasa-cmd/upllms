package com.upl.www.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tutorial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tutorial {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tutorial_id;
	@Column
	private Integer course_id;
	@Column
	private String title;
	@Column
	private String content;
	@Column
	private String youtube_link;
	
	@CreationTimestamp
	@Column
	private LocalDateTime created_at;

}
