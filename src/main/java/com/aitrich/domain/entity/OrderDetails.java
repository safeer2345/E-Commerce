package com.aitrich.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(/*fetch = FetchType.EAGER ,cascade = CascadeType.ALL */)
	@JoinColumn(name = "order_id" , nullable = true)
	@JsonIgnore
	private OrderEntity order;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "product_id")
	@JsonIgnore
	private Product product;

	private int quantity;

	public OrderDetails() {
		super();
	}

	public OrderDetails(long id, Product product, int quantity) {
		super();
		this.id = id;

		this.product = product;
		this.quantity = quantity;
	}

//	@PreRemove
//	protected void preRemover() {
//		System.out.println("entered");
//		this.order.removeOrderDetail(this);
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
		// order.getOrderDetails().add(this);
		// this.setOrder(order);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

//	  @Override
//	    public boolean equals(Object o) {
//	        if (this == o) return true;
//	        if (!(o instanceof OrderDetails )) return false;
//	        return id != 0 && id==((OrderDetails) o).getId();
//	    }

//	@Override
//	public int hashCode() {
//		return getClass().hashCode();
//	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", product=" + product + ", quantity=" + quantity + "]";
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (int) (id ^ (id >>> 32));
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		if (id != other.id)
			return false;
		return true;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((order == null) ? 0 : order.hashCode());
//		return result;
//	}

//	public boolean equals(Object object) {
//		if (object == this)
//			return true;
//		if ((object == null) || !(object instanceof OrderDetails))
//			return false;
//		final OrderDetails orderDetails = (OrderDetails) object;
//		if (id != null && orderDetails.getId() != null) {
//			return id.equals(a.getId());
//		}
//		return false;
//
//	}
	
	

}
