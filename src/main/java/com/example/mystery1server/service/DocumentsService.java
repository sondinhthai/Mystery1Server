package com.example.mystery1server.service;

import com.example.mystery1server.models.Documents;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class DocumentsService {

    private static final String COLLECTION_NAME = "Documents";

    public String saveDocument(Documents documents) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> apiFuture = firestore.collection(COLLECTION_NAME).document(documents.getTitle()).set(documents);

        return apiFuture.get().getUpdateTime().toString();
    }
}
