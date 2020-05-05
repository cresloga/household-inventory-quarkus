package com.cresloga.inventory.household.householdinventory.models.dto;

import java.util.Objects;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Item
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-02T11:32:34.017Z[GMT]")
public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8151401436897147968L;

	private Long id = null;

	private String name = null;

	private BigDecimal quantity = null;

	public Item id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the item
	 * 
	 * @return name
	 **/
	@NotNull
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item quantity(BigDecimal quantity) {
		this.quantity = quantity;
		return this;
	}

	/**
	 * Quantities in Kg
	 * 
	 * @return quantity
	 **/
	@NotNull
	@Valid
	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Item item = (Item) o;
		return Objects.equals(this.id, item.id) && Objects.equals(this.name, item.name)
				&& Objects.equals(this.quantity, item.quantity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, quantity);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");

		sb.append("    id: ").append(toIndentedString(id)).append(",");
		sb.append("    name: ").append(toIndentedString(name)).append(",");
		sb.append("    quantity: ").append(toIndentedString(quantity)).append("");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
