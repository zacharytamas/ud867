package com.zacharytamas.jokeplayer;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public static String EXTRA_JOKE = "joke";

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(EXTRA_JOKE);

        TextView jokeTextView = (TextView) view.findViewById(R.id.jokeTextView);
        jokeTextView.setText(joke);

        return view;
    }
}
