package com.mycompany.tutorial1;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Conexion {

    public static Firestore db;

    public static void conectarFirebase() {
        try {
            FileInputStream sa = new FileInputStream("tutorial1.json");
            
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(sa))                    
                    .build();

            FirebaseApp.initializeApp(options);
            
            db = FirestoreClient.getFirestore();
            System.out.println("Exito al conectar");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
