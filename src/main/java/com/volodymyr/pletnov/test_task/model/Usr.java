package com.volodymyr.pletnov.test_task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usr")
public class Usr {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "fio_encr",nullable = false, length = 250)
	private String fioEncr;
}
