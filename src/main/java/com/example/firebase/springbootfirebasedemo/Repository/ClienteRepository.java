package com.example.firebase.springbootfirebasedemo.Repository;


import com.example.firebase.springbootfirebasedemo.Entity.Cliente;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;
import java.util.concurrent.ExecutionException;
@Repository
public class ClienteRepository {

    private static final String COLLECTION_NAME = "cliente";

    public String save(Cliente cliente) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference docRef = dbFirestore.collection(COLLECTION_NAME).document(cliente.getID());
        docRef.set(cliente);
        return docRef.getId();
    }

    public Cliente findById(String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(id);
        return documentReference.get().get().toObject(Cliente.class);
    }

    public void update(Cliente cliente) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(COLLECTION_NAME).document(cliente.getID()).set(cliente);
    }

    public String deleteById(String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(COLLECTION_NAME).document(id).delete();
        return "Frete: "+id+" Deletado com Sucesso!";
    }
}

