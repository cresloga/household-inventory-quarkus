package com.cresloga.inventory.household.householdinventory.models.dto;

import java.io.Serializable;
import java.util.Objects;

import com.cresloga.inventory.household.householdinventory.exception.ServiceException;
import javax.validation.Valid;

/**
 * InlineResponse200
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-02T13:25:21.110Z[GMT]")
public class GetAllResponse extends Status implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6388528364950149033L;
	private Items items;

	public static GetAllResponse build(Items items) {
		GetAllResponse response = new GetAllResponse();
		response.setItems(items);
		response.setStatus("OK", "Found Match");
		return response;
	}

	public static GetAllResponse build(Exception e) {
		GetAllResponse response = new GetAllResponse();
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

	public GetAllResponse items(Items items) {
		this.items = items;
		return this;
	}

	/**
	 * Get items
	 * 
	 * @return items
	 **/
	@Valid
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GetAllResponse inlineResponse200 = (GetAllResponse) o;
		return Objects.equals(this.items, inlineResponse200.items) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(items, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class InlineResponse200 {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    items: ").append(toIndentedString(items)).append("\n");
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
