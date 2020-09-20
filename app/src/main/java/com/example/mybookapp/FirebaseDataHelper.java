package com.example.mybookapp;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;

public class FirebaseDataHelper {

    private FirebaseFirestore db;
    CollectionReference dbFilmsRef;

    public FirebaseDataHelper() {
        db = FirebaseFirestore.getInstance();
        dbFilmsRef = db.collection("Books");
    }

    public void addBook(Book book, final Context context) {
        dbFilmsRef.add(book)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(context, "Film został dodany", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
                });
    }

    public void updateFilm(Book book, final Context context){
        dbFilmsRef.document(book.getDocumentID())
                .set(book)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "Film zaktualizowany", Toast.LENGTH_LONG).show();
                    }
                });
    }
}