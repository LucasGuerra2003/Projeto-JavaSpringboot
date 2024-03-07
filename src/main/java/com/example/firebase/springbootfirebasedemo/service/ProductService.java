package com.example.firebase.springbootfirebasedemo.service;

import com.example.firebase.springbootfirebasedemo.Entity.Cliente;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Service
public class ProductService {

    private static final String COLLECTION_NAME = "cliente";
    public String setID (Cliente id) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(id.getID()).set(id);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public Cliente getClienteDetailsByname(String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference=dbFirestore.collection(COLLECTION_NAME).document(id);

        ApiFuture<DocumentSnapshot> future=documentReference.get();

        DocumentSnapshot document=future.get();
        Cliente cliente = null;

        if (document.exists()){
            cliente = document.toObject(Cliente.class);
            return cliente;
        }
        else {return null;}
    }

    public List<Cliente> getClienteDetails() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference=dbFirestore.collection(COLLECTION_NAME).listDocuments();

        Iterator<DocumentReference> iterator=documentReference.iterator();
        List<Cliente> clienteList = new ArrayList<>();
        Cliente cliente = null;
        while (iterator.hasNext()){
            DocumentReference documentReference1=iterator.next();
            ApiFuture<DocumentSnapshot> future=documentReference1.get();
            DocumentSnapshot document=future.get();
            cliente=document.toObject(Cliente.class);
            clienteList.add(cliente);
        }
        return clienteList;
    }

    public String updateCliente(Cliente cliente) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();


        DocumentReference docRef = dbFirestore.collection(COLLECTION_NAME).document(cliente.getID());
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();

        if (document.exists()) {

            if (cliente.getCPF() != null) {
                docRef.update("cpf", cliente.getCPF());
            }
            if (cliente.getEnd() != null) {
                docRef.update("end", cliente.getEnd());
            }
            if (cliente.getCEP() != null) {
                docRef.update("cep", cliente.getCEP());
            }
            if (cliente.getTip() != null) {
                docRef.update("tip", cliente.getTip());
            }
            if (cliente.getValor() != null) {
                docRef.update("valor", cliente.getValor());
            }

            return "O Frete foi atualizado com sucesso!";
        } else {
            return "Frete não encontrado para atualização.";
        }
    }


    public String deletaCliente (String id) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(id).delete();

        return "O Frete com ID: "+ id +" foi deletado com sucesso!";
    }
}
