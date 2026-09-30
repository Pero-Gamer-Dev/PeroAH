package com.peroah.storage;

import com.peroah.mail.MailItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class MailRepository {
    private Map<UUID, MailItem> mail = new HashMap<>();

    public void save(MailItem mailItem) {
        mail.put(mailItem.getId(), mailItem);
    }

    public MailItem findById(UUID mailId) {
        return mail.get(mailId);
    }

    public List<MailItem> findByRecipient(UUID recipientId) {
        return mail.values().stream()
            .filter(m -> m.getRecipientId().equals(recipientId))
            .collect(Collectors.toList());
    }

    public void delete(UUID mailId) {
        mail.remove(mailId);
    }
}
