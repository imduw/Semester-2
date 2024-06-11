package common.model;



import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "orders")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;
	
	@Column(name = "Creator")
	private String Creator;
	
	@Column(name = "Total")
	private Integer Total;
	
	@Column(name = "Date")
	private Date Date;
	
	public Order(Integer iD, String creator, Integer total, Date date) {		
		this.ID = iD;
		this.Creator = creator;
		this.Total = total;
		this.Date = date;
	}
	public Order() {
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getCreator() {
		return Creator;
	}
	public void setCreator(String creator) {
		Creator = creator;
	}
	public Integer getTotal() {
		return Total;
	}
	public void setTotal(Integer total) {
		Total = total;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	
	
	
}
