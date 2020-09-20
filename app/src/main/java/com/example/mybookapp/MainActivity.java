 package com.example.mybookapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {

    //ListView listView;
    //DatabaseReference databaseReference;
    List<String> title_list,answer_list,author_list;
    ArrayAdapter<String> arrayAdapter;

    Book books;
    private Button button;
    private RecyclerView recyclerView;

    public void openAddBookActivity(){
        Intent intent = new Intent(this, SecActivity.class);
        startActivity(intent);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.book_shelf);


        RecyclerView recyclerView;
        FirebaseFirestore db;
        final List<Book> bookList;
        final BookshelfAdapter adapter;

        db = FirebaseFirestore.getInstance();
        bookList = new ArrayList<>();
        adapter = new BookshelfAdapter(this, bookList);
        recyclerView = findViewById(R.id.book_shelf);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);



        db.collection("Books").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if(!queryDocumentSnapshots.isEmpty()){
                            Toast.makeText(MainActivity.this, "Wyświetlono zawartość bazy", Toast.LENGTH_LONG).show();

                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                            for(DocumentSnapshot d : list){

                                Book p = d.toObject(Book.class);
                                assert p != null;
                                p.setDocumentID(d.getId());
                                bookList.add(p);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }
                });



        Button button = findViewById(R.id.add_book_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddBookActivity();
            }
        });




        //listView = findViewById(R.id.listView);
        /*
        //databaseReference= FirebaseDatabase.getInstance().getReference("bookApp");
        books = new Book();
        title_list = new ArrayList<>();
        answer_list = new ArrayList<>();
        author_list = new ArrayList<>();

        arrayAdapter = new ArrayAdapter<>(this,R.layout.book,R.id.book,title_list);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot d:dataSnapshot.getChildren()){
                    books=d.getValue(Book.class);
                    title_list.add(books.getTitle());
                    answer_list.add(books.getAnswer());
                    author_list.add(books.getAuthor());
                }
                listView.setAdapter(arrayAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(MainActivity.this,answer.class);
                        String p = answer_list.get(position);
                        intent.putExtra("answer",p);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

         */
    }
}