package com.tdd.services;

import com.tdd.domain.entities.Item;
import com.tdd.domain.exceptions.ItemNotFoundException;
import com.tdd.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> list(){
        return itemRepository.findAll();
    }

    public Item findById(Long id){
        return itemRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

}
