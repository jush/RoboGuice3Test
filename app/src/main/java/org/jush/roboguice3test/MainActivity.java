package org.jush.roboguice3test;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.inject.Inject;

import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;
import roboguice.util.Ln;


public class MainActivity extends RoboActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloWorldInBackground();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void helloWorldInBackground() {
        new AsyncTask<Void, Void, Void>() {
            @Inject
            private Foo foo;

            @Override
            protected Void doInBackground(Void... params) {
                RoboGuice.getInjector(getApplicationContext()).injectMembers(this);
                foo.helloWorld();
                return null;
            }
        }.execute();
    }

    private static class Foo {
        public void helloWorld() {
            Ln.d("Hello world");
        }
    }
}
