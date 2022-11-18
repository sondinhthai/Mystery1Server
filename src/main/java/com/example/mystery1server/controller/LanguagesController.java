package com.example.mystery1server.controller;

import com.example.mystery1server.models.CurrentTag;
import com.example.mystery1server.models.Documents;
import com.example.mystery1server.models.Languages;
import com.example.mystery1server.service.DocumentsService;
import com.example.mystery1server.service.LanguageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class LanguagesController {
    @Autowired
    private LanguageServices languageServices;

    @GetMapping("/Languages/all")
    public List<Languages> getAllLanguages() throws ExecutionException, InterruptedException {
        return languageServices.getAllLanguages();
    }

    @PostMapping("/CurrentTag")
    public String saveCurrentTag(@RequestBody CurrentTag currentTag) throws ExecutionException, InterruptedException {
        return languageServices.saveCurrentTag(currentTag);
    }
}
