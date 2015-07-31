package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.InstrumentationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by zacharytamas on 7/31/15.
 */
public class JokeBackendTest extends InstrumentationTestCase {

    public final void testSuccessfulFetch() throws Throwable {

        final CountDownLatch signal = new CountDownLatch(1);
        final String[] joke = {null};

        final JokeAsyncTask asyncTask = new JokeAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                joke[0] = result;
                signal.countDown();
            }
        };

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                asyncTask.execute((Context[]) null);
            }
        });

        signal.await(30, TimeUnit.SECONDS);

        assertNotNull(joke[0]);
        assertTrue(joke[0].length() > 0);
    }

}
