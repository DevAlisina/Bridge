package com.bridge.bridge;

public class ChatItem {
    private String name;
    private String lastMessage;
    private int avatarResId;

    public ChatItem(String name, String lastMessage, int avatarResId) {
        this.name = name;
        this.lastMessage = lastMessage;
        this.avatarResId = avatarResId;
    }

    public String getName() {
        return name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public int getAvatarResId() {
        return avatarResId;
    }
}