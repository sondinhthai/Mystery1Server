package com.example.mystery1server.service;

import com.example.mystery1server.models.CurrentTag;
import com.example.mystery1server.models.Documents;
import com.example.mystery1server.models.Languages;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class LanguageServices {
    private static final String COLLECTION_NAME = "Languages";
    private static final String COLLECTION_NAME_1 = "CurrentTag";

    public List<Languages> getAllLanguages() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        CollectionReference collectionReference = firestore.collection(COLLECTION_NAME);

        ApiFuture<QuerySnapshot> apiFuture = collectionReference.get();

        QuerySnapshot querySnapshot = apiFuture.get();

        if (!querySnapshot.isEmpty()){
            return querySnapshot.toObjects(Languages.class);
        } else {
            return null;
        }
    }

    public String saveCurrentTag(CurrentTag currentTag) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> apiFuture = firestore.collection(COLLECTION_NAME_1).document(currentTag.getDeviceID()).set(currentTag);

        return apiFuture.get().getUpdateTime().toString();
    }
}
