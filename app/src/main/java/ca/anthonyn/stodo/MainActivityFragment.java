package ca.anthonyn.stodo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        String[] todo = new String[]{"homework", "job applications", "food", "sleep"};
        ArrayList items = new ArrayList();
        LinearLayout main_list;
        TodoItem item;
        int i;

        main_list = (LinearLayout) rootView.findViewById(R.id.main_list);

        for (i = 0; i < todo.length; i++) {
            item = new TodoItem(todo[i], rootView.getContext());
            item.addToLayout(main_list);
            items.add(item);
        }

        return rootView;
    }
}

class TodoItem {
    String data;
    public TextView view;

    public TodoItem(String data, Context ctx) {
        this.data = data;
        view = new TextView(ctx);
        update();
        Log.w("STODO", "TodoItem created with " + this.data);
    }

    public void addToLayout(LinearLayout layout) {
        layout.addView(view);
    }

    public void update() {
        view.setText(data);
    }
}