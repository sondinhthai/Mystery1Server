package com.example.mystery1server.service;

import com.example.mystery1server.models.Documents;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class DocumentsService {

    private static final String COLLECTION_NAME = "Documents";

    public String saveDocument(Documents documents) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> apiFuture = firestore.collection(COLLECTION_NAME).document(documents.getTitle()).set(documents);

        return apiFuture.get().getUpdateTime().toString();
    }

    public Documents getDocuments(String title) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        DocumentReference documentReference = firestore.collection(COLLECTION_NAME).document(title);

        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();

        DocumentSnapshot documentSnapshot = apiFuture.get();

        if (documentSnapshot.exists()){
            return documentSnapshot.toObject(Documents.class);
        } else {
            return null;
        }
    }

    public List<Documents> getAllDocuments() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        CollectionReference collectionReference = firestore.collection(COLLECTION_NAME);

        ApiFuture<QuerySnapshot> apiFuture = collectionReference.get();

        QuerySnapshot querySnapshot = apiFuture.get();

        if (!querySnapshot.isEmpty()){
            return querySnapshot.toObjects(Documents.class);
        } else {
            return null;
        }
    }
}
