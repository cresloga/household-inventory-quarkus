package com.cresloga.inventory.household.householdinventory.controller;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.inject.Inject;

import com.cresloga.inventory.household.householdinventory.api.GroceryV1Api;
import com.cresloga.inventory.household.householdinventory.models.dto.GetAllResponse;
import com.cresloga.inventory.household.householdinventory.models.dto.GetResponse;
import com.cresloga.inventory.household.householdinventory.models.dto.Item;
import com.cresloga.inventory.household.householdinventory.models.dto.Items;
import com.cresloga.inventory.household.householdinventory.models.dto.Status;
import com.cresloga.inventory.household.householdinventory.service.GroceryService;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-02T11:32:34.017Z[GMT]")
public class GroceryV1ApiController implements GroceryV1Api {

	private static final Logger log = LoggerFactory.getLogger(GroceryV1ApiController.class);

	@Inject
	private GroceryService service;

	@Context
	UriInfo info;

	public Response createV1(Item body) {
		try {
			Long id = service.create(body);
			return Response.created(UriBuilder.fromPath("/").path(info.getPath()).path("{id}").build(id)).build();
		} catch (Exception e) {
			log.error("Error while adding the item: ", e);
			return Response.serverError().entity(Status.build(e)).build();
		}
	}

	public Response deleteByIdV1(@PathParam("id") Long id) {
		try {
			service.deleteById(id);
			return Response.noContent().build();
		} catch (Exception e) {
			log.error("Error while deleting item by id: {} : {}", id, e);
			return Response.serverError().entity(Status.build(e)).build();
		}

	}

	public Response getAllV1() {
		try {
			Items items = service.getAll();
			return Response.ok(GetAllResponse.build(items)).build();
		} catch (Exception e) {
			log.error("Error while listing all items: ", e);
			return Response.serverError().entity(GetAllResponse.build(e)).build();
		}
	}

	public Response getByIdV1(@PathParam("id") Long id) {
		try {
			Item item = service.getById(id);
			return Response.ok(GetResponse.build(item)).build();
		} catch (Exception e) {
			log.error("Error while fetching item by id: {} : {}", id, e);
			return Response.serverError().entity(GetResponse.build(e)).build();
		}
	}

	public Response replaceByIdV1(@PathParam("id") Long id, Item body) {
		try {
			service.replaceById(id, body);
			return Response.noContent().build();
		} catch (Exception e) {
			log.error("Error while replacing item by id: {} : {}", id, e);
			return Response.serverError().entity(Status.build(e)).build();
		}
	}

	public Response updateByIdV1(@PathParam("id") Long id, @PathParam("quantity") BigDecimal quantity) {
		try {
			service.updateById(id, quantity);
			return Response.noContent().build();
		} catch (Exception e) {
			log.error("Error while updating item by id: {} : {}", id, e);
			return Response.serverError().entity(Status.build(e)).build();
		}
	}
}
