package ca.anthonyn.stodo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    ArrayList<TodoItem> items;

    public TodoAdapter(ArrayList<TodoItem> items) {
        this.items = items;
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        public TextView mainTextView;

        public TodoViewHolder(View itemView) {
            super(itemView);
            this.mainTextView = (TextView) itemView.findViewById(R.id.card_main_text);
        }
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        //view.setOnClickListener();
        TodoViewHolder viewHolder = new TodoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        TextView textView = holder.mainTextView;
        textView.setText(items.get(position).data);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}