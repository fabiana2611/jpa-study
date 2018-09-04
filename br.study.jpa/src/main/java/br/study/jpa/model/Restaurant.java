package br.study.jpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity to represent restaurants
 * 
 * @author fabiana.araujo
 *
 */
@Entity
@Table(name = "RESTAURANTS")
public class Restaurant {

	@Id
	@GeneratedValue (strategy  = GenerationType.SEQUENCE)
	@Column(name = "restaurant_id")
	private Integer id;
	
	private String name;
	
	private String address;
	
	private String email;
	
	@OneToMany (cascade = CascadeType.PERSIST)
	private List<Product> products;
	
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<JobOpportunity> opportunities;
	
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> orders;
	

	// --- Getters && Setters ----
	
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
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	// --- Equals && Hashcode ----
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<JobOpportunity> getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(List<JobOpportunity> opportunities) {
		this.opportunities = opportunities;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        if (!address.equals(that.address)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + id.intValue();
        return result;
    }
	
}
