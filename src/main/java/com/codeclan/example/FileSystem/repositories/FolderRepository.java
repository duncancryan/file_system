package com.codeclan.example.FileSystem.repositories;


import com.codeclan.example.FileSystem.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
}
