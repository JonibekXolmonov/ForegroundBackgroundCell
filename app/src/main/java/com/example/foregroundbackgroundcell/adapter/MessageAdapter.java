package com.example.foregroundbackgroundcell.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foregroundbackgroundcell.R;
import com.example.foregroundbackgroundcell.model.Message;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Message> messages;

    public MessageAdapter(ArrayList<Message> messages) {
        this.messages = messages;
    }

    static public class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView senderProfile;
        public TextView senderName, message;
        public LinearLayout foreground, background;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            senderProfile = view.findViewById(R.id.im_profile);
            senderName = view.findViewById(R.id.tv_sender);
            message = view.findViewById(R.id.tv_message);
            background = view.findViewById(R.id.ll_background);
            foreground = view.findViewById(R.id.ll_foreground);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_layout, parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = messages.get(position);
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).senderProfile.setImageResource(message.profile);
            ((ViewHolder) holder).senderName.setText(message.sender);
            ((ViewHolder) holder).message.setText(message.description);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
