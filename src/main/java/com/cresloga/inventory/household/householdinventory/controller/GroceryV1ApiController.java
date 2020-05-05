package com.cresloga.inventory.household.householdinventory.controller;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.ws.rs.PathParam;
import javax.inject.Inject;

import com.cresloga.inventory.household.householdinventory.api.GroceryV1Api;
import com.cresloga.inventory.household.householdinventory.models.dto.GetAllResponse;
import com.cresloga.inventory.household.householdinventory.models.dto.GetResponse;
import com.cresloga.inventory.household.householdinventory.models.dto.Item;
import com.cresloga.inventory.household.householdinventory.models.dto.Items;
import com.cresloga.inventory.household.householdinventory.service.GroceryService;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-02T11:32:34.017Z[GMT]")
public class GroceryV1ApiController implements GroceryV1Api {

	private static final Logger log = LoggerFactory.getLogger(GroceryV1ApiController.class);

	@Inject
	private GroceryService service;

	public void createV1(Item body) {
		service.create(body);
	}

	public void deleteByIdV1(@PathParam("id") Long id) {
		service.deleteById(id);
	}

	public GetAllResponse getAllV1() {
		try {
			Items items = service.getAll();
			return GetAllResponse.build(items);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return GetAllResponse.build(e);
		}
	}

	public GetResponse getByIdV1(@PathParam("id") Long id) {
		try {
			Item item = service.getById(id);
			return GetResponse.build(item);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return GetResponse.build(e);
		}
	}

	public void replaceByIdV1(@PathParam("id") Long id, Item body) {
		service.replaceById(id, body);
	}

	public void updateByIdV1(@PathParam("id") Long id, @PathParam("quantity") BigDecimal quantity) {
		service.updateById(id, quantity);
	}
}
