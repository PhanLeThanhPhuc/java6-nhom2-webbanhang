package thanhphuc.java6.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class OrderDetailDTO {

	@Id
	private int id;

	private String productName;

	private String img;

	private double price;

	private int qty;

	
}
