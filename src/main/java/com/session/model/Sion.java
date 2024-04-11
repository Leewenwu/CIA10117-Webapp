package com.session.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reserve_session")
public class Sion {
	@Id
	@Column(name = "reserve_session_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sionId;

	@Column(name = "reserve_max_part")
	private Integer max = 100;

	@Column(name = "session_time")
	private String time;

	public Integer getSionId() {
		return sionId;
	}

	public Sion(Integer sionId, Integer max, String time) {
		super();
		this.sionId = sionId;
		this.max = max;
		this.time = time;
	}

	public void setSionId(Integer sionId) {
		this.sionId = sionId;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Sion() {
		super();
		// TODO Auto-generated constructor stub
	}
}
