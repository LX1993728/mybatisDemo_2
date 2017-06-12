package test.lx.mybatis.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Orders implements Serializable{
	private Integer id;
	private Integer userId;
	private String number; //商品编号
	
	private Date createtime;
	
	private String note;
	
	//关联用户信息
	private User user;
	
	//订单明细
	private List<OrderDetail> orderDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", number=" + number
				+ ", createtime=" + createtime + ", note=" + note + ", user="
				+ user + ", orderDetails=" + orderDetails + "]";
	}
	
}
