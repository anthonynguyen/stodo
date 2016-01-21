package ca.anthonyn.stodo;

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
    ArrayList<TodoItem> items = new ArrayList();

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        String[] todo = new String[]{"homework", "job applications", "food", "sleep", "slip", "scarecrow", "irritate", "whispering", "suit", "crowded", "space", "provide", "didactic", "advise", "boiling", "phobic", "clap", "bashful", "thunder", "rainy", "deserted", "tangible", "crabby", "drab", "fire", "boundary", "poison", "clear"};
        int i;

        RecyclerView recycler = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recycler.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());

        for (i = 0; i < todo.length; i++) {
            TodoItem item;
            item = new TodoItem(todo[i], i);
            items.add(item);
        }

        TodoAdapter adapter = new TodoAdapter(items);
        recycler.setAdapter(adapter);

        return rootView;
    }
}