package com.qfedu.pojo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class Classes {
	private Integer id;

	@NotNull
	// 表示name属性的值在5到10之间
	@Length(min = 5, max = 10)
	private String name;

	private Integer tid;

	// 验证必须是数字，并且大小在20到50之间的
	@Range(min = 20, max = 50)
	private Integer size;
	// 已经报名的人数，数据库表中没有此字段，但是可以在复杂查询中为这个属性赋值
	private Integer count;

	// 课程的讲师的名字
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + ", tid=" + tid + ", size=" + size + ", count=" + count
				+ ", username=" + username + "]";
	}

}