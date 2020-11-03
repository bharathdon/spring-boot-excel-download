package com.abc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tutorial")
public class Tutorial {

	@Id
	private Integer id;
	private String description;
	private String title;
	private Boolean published;
}
