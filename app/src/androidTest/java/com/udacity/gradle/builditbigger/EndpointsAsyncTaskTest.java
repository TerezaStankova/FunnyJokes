package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class EndpointsAsyncTaskTest {

    Context context;
    //To finish this part of the project I used answers from:
    // https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework

        @Test
        public void testOutputJoke() throws InterruptedException {

            final CountDownLatch latch = new CountDownLatch(1);
            context = InstrumentationRegistry.getContext();

            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask() {
                @Override
                protected void onPostExecute(String result) {
                    assertTrue(result != null && !result.isEmpty());
                    latch.countDown();
                }
            };
            endpointsAsyncTask.execute(context);
            latch.await();
        }
}