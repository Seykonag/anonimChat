package kz.services.anonimchat.repository;

import kz.services.anonimchat.database.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Message getReferenceByLink(String link);
}
