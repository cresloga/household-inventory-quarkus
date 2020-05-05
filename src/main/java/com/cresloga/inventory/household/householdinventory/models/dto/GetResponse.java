package com.cresloga.inventory.household.householdinventory.models.dto;

import java.io.Serializable;
import java.util.Objects;

import com.cresloga.inventory.household.householdinventory.exception.ServiceException;
import javax.validation.Valid;

/**
 * InlineResponse2001
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-02T13:25:21.110Z[GMT]")
public class GetResponse extends Status implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1666075968467171573L;
	private Item item;

	public static GetResponse build(Item item) {
		GetResponse response = new GetResponse();
		response.setItem(item);
		response.setStatus("OK", "Found Match");
		return response;
	}

	public static GetResponse build(Exception e) {
		GetResponse response = new GetResponse();
		if (e instanceof ServiceException)
			response.setStatus(((ServiceException) e).getCode(), ((ServiceException) e).getMessage());
		else
			response.setStatus("500", e.getMessage());
		return response;
	}

	public void setStatus(String code, String desc) {
		this.setCode(code);
		this.setDescription(desc);
	}

	public GetResponse item(Item item) {
		this.item = item;
		return this;
	}

	/**
	 * Get item
	 * 
	 * @return item
	 **/
	@Valid
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GetResponse inlineResponse2001 = (GetResponse) o;
		return Objects.equals(this.item, inlineResponse2001.item) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(item, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class InlineResponse2001 {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    item: ").append(toIndentedString(item)).append("\n");
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
