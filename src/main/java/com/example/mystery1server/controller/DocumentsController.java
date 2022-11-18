package com.example.mystery1server.controller;

import com.example.mystery1server.models.Documents;
import com.example.mystery1server.models.Languages;
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

    @PostMapping("/Bookmarks")
    public String saveBookmark(@RequestBody Documents documents) throws ExecutionException, InterruptedException {
        return documentsService.saveBookmarks(documents);
    }

    @GetMapping("/Documents/{title}")
    public Documents getDocument(@PathVariable String title) throws ExecutionException, InterruptedException {
        return documentsService.getDocuments(title);
    }

    @GetMapping("/Bookmarks/{title}")
    public Documents getBookmarks(@PathVariable String title) throws ExecutionException, InterruptedException {
        return documentsService.getBookmarks(title);
    }

    @GetMapping("/Documents/all")
    public List<Documents> getAllDocument() throws ExecutionException, InterruptedException {
        return documentsService.getAllDocuments();
    }

    @GetMapping("/Bookmarks/all")
    public List<Documents> getAllBookmarks() throws ExecutionException, InterruptedException {
        return documentsService.getAllBookmarks();
    }

    @PostMapping("/Bookmarks/delete")
    public String deleteBookmarks(@RequestBody Documents documents) throws ExecutionException, InterruptedException {
        return documentsService.deleteBookmarks(documents);
    }
}
