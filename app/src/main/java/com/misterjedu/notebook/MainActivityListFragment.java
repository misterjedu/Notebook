package com.misterjedu.notebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {

    private ArrayList<Note> notes;
    private NoteAdaptor noteAdaptor;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    /*
//    Setting Original ArrayAdaptor with strings and using a basic premade android layout for display

        String[] values = new String[]{"Mr Beast", "Thoughty 2", "Brad Traversy", "Pewdie Pie", "Davie 504",
                "Leon Lush", "JJ Olatunji", "Isaac Butterfield", "Web Dev Simplified", "Net Ninja",
                "Charles Berthoud", "TwoSet Violin", "Ben Shapiro", "JRE Clips", "Casey Neistat", "Marques Brownie"};

        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);

        setListAdapter(adapter);
     */

    // **********************************************************************************************************************************

//    Setting up Custom ArrayAdaptor using custom Objects and Layouts
        notes = new ArrayList<Note>();
        notes.add(new Note("Pewdipie", "105M subs, Elite Gamer, King of Youtube", Note.Category.ENTERTAINMENT));
        notes.add(new Note("Mr Beast", "32M subs, King of the Jungle, One-Man-Charity Organization", Note.Category.ENTERTAINMENT));
        notes.add(new Note("Thoughty 2", "2M subs, Reservoir of Knowledge, Elite Savage ", Note.Category.KNOWLEDGE));
        notes.add(new Note("Brad Traversy", "1M subs, Dev Master, ELite Teacher", Note.Category.TUTORIAL));
        notes.add(new Note("Davie504", "7M subs, Elite Memer, King of Bass Community", Note.Category.ENTERTAINMENT));
        notes.add(new Note("LEON LUSH", "1M subs, Elite Entertainer, King of Reactions", Note.Category.ENTERTAINMENT));
        notes.add(new Note("Isaac ButterField", "1M subs, Defender of Australia, Viking", Note.Category.ENTERTAINMENT));
        notes.add(new Note("Net Ninja", "0.5M subs, Elite Developer, Master of Teaching", Note.Category.TUTORIAL));
        notes.add(new Note("Joe Rogan", "10M subs, Podcast King, King of Podcasting", Note.Category.ENTERTAINMENT));
        notes.add(new Note("Marques Brownie", "11M subs, Elite Tech Reviewer, Podcast Savvy", Note.Category.KNOWLEDGE));
        notes.add(new Note("Casey Neistat", "10M subs, Elite Content Creator, Story Teller", Note.Category.ENTERTAINMENT));
        notes.add(new Note("Ben Shapiro", "1M subs, King of Facts and Logic, Destroyer of the Left", Note.Category.KNOWLEDGE));
        notes.add(new Note("JJ Olantunji", "10M subs, Elite Memer, Advanced Youtuber", Note.Category.ENTERTAINMENT));

        noteAdaptor = new NoteAdaptor(getActivity(), notes);

        setListAdapter(noteAdaptor  );

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
//    Call launchNoteDetail Activity on Click to load
        launchNoteDetailActiviity(position);

    }

    private void launchNoteDetailActiviity(int position){
//        Instantiate a new Note and grab information associated with the clicked item.
        Note note = (Note) getListAdapter().getItem( position);

//       Create an Intent to load a NoteDetailActivity activity and pass data to the new activity
        Intent intent = new Intent(getActivity(), NoteDetailActivity.class);

        intent.putExtra(MainActivity.NOTE_TITLE_EXTRA, note.getTitle());
        intent.putExtra(MainActivity.NOTE_MESSAGE_EXTRA, note.getMessage());
        intent.putExtra(MainActivity.NOTE_ID_EXTRA, note.getNoteId());
        intent.putExtra(MainActivity.NOTE_CATEGORY_EXTRA, note.getCategory());

//        Start Activity with the intent
        startActivity(intent);
    }
    }
