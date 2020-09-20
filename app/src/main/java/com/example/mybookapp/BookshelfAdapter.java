package com.example.mybookapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookshelfAdapter extends RecyclerView.Adapter<BookshelfAdapter.BooksViewHolder> {

    private Context context;
    private List<Book> BookList;


    public BookshelfAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.BookList = bookList;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BooksViewHolder(
                LayoutInflater.from(context).inflate(R.layout.book, parent, false)
        );
    }

    @Override
    public int getItemCount() {
        return BookList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        final Book film = BookList.get(position);
        final Context context = holder.mdeleteButton.getContext();
        holder.titleView.setText(film.getTitle());
        holder.AuthorView.setText(film.getAuthor());


        holder.mdeleteButton.setOnClickListener(    new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setMessage(R.string.delete_question)
                        .setPositiveButton(R.string.dialog_confirm, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                FirebaseFirestore db;
                                db = FirebaseFirestore.getInstance();
                                db.collection("Books").document(film.getDocumentID()).delete()
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(context, "Pozyzja została usunięta", Toast.LENGTH_LONG).show();
                                                    notifyDataSetChanged();
                                                }
                                            }
                                        });
                            }
                        })
                        .setNegativeButton(R.string.dialog_cancel, null)
                        .show();
            }
        });

    }


    class BooksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titleView;
        TextView AuthorView;
        ImageButton mdeleteButton;

        public BooksViewHolder(View itemView) {
            super(itemView);

            titleView = itemView.findViewById(R.id.book_title);
            AuthorView = itemView.findViewById(R.id.book_author);
            mdeleteButton = itemView.findViewById(R.id.delete_button);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Book book = BookList.get(getAdapterPosition());
            Intent intent = new Intent(context, BookDetails.class);
            //intent.putExtra("film", book);
            context.startActivity(intent);
        }
    }
}

