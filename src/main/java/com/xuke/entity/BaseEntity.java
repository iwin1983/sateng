package com.xuke.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.xuke.util.TimeUtil;

@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	protected String objectId;

	protected String createAt;

	protected String updateAt;

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}
	
	public void initDate()
	{
		this.setCreateAt(TimeUtil.getCurrentTime());
		this.setUpdateAt(TimeUtil.getCurrentTime());
	}
	
	public void updateDate(){
		this.setUpdateAt(TimeUtil.getCurrentTime());
	}
}
