package com.example.mission3.eneity.basic.repository;

import com.example.mission3.eneity.basic.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepo extends CrudRepository<BoardEntity,Long> {
}
