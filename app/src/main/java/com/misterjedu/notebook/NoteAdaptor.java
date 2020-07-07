package com.misterjedu.notebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdaptor extends ArrayAdapter<Note> {
    public static class ViewHolder {
        TextView title;
        TextView body;
        ImageView noteIcon;
    }

    public NoteAdaptor(Context context, ArrayList<Note> notes) {
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
//      Get item for this position
        Note note = getItem(position);


//        Check if existing view is being re-used, otherwise, inflate a new use
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
//          Set viewholder so we don't need to go back and get references of views each time for each row
            viewHolder.title = (TextView) convertView.findViewById(R.id.listItemNoteTitle);
            viewHolder.body = (TextView) convertView.findViewById(R.id.listItemNoteBody);
            viewHolder.noteIcon = (ImageView) convertView.findViewById(R.id.listItemNoteImg);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

//        Fill each new referenced view with data from associated note
        viewHolder.title.setText(note.getTitle());
        viewHolder.body.setText(note.getMessage());
        viewHolder.noteIcon.setImageResource(note.getAssociatedDrawable());

//        Now that convetView has been modified, we have return it
        return convertView;
    }
}
