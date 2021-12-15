package com.example.compieSystem.repositories;

import com.example.compieSystem.model.ChatObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//By extends JpaRepository - We get all the 'CRUD' and some more
@Repository
public interface ChatObjRepository extends JpaRepository<ChatObj, Long> {
}
