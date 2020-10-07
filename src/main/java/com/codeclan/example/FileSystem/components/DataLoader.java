package com.codeclan.example.FileSystem.components;


import com.codeclan.example.FileSystem.models.File;
import com.codeclan.example.FileSystem.models.Folder;
import com.codeclan.example.FileSystem.models.User;
import com.codeclan.example.FileSystem.repositories.FileRepository;
import com.codeclan.example.FileSystem.repositories.FolderRepository;
import com.codeclan.example.FileSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    public DataLoader(){
    }
    public void run(ApplicationArguments args){
        User duncan = new User("Duncan");

        User phil = new User("Phil");

        Folder jobStuff = new Folder("Job Stuff", duncan);

        Folder music = new Folder("Music", phil);

        Folder investing = new Folder("Investing", duncan);

        File cV = new File("Curriculum Vitae", ".pdf", jobStuff);
        fileRepository.save(cV);

        File coverLetter = new File("Cover Letter", ".docx", jobStuff);
        fileRepository.save(coverLetter);

        File blue = new File("Blue", ".mp3", music);
        fileRepository.save(blue);

        File shares = new File("Shares", ".xlxs", investing);
        fileRepository.save(shares);

        File quarterlyResults = new File("Quarterly Results", ".docx", investing);
        fileRepository.save(quarterlyResults);

        jobStuff.addFile(cV);
        jobStuff.addFile(coverLetter);
        folderRepository.save(jobStuff);

        music.addFile(blue);
        folderRepository.save(music);

        investing.addFile(shares);
        investing.addFile(quarterlyResults);
        folderRepository.save(investing);

        phil.addFolder(music);
        userRepository.save(phil);

        duncan.addFolder(investing);
        duncan.addFolder(jobStuff);
        userRepository.save(duncan);
    }
}
