package ca.anthonyn.stodo;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    final ArrayList<TodoItem> items;
    private static Snackbar snackbar;

    public TodoAdapter(ArrayList<TodoItem> items) {
        this.items = items;
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        public CardView card;
        public TextView mainTextView;

        public TodoViewHolder(View itemView) {
            super(itemView);
            card = (CardView) itemView;
            mainTextView = (TextView) itemView.findViewById(R.id.card_main_text);
        }
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        final TodoViewHolder viewHolder = new TodoViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                if (snackbar != null)
                    snackbar.dismiss();

                snackbar = Snackbar.make(v, "Item removed: " + items.get(position).data, Snackbar.LENGTH_SHORT);
                snackbar.show();

                items.remove(position);
                notifyItemRemoved(position);
            }
        });

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