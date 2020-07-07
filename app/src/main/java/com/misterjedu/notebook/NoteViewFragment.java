package com.misterjedu.notebook;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */


public class NoteViewFragment extends Fragment {

    public NoteViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentLayout = inflater.inflate(R.layout.fragment_note_view, container, false);
//       Grab data for each item
        TextView title = (TextView) fragmentLayout.findViewById(R.id.viewNoteTitle);
        TextView message = (TextView) fragmentLayout.findViewById(R.id.viewNoteMessage);
        ImageView icon = (ImageView) fragmentLayout.findViewById(R.id.viewNoteIcon);

//       Grab intent passed in
        Intent intent = getActivity().getIntent();

//       Set text for each using the intent passed
        title.setText(intent.getExtras().getString(MainActivity.NOTE_TITLE_EXTRA));
        message.setText(intent.getExtras().getString(MainActivity.NOTE_MESSAGE_EXTRA));
        Note.Category noteCat = (Note.Category) intent.getSerializableExtra(MainActivity.NOTE_CATEGORY_EXTRA);
        icon.setImageResource(Note.categoryToDrawable(noteCat));

        return  fragmentLayout;
    }
}
