package com.bridge.bridge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<ChatItem> chatList;

    public ChatAdapter(List<ChatItem> chatList) {
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        ChatItem chatItem = chatList.get(position);
        holder.bind(chatItem);
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    static class ChatViewHolder extends RecyclerView.ViewHolder {
        private ImageView avatar;
        private TextView name;
        private TextView lastMessage;
        private TextView initial;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.name);
            lastMessage = itemView.findViewById(R.id.lastMessage);
            initial = itemView.findViewById(R.id.initial);
        }

        public void bind(ChatItem chatItem) {
            avatar.setImageResource(chatItem.getAvatarResId());
            name.setText(chatItem.getName());
            lastMessage.setText(chatItem.getLastMessage());
            
            // Set first letter of name in the circle
            String firstLetter = chatItem.getName().substring(0, 1);
            initial.setText(firstLetter);
        }
    }
}