package com.gabrielrossilopes.fetcher.repository;

import com.gabrielrossilopes.fetcher.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {}
