package ca.anthonyn.stodo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    ArrayList<TodoItem> items = new ArrayList();

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        String[] todo = new String[]{"homework", "job applications", "food", "sleep", "misc", "misc", "misc", "misc", "misc", "misc", "misc", "misc", "misc", "misc"};
        LinearLayout main_list;
        int i;

        main_list = (LinearLayout) rootView.findViewById(R.id.main_list);

        for (i = 0; i < todo.length; i++) {
            final TodoItem item;
            item = new TodoItem(todo[i], rootView.getContext(), main_list);
            items.add(item);

            item.cbview.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    item.cview.setSelected(isChecked);

                    boolean oneSelected = false;
                    for (TodoItem item : items) {
                        if (item.cview.isSelected()) {
                            oneSelected = true;
                            break;
                        }
                    }
                }
            });
        }

        return rootView;
    }
}

class TodoItem {
    String data;
    final TextView tview;
    final CardView cview;
    final CheckBox cbview;
    final LinearLayout llayout;

    public TodoItem(String data, Context ctx, LinearLayout layout) {
        this.data = data;
        tview = new TextView(ctx);
        cview = new CardView(ctx);
        cbview = new CheckBox(ctx);
        llayout = new LinearLayout(ctx);

        initCardView();
        initTextView();

        tview.setText(this.data);

        llayout.setOrientation(LinearLayout.HORIZONTAL);
        llayout.addView(cbview);
        llayout.addView(tview);

        cview.addView(llayout);

        layout.addView(cview);

        cview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbview.setChecked(!cview.isSelected());
            }
        });

        llayout.setAddStatesFromChildren(true);
        cview.setAddStatesFromChildren(true);

        Log.w("STODO", "TodoItem created with " + this.data);
    }

    private void initCardView() {
        cview.setCardBackgroundColor(Color.WHITE);
        cview.setRadius(0);
        cview.setContentPadding(20, 30, 20, 30);
        cview.setCardElevation(2.0f);
        cview.setPadding(0, 15, 0, 15);
        cview.setUseCompatPadding(true);
    }

    private void initTextView() {
        tview.setTextColor(Color.BLACK);
    }
}