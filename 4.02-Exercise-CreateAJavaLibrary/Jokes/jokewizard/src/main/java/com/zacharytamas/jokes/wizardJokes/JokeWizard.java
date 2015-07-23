package com.zacharytamas.jokes.wizardJokes;

import com.zacharytamas.jokes.manualJokes.JokeSmith;

public class JokeWizard {
    public String getJoke() {
        return new JokeSmith().getJoke();
    }
}
