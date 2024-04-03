package com.groupeisi.ws.web;

import com.groupeisi.ws.domain.SearchHistory;
import com.groupeisi.ws.repository.SearchHistoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historique")
public class SearchHistoryController {

    @Autowired
    private SearchHistoryRepository repository;

    @GetMapping("/all")
    public List<SearchHistory> getAllSearchHistory() {
        return repository.findAll();
    }
}
