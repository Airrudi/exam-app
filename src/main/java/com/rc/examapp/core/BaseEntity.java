package com.rc.examapp.core;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by RC on 31-10-2017.
 */

@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private final Long id;

	protected BaseEntity() {
		id = null;
	}
}
