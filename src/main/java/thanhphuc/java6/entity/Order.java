package thanhphuc.java6.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="Orders")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Order_id")
	private int id;
	
	@Column(name="Order_date")
	@Temporal(TemporalType.DATE)
	private Date date = new Date();
	
	@Column(name="total")
	private double total;
	
//	X: Dang xu li, N: Da nhan hang, H:Huy
	@Column(name="status")
	private String status;
	
	@Column(name="province")
	private String province;
	
	@Column(name="district")
	private String district;
	
	@Column(name="ward")
	private String ward;
	
	@Column(name="payment")
	private int payment;
	
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	List<OrderDetail> orderDetails;
	
	@ManyToOne
	@JoinColumn(name="username")
	Account account;
}
