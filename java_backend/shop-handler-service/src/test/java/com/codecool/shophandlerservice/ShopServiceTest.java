package com.codecool.shophandlerservice;

import com.codecool.shophandlerservice.entity.Item;
import com.codecool.shophandlerservice.repository.ItemRepository;
import com.codecool.shophandlerservice.service.ShopService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ShopServiceTest {

	@Autowired
	private ShopService shopService;

	@Autowired
	private ItemRepository itemRepository;

	@Test
	void addItemToShopByCharacterIdAndCharacterLevelIsSaving() {
		shopService.addItemToShopByCharacterIdAndCharacterLevel(1L,10L);
		int size=itemRepository.findAll().size();

		assertThat(size).isEqualTo(1);
		itemRepository.deleteAll();

	}

	@Test
	void addItemToShopByCharacterIdAndCharacterLevelIsSavingMultipleTimes() {
		shopService.addItemToShopByCharacterIdAndCharacterLevel(1L,1L);
		shopService.addItemToShopByCharacterIdAndCharacterLevel(1L,5L);
		shopService.addItemToShopByCharacterIdAndCharacterLevel(3L,1L);

		int size=itemRepository.findAll().size();

		assertThat(size).isEqualTo(3);
		itemRepository.deleteAll();

	}
	@Test
	void addItemToShopByCharacterIdAndCharacterLevelItemIdIsNotNull() {
		shopService.addItemToShopByCharacterIdAndCharacterLevel(1L,1L);

		Item item=itemRepository.findAll().get(0);

		assertThat(item.getId()).isNotNull();
		itemRepository.deleteAll();

	}

	@Test
	void addItemToShopByCharacterIdAndCharacterLevelCharacterIdIsNotNull() {
		shopService.addItemToShopByCharacterIdAndCharacterLevel(1L,1L);

		Item item=itemRepository.findAll().get(0);

		assertThat(item.getCharacterId()).isNotNull();
		itemRepository.deleteAll();

	}

	@Test
	void addItemToShopByCharacterIdAndCharacterLevelCharacterIdIsEqualsToParameter() {
		shopService.addItemToShopByCharacterIdAndCharacterLevel(1L,1L);

		Item item=itemRepository.findAll().get(0);

		assertThat(item.getCharacterId()).isEqualTo(1);
		itemRepository.deleteAll();

	}

	@ParameterizedTest
	@ValueSource(longs = {1, 1, 5, 3, 7})
	void addItemToShopByCharacterIdAndCharacterLevelCharacterIdsAreEqualsToParameters(Long characterId) {
		shopService.addItemToShopByCharacterIdAndCharacterLevel(characterId,1L);

		int iteration=itemRepository.findAll().size()-1;
		Item item=itemRepository.findAll().get(iteration);

		assertThat(item.getCharacterId()).isEqualTo(characterId);
		itemRepository.deleteAll();

	}


	@Test
	void getItemsByCharacterIdIsEmpty() {

		List<Item> items=itemRepository.findAllByCharacterId(1L);

		assertThat(items).isEmpty();
	}

	@Test
	void getItemsByCharacterIdIsNotEmpty() {
		itemRepository.save(Item.builder().characterId(1L).build());
		List<Item> items=itemRepository.findAllByCharacterId(1L);

		assertThat(items).isNotEmpty();
		itemRepository.deleteAll();

	}

	@Test
	void getItemsByCharacterIdFindEveryElement() {
		itemRepository.save(Item.builder().characterId(1L).build());
		itemRepository.save(Item.builder().characterId(1L).build());
		itemRepository.save(Item.builder().characterId(1L).build());

		List<Item> items=itemRepository.findAllByCharacterId(1L);
		int size=items.size();

		assertThat(size).isEqualTo(3);
		itemRepository.deleteAll();

	}

	@Test
	void getItemsByCharacterIdSFindEveryRelevantElement() {
		itemRepository.save(Item.builder().characterId(1L).build());
		itemRepository.save(Item.builder().characterId(2L).build());
		itemRepository.save(Item.builder().characterId(1L).build());
		itemRepository.save(Item.builder().characterId(10L).build());


		List<Item> items=itemRepository.findAllByCharacterId(1L);
		int size=items.size();

		assertThat(size).isEqualTo(2);
		itemRepository.deleteAll();
	}


	@Test
	void addMultipleItemsToShopByCharacterIdAndCharacterLevelIsSaving() {
		shopService.addMultipleItemsToShopByCharacterIdAndCharacterLevel(1L,1L,1L);
		int size=itemRepository.findAll().size();

		assertThat(size).isEqualTo(1);
		itemRepository.deleteAll();

	}

	@ParameterizedTest
	@ValueSource(longs = {1, 2, 5, 10, 100})
	void addMultipleItemsToShopByCharacterIdAndCharacterLevelIsSaving(Long param) {
		shopService.addMultipleItemsToShopByCharacterIdAndCharacterLevel(1L,1L,param);
		int size=itemRepository.findAll().size();

		assertThat(size).isEqualTo(Integer.valueOf(Math.toIntExact(param)));
		itemRepository.deleteAll();

	}

	@ParameterizedTest
	@ValueSource(longs = {0, -1, -2, -10, Long.MIN_VALUE})
	void addItemToShopByCharacterIdAndCharacterLevelBadParamsThrowsException1(Long param) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> shopService.addItemToShopByCharacterIdAndCharacterLevel(1L,param));
	}

	@ParameterizedTest
	@ValueSource(longs = {0, -1, -2, -10, Long.MIN_VALUE})
	void addItemToShopByCharacterIdAndCharacterLevelBadParamsThrowsException2(Long param) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> shopService.addItemToShopByCharacterIdAndCharacterLevel(param,1L));
	}

	@ParameterizedTest
	@ValueSource(longs = {0, -1, -2, -10, Long.MIN_VALUE})
	void addItemToShopByCharacterIdAndCharacterLevelBadParamsThrowsException3(Long param) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> shopService.addItemToShopByCharacterIdAndCharacterLevel(param,param));
	}


	@ParameterizedTest
	@ValueSource(longs = {0, -1, -2, -10, Long.MIN_VALUE})
	void addMultipleItemsToShopByCharacterIdAndCharacterLevelBadParamsThrowsException1(Long param) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> shopService.addMultipleItemsToShopByCharacterIdAndCharacterLevel(param,1L,1L));
	}
	@ParameterizedTest
	@ValueSource(longs = {0, -1, -2, -10, Long.MIN_VALUE})
	void addMultipleItemsToShopByCharacterIdAndCharacterLevelBadParamsThrowsException2(Long param) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> shopService.addMultipleItemsToShopByCharacterIdAndCharacterLevel(1L,param,1L));
	}
	@ParameterizedTest
	@ValueSource(longs = {0, -1, -2, -10, Long.MIN_VALUE})
	void addMultipleItemsToShopByCharacterIdAndCharacterLevelBadParamsThrowsException3(Long param) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> shopService.addMultipleItemsToShopByCharacterIdAndCharacterLevel(1L,1L,param));
	}






}
