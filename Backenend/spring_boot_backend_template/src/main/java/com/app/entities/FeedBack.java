package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class FeedBack extends BaseEntity {
	@Column(length=30)
	private String feedBack;

	public FeedBack(String feedBack) {
		super();
		this.feedBack = feedBack;
	}
	
	

}
