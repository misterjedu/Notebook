package com.misterjedu.notebook;

import android.widget.Switch;

public class Note {

    private String title, message;
    private long noteId, dateCreatedMilli;
    private Category category;
    public enum Category{KNOWLEDGE, TUTORIAL, MUSIC, ENTERTAINMENT}

    public Note(String title, String message, Category category){
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteId = 0;
        this.dateCreatedMilli = 0;
    }

    public Note(String title, String message, Category category, long noteId, long dateCreatedMilli){
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteId = noteId;
        this.dateCreatedMilli = dateCreatedMilli;
    }

    public String getTitle(){
        return title;
    }

    public String getMessage(){
        return message;
    }

    public Category getCategory(){
        return category;
    }

    public long getNoteId(){
        return noteId;
    }

    public long getDateCreatedMilli(){
        return dateCreatedMilli;
    }

    public String toString(){
        return "Id: $noteId, Title: $title, Message: $message, ";
    }

    public int getAssociatedDrawable(){
    return categoryToDrawable(category);
    }

    public static int categoryToDrawable(Category noteCategory){
        switch(noteCategory){
            case MUSIC:
                return R.drawable.a;
            case TUTORIAL:
                return R.drawable.b;
            case KNOWLEDGE:
                return R.drawable.c;
            case ENTERTAINMENT:
                return R.drawable.d;
        }

        return R.drawable.a;
    }
}
