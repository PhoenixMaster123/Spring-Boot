package main.service;

import lombok.extern.slf4j.Slf4j;
import main.model.Item;
import main.model.Player;
import main.repository.ItemRepository;
import main.web.dto.CreateItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAllByOrderByCreatedOnDescXpBonusMultiplier();
    }

    public void create(CreateItemRequest createItemRequest, Player player) {
        Item item = Item.builder()
                .name(createItemRequest.getName())
                .type(createItemRequest.getType())
                .xpBonusMultiplier(createItemRequest.getXpBonusMultiplier())
                .iconURL(createItemRequest.getUrl())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .createdBy(player.getNickname())
                .build();

        itemRepository.save(item);

        log.info("New item created: {}", item);
    }
}
