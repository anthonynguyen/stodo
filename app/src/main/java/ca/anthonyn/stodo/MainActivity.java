package ca.anthonyn.stodo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements MainActivityFragment.OnListItemSelectedListener {
    boolean itemsAreSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab_add = (FloatingActionButton) findViewById(R.id.fab_add);
        FloatingActionButton fab_checkmark = (FloatingActionButton) findViewById(R.id.fab_checkmark);
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Open \"Add new item\" screen", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
        fab_checkmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Mark all selected items as done and hide them", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
        fab_checkmark.hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        // return true;
        return false;
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

    public void listItemSelected(boolean itemsAreSelected) {
        FloatingActionButton fab_add = (FloatingActionButton) findViewById(R.id.fab_add);
        FloatingActionButton fab_checkmark = (FloatingActionButton) findViewById(R.id.fab_checkmark);
        if (itemsAreSelected) {
            fab_checkmark.show();
            fab_add.hide();
        } else {
            fab_add.show();
            fab_checkmark.hide();
        }
    }
}
