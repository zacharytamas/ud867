package com.zacharytamas.appwithlibrary;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.Jokester;
import com.zacharytamas.jokeplayer.*;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button jokeButton = (Button) view.findViewById(R.id.jokeButton);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String joke = Jokester.getJoke();
                Intent jokePlayerIntent = new Intent(getActivity(), com.zacharytamas.jokeplayer.MainActivity.class);
                jokePlayerIntent.putExtra(com.zacharytamas.jokeplayer.MainActivityFragment.EXTRA_JOKE, joke);
                startActivity(jokePlayerIntent);
            }
        });

        return view;
    }
}
