package com.peroah.mail;

import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class MailItem {
    private UUID id;
    private UUID recipientId;
    private ItemStack item;
    private String message;
    private long timestamp;
    private boolean read;

    public MailItem(UUID id, UUID recipientId, ItemStack item, String message, long timestamp) {
        this.id = id;
        this.recipientId = recipientId;
        this.item = item;
        this.message = message;
        this.timestamp = timestamp;
        this.read = false;
    }

    public UUID getId() {
        return id;
    }

    public UUID getRecipientId() {
        return recipientId;
    }

    public ItemStack getItem() {
        return item;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
