package com.example.firebase.springbootfirebasedemo.Firebase;

import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;

import javax.annotation.PostConstruct;

@Service

public class FirebaseInitialization {


    @PostConstruct
    public void initialization (){
        FileInputStream serviceAccount = null;
        try{
            serviceAccount = new FileInputStream("./serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://projetoasz-default-rtdb.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
