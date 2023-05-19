package com.shop.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.item.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

	List<Item> findByItemIdAndItemName(long itemId, String itemName);
}
