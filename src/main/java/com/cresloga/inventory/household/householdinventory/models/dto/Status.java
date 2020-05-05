package com.cresloga.inventory.household.householdinventory.models.dto;

import java.io.Serializable;
import java.util.Objects;

import com.cresloga.inventory.household.householdinventory.exception.ServiceException;

import javax.validation.constraints.*;

/**
 * Error
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-02T11:32:34.017Z[GMT]")
public class Status implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4052449872197050734L;

	private String code = null;

	private String description = null;
	
	protected Status() {
		
	}
	
	protected Status(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public static Status build(Exception e) {
		if (e instanceof ServiceException)
			return new Status(((ServiceException) e).getCode(),((ServiceException) e).getMessage());
		else
			return new Status("500", e.getMessage());
	}

	public Status code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Get code
	 * 
	 * @return code
	 **/
	@NotNull
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Status description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 * 
	 * @return description
	 **/
	@NotNull
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Status error = (Status) o;
		return Objects.equals(this.code, error.code) && Objects.equals(this.description, error.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, description);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Error {\n");

		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
