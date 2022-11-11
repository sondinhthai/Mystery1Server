package com.example.mystery1server.controller;

import com.example.mystery1server.models.Documents;
import com.example.mystery1server.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class DocumentsController {
    @Autowired
    private DocumentsService documentsService;

    @PostMapping("/Documents")
    public String saveDocument(@RequestBody Documents documents) throws ExecutionException, InterruptedException {
        return documentsService.saveDocument(documents);
    }

    @GetMapping("/Documents/{title}")
    public Documents getDocument(@PathVariable String title) throws ExecutionException, InterruptedException {
        return documentsService.getDocuments(title);
    }

    @GetMapping("/Documents/all")
    public List<Documents> getAllDocument() throws ExecutionException, InterruptedException {
        return documentsService.getAllDocuments();
    }
}
