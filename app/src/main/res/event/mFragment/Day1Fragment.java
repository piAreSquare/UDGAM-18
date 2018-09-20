package com.nitravangla.udgam_2k18.Events.event.mFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.nitravangla.udgam_2k18.Events.event.mData.Day;
import com.nitravangla.udgam_2k18.Events.event.mListView.CustomAdapter;
import com.nitravangla.udgam_2k18.R;


import java.util.ArrayList;


public class Day1Fragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.day1, container, false);

        ListView lv = (ListView) rootView.findViewById(R.id.day1ListView);


        CustomAdapter adapter = new CustomAdapter(this.getActivity(), getEvents1());
        lv.setAdapter(adapter);


        return rootView;
    }

    private ArrayList<Day> getEvents1()

    {
        String[] desc = getResources().getStringArray(R.array.description);
        String[] venue = getResources().getStringArray(R.array.Venue);
        String[] date = getResources().getStringArray(R.array.Date);
        String[] time = getResources().getStringArray(R.array.Time);
        String[] nu1 = getResources().getStringArray(R.array.Nu1);
        String[] nu2 = getResources().getStringArray(R.array.Nu2);
        String[] Entry = getResources().getStringArray(R.array.entry);


        ArrayList<Day> events = new ArrayList<>();
        Day ev1 = new Day("Treasure Hunt", R.drawable.treasurehunt, "9AM-11AM", desc[0],venue[0],date[0],time[0],nu1[0],nu2[0],Entry[0]);
        events.add(ev1);
        Day ev2 = new Day("Jam", R.drawable.jam, "11AM-12PM ", desc[1],venue[1],date[1],time[1],nu1[1],nu2[1],Entry[1]);
        events.add(ev2);
        Day ev3 = new Day("Mimicry", R.drawable.mimicry, "11AM-12:30PM", desc[2],venue[2],date[2],time[2],nu1[2],nu2[2],Entry[2]);
        events.add(ev3);
        Day ev4 = new Day("Quiz", R.drawable.quiz, "2PM-2:30PM.", desc[3],venue[3],date[3],time[3],nu1[3],nu2[3],Entry[3]);
        events.add(ev4);
        Day ev5 = new Day("Sketching Competition", R.drawable.sketch, "2PM-5PM", desc[4],venue[4],date[4],time[4],nu1[4],nu2[4],Entry[4]);
        events.add(ev5);
        Day ev6 = new Day("Tambola", R.drawable.tambola, "4PM-5PM ", desc[5],venue[5],date[5],time[5],nu1[5],nu2[5],Entry[5]);
        events.add(ev6);
        Day ev7 = new Day("Drama Competition", R.drawable.drama, "4PM-6PM", desc[6],venue[6],date[6],time[6],nu1[6],nu2[6],Entry[6]);
        events.add(ev7);
        Day ev8 = new Day("Wall Panting", R.drawable.wall, "11AM-4AM",desc[7],venue[7],date[7],time[7],nu1[7],nu2[7],Entry[7]);
        events.add(ev8);
        Day ev9 = new Day("Super Over", R.drawable.t2, "depend on fixture",desc[8],venue[8],date[8],time[8],nu1[8],nu2[8],Entry[8]);
        events.add(ev9);
        Day ev10 = new Day("Tiger Five", R.drawable.tigerfive, "depend on fixture",desc[9],venue[9],date[9],time[9],nu1[9],nu2[9],Entry[9]);
        events.add(ev10);

        return events;
    }


    public String toString() {
        String title = "day 1";
        return title;
    }
}
