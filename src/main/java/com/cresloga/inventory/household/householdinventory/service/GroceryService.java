package com.cresloga.inventory.household.householdinventory.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cresloga.inventory.household.householdinventory.constants.StatusCode;
import com.cresloga.inventory.household.householdinventory.exception.ServiceException;
import com.cresloga.inventory.household.householdinventory.models.dto.Item;
import com.cresloga.inventory.household.householdinventory.models.dto.Items;
import com.cresloga.inventory.household.householdinventory.models.jpa.GroceryItem;
import com.cresloga.inventory.household.householdinventory.repository.GroceryItemRepository;

@ApplicationScoped
public class GroceryService {
	
	private static final Logger log = LoggerFactory.getLogger(GroceryService.class);

	@Inject
	private GroceryItemRepository repository;
	
	public Items getAll() {
		Items items = new Items();
		List<GroceryItem> groceryItems = repository.listAll();
		if (groceryItems!=null && groceryItems.size() < 1) {
			throw new ServiceException(StatusCode.NOT_FOUND.getCode(), StatusCode.NOT_FOUND.getDesc());
		}
		groceryItems.stream().forEach(groceryItem -> {
			Item item = new Item();
			try {
				BeanUtils.copyProperties(item, groceryItem);
			} catch (IllegalAccessException | InvocationTargetException e) {
				log.error("Exception copying properties from entity to dto: {}", e);
			}
			items.add(item);
		});
		return items;
	}
	
	public Item getById(Long id) {
		Item item = new Item();
		GroceryItem groceryItem = repository.findById(id);
		try {
			BeanUtils.copyProperties(item, groceryItem);
		} catch (IllegalAccessException | InvocationTargetException e) {
			log.error("Exception copying properties from entity to dto: {}", e);
		}
		return item;
	}

	@Transactional
	public void create(Item item) {
		GroceryItem groceryItem = new GroceryItem();
		try {
			BeanUtils.copyProperties(groceryItem, item);
		} catch (IllegalAccessException | InvocationTargetException e) {
			log.error("Exception copying properties from dto to entity: {}", e);
		}
		repository.persist(groceryItem);
	}

	@Transactional
	public void deleteById(Long id) {
		GroceryItem groceryItem = repository.findById(id);
		repository.delete(groceryItem);
	}

	@Transactional
	public void replaceById(Long id, Item item) {
		GroceryItem groceryItem = repository.findById(id);
		item.setId(id);
		try {
			BeanUtils.copyProperties(groceryItem, item);
		} catch (IllegalAccessException | InvocationTargetException e) {
			log.error("Exception copying properties from dto to entity: {}", e);
		}
		repository.persist(groceryItem);
	}

	@Transactional
	public void updateById(Long id, BigDecimal quantity) {
		GroceryItem groceryItem = repository.findById(id);
		groceryItem.setQuantity(quantity);
		repository.persist(groceryItem);
	}
	
}
