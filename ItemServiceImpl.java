package com.shop.item.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shop.item.entity.Item;
import com.shop.item.repository.ItemRepository;
import com.shop.item.service.ItemService;
import com.shop.item.service.payload.request.ItemRequest;

@Service
@Qualifier("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item createItem(Item item) {
		Item itemResponse = itemRepository.save(item);
		return itemResponse;
	}
	
	@Override
	public Item updateItem(Item item) {
		Item itemResponse = itemRepository.save(item);
		return itemResponse;
	}
	
	@Override
	public void deleteItem(Long itemId) {
		itemRepository.deleteById(itemId);
	}

	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public List<Item> getAllItemByIdAndName(long itemId, String itemName) {
		return itemRepository.findByItemIdAndItemName(itemId, itemName);
	}


}
