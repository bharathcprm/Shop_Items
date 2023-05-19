package com.shop.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.item.entity.Item;
import com.shop.item.service.ItemService;
import com.shop.item.service.payload.request.ItemRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
@Api(tags = "Shop Item Restful Services")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@ApiOperation(value = "Get all the items from the shop")
	@GetMapping("items")
	public ResponseEntity<List<Item>> getAllItems() {

		List<Item> itemList = itemService.getAllItems();
		return new ResponseEntity<>(itemList, HttpStatus.OK);
	}

	@ApiOperation(value = "Get items filter by itemid and ItemName from the shop")
	@GetMapping("item/{itemId}/{itemName}")
	public ResponseEntity<List<Item>> getAllItemByIdAndName(@PathVariable long itemId, @PathVariable String itemName) {

		List<Item> itemList = itemService.getAllItemByIdAndName(itemId, itemName);
		return new ResponseEntity<>(itemList, HttpStatus.OK);
	}

	@ApiOperation(value = "Create items in the shop")
	@PostMapping("item/create")
	public ResponseEntity<String> createItem(@RequestBody ItemRequest itemRequest) {

		Item item = new Item();
		item.setItemId(itemRequest.getItemId());
		item.setItemName(itemRequest.getItemName());
		Item itemResponse = itemService.createItem(item);
		return new ResponseEntity<>("Item Created Successfully : " + itemResponse.getItemName(), HttpStatus.CREATED);
	}
	

	@ApiOperation(value = "Update item for specific item")
	@PutMapping("item/update")
	public ResponseEntity<String> updateItem(@RequestBody ItemRequest itemRequest) {

		Item item = new Item();
		item.setItemId(itemRequest.getItemId());
		item.setItemName(itemRequest.getItemName());
		Item itemResponse = itemService.updateItem(item);
		return new ResponseEntity<>("Item updated Successfully : " + itemResponse.getItemName(), HttpStatus.OK);
	}

	@ApiOperation(value = "Delete item for specific item")
	@DeleteMapping("item/delete/{itemId}")
	public ResponseEntity<String> deleteItem(@PathVariable Long itemId) {
		itemService.deleteItem(itemId);
		return new ResponseEntity<>("Item Deleted Successfully : " + itemId, HttpStatus.OK);
	}

}
