package com.codeclan.example.FileSystem.repositories;

import com.codeclan.example.FileSystem.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
