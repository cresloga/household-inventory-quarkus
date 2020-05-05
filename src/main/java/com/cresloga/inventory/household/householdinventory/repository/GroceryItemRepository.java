package com.cresloga.inventory.household.householdinventory.repository;

import javax.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import com.cresloga.inventory.household.householdinventory.models.jpa.GroceryItem;


@ApplicationScoped
public class GroceryItemRepository implements PanacheRepository<GroceryItem> {
	
}
