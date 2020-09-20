package com.example.mybookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;


public class SecActivity extends AppCompatActivity {


    private static final String TAG = "AddBookActivity";

    private static final String KEY_TITLE = "title";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_COMMENT = "comment";

    private EditText editTextTitle;
    private EditText editTextAuthor;
    private EditText editTextComment;
    private TextView textViewData;
    private Button button;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference booksRef = db.collection("Book");
    private DocumentReference noteRef = db.document("Books/My First Book");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        editTextTitle = findViewById(R.id.add_title);
        editTextAuthor = findViewById(R.id.add_author);
        editTextComment = findViewById(R.id.add_comment);
        //textViewData = findViewById(R.id.text_view_data);

        //Button button = findViewById(R.id.book_list);
        //button.setOnClickListener(new View.OnClickListener() {
           // @Override
            //public void onClick(View v) {
                //openBookListActivity();
            //}
        //});

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void addButton(View v) {
        String title = editTextTitle.getText().toString();
        String author = editTextAuthor.getText().toString();
        String comment = editTextComment.getText().toString();
        Book book = new Book(title, author, comment);
        booksRef.add(book);
    }






    /*TEN
    // DatabaseReference databaseReference;
    private static final String TAG = "AddBookActivity";
    private static final String KEY_TITLE = "title";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_COMMENT = "comment";

    private EditText editTextTitle;
    private EditText editTextAuthor;
    private EditText editTextComment;
    private Button Add_button;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference booksRef = db.collection("Bookshelf");
    private DocumentReference noteRef = db.document("Bookshelf/My First Book");

    //private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        editTextTitle = findViewById(R.id.add_title);
        editTextAuthor = findViewById(R.id.add_author);
        editTextComment = findViewById(R.id.add_comment);


        //Add_button=(Button) findViewById(R.id.add_button);
        /*
        Add_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Book book = new Book();

                book.setTitle(editTextTitle.getText().toString());
                book.setAuthor(editTextAuthor.getText().toString());
                book.setComment(editTextComment.getText().toString());
                //film.setCategory(mCategoryEditTxt.getText().toString());

                new FirebaseDataHelper().addBook(book, SecActivity.this);

                editTextTitle.setText("");
                editTextAuthor.setText("");
                editTextComment.setText("");
               // mReleaseDateEditTxt.setText("");
                //mCategoryEditTxt.setText("");
            }
        });

        /*
        editText=findViewById(R.id.add_title);
        button=findViewById(R.id.add_button);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("bookTitle").setValue(editText.toString());
            }
        });
     */
    /* TEN
    }


    @Override
    protected void onStart() {
        super.onStart();


    }

    public void addButton(View view) {
        String title = editTextTitle.getText().toString();
        String author = editTextAuthor.getText().toString();
        String comment = editTextComment.getText().toString();
        Book book = new Book(title, author, comment);
        booksRef.add(book);
    }


/*
    public void saveNote(View v) {
        String title = editTextTitle.getText().toString();
        String author = editTextAuthor.getText().toString();
        String comment = editTextComment.getText().toString();

        Map<String, Object> note = new HashMap<>();
        note.put(KEY_TITLE, title);
        note.put(KEY_AUTHOR, author);
        note.put(KEY_COMMENT, comment);

        //Szybsza wersja/latwiejsza
        //db.dcocument("NOtebook/MyFirst Note");

        db.collection("BookCollection").document("first book").set(note)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(SecActivity.this, "Not saved", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SecActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());
                    }
                });

    }



 */
/*
private static final String TAG = "AddBookActivity";

    private static final String KEY_TITLE = "title";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_COMMENT = "comment";

    private EditText editTextTitle;
    private EditText editTextAuthor;
    private EditText editTextComment;
    private TextView textViewData;
    private Button button;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference booksRef = db.collection("Book");
    private DocumentReference noteRef = db.document("Books/My First Book");

    public void openBookListActivity(){
        Intent intent = new Intent(this, Book.class);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.add_title);
        editTextAuthor = findViewById(R.id.add_author);
        editTextComment = findViewById(R.id.add_comment);
        //textViewData = findViewById(R.id.text_view_data);

        Button button = findViewById(R.id.book_list);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBookListActivity();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void addBook(View v) {
        String title = editTextTitle.getText().toString();
        String author = editTextAuthor.getText().toString();
        String comment = editTextComment.getText().toString();
        Book book = new Book(title, author, comment);
        booksRef.add(book);
    }

    public void loadBooks(View v) {
        booksRef.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String data = " ";

                        for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            Book book = documentSnapshot.toObject(Book.class);
                            book.setDocumentID(documentSnapshot.getId());

                            String documentId = book.getDocumentID();
                            String title = book.getTitle();
                            String author = book.getAuthor();
                            String comment = book.getComment();

                            data += "ID: " + documentId + "\nTitle: " + title + "\nAuthor: " + author + "\nComment: " + comment + "\n\n";
                        }
                        textViewData.setText(data);
                    }
                });
    }

 */


}