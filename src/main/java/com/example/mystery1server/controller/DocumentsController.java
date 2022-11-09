package com.example.mystery1server.controller;

import com.example.mystery1server.models.Documents;
import com.example.mystery1server.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
