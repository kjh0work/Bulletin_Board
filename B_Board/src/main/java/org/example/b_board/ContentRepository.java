package org.example.b_board;

import org.example.b_board.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ContentRepository extends JpaRepository<Content, Long> {
}
