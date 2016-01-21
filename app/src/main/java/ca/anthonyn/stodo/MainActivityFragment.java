package ca.anthonyn.stodo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivityFragment extends Fragment {
    ArrayList<TodoItem> items;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        int i;

        RecyclerView recycler = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recycler.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());

        TodoListOpenHelper dbHelper = new TodoListOpenHelper(getContext());
        items = dbHelper.getAllItems();

        TodoAdapter adapter = new TodoAdapter(items, dbHelper);
        recycler.setAdapter(adapter);

        return rootView;
    }
}