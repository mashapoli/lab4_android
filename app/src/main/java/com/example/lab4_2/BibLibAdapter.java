package com.example.lab4_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import name.ank.lab4.BibDatabase;
import name.ank.lab4.Keys;

public class BibLibAdapter extends RecyclerView.Adapter<BibLibAdapter.ArticleViewHolder> {
    private BibDatabase database;
    private int realSize;
    private LayoutInflater inflater;
    BibLibAdapter(Context context, BibDatabase database) {
        this.database = database;
        this.realSize = database.getEntries().size();
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.article, parent, false);
        return new ArticleViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        int realPosition = position % realSize;
        holder.authorTitle.setText(database.getEntry(realPosition).getField(Keys.AUTHOR));
        holder.articleTitle.setText(database.getEntry(realPosition).getField(Keys.TITLE));
        holder.yearTitle.setText(database.getEntry(realPosition).getField(Keys.YEAR));
        holder.journalTitle.setText(database.getEntry(realPosition).getField(Keys.JOURNAL));
        holder.volumePages.setText(database.getEntry(realPosition).getField(Keys.PAGES));
    }
    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        private TextView authorTitle;
        private TextView articleTitle;
        private TextView yearTitle;
        private TextView journalTitle;
        private TextView volumePages;
        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            authorTitle = itemView.findViewById(R.id.author);
            articleTitle = itemView.findViewById(R.id.title);
            yearTitle = itemView.findViewById(R.id.year);
            journalTitle = itemView.findViewById(R.id.journal);
            volumePages = itemView.findViewById(R.id.pages);
        }
    }
}