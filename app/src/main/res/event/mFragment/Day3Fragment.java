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

/**
 * Created by root on 28/3/18.
 */

public class Day3Fragment extends Fragment {


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.day3, container, false);

        ListView lv = (ListView) rootView.findViewById(R.id.day3ListView);


        CustomAdapter adapter = new CustomAdapter(this.getActivity(), getEvents3());
        lv.setAdapter(adapter);


        return rootView;
    }

    private ArrayList<Day> getEvents3()

    {
        String[] desc = getResources().getStringArray(R.array.description3);
        String[] venue = getResources().getStringArray(R.array.Venue3);
        String[] date = getResources().getStringArray(R.array.Date3);
        String[] time = getResources().getStringArray(R.array.Time3);
        String[] nu1 = getResources().getStringArray(R.array.Nu111);
        String[] nu2 = getResources().getStringArray(R.array.Nu222);
        String[] Entry = getResources().getStringArray(R.array.entry3);


        ArrayList<Day> events = new ArrayList<>();


        Day ev1 = new Day("Virtual Placement(r 2)", R.drawable.virtual, "9AM-11AM", desc[0],venue[0],date[0],time[0],nu1[0],nu2[0],Entry[0]);
        events.add(ev1);
        Day ev2 = new Day("Quiz(finale)", R.drawable.quiz, "11AM-12:30PM", desc[1],venue[1],date[1],time[1],nu1[1],nu2[1],Entry[1]);
        events.add(ev2);
        Day ev3 = new Day("Adzap", R.drawable.fake, "2PM-4PM", desc[2],venue[2],date[2],time[2],nu1[2],nu2[2],Entry[2]);
        events.add(ev3);
        Day ev4 = new Day("Virtual Placement(r 3)", R.drawable.virtual, "2PM-5PM", desc[3],venue[3],date[3],time[3],nu1[3],nu2[3],Entry[3]);
        events.add(ev4);
        Day ev5 = new Day("Tug Of War", R.drawable.tug_of_war, "11AM-12:30AM", desc[4],venue[4],date[4],time[4],nu1[4],nu2[4],Entry[4]);
        events.add(ev5);
        Day ev6 = new Day("Debate", R.drawable.debate, "3:30PM-5PM", desc[5],venue[5],date[5],time[5],nu1[5],nu2[5],Entry[5]);
        events.add(ev6);
        Day ev7 = new Day("Tambola", R.drawable.tambola, "4PM-5PM", desc[6],venue[6],date[6],time[6],nu1[6],nu2[6],Entry[6]);
        events.add(ev7);
      //  Day ev8 = new Day("Test Your Luck ", R.drawable.ic_launcher_background , "day3",desc[6],venue[6],date[6],time[6],nu1[6],nu2[6],Entry[6]);
        //events.add(ev8);
        return events;
    }


    public String toString() {
        String title = "day 3";
        return title;
    }

}
