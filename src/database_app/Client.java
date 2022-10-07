/**
 * 
 */
package database_app;

import java.math.BigDecimal;

/**
 * @author maubeeluck
 *
 */
public class Client {
    long id;
    String name;
    BigDecimal amountDue;
    
	public Client(long id, String name, BigDecimal amountDue) {
		super();
		this.id = id;
		this.name = name;
		this.amountDue = amountDue;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}

	@Override
	public String toString() {
		return "Client [client_id=" + id + ", client_name=" + name + ", client_amountDue=" + amountDue + "]";
	}
	

}
