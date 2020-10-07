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
        userRepository.save(duncan);

        User phil = new User("Phil");
        userRepository.save(phil);

        Folder jobStuff = new Folder("Job Stuff", duncan);
        duncan.addFolder(jobStuff);
        folderRepository.save(jobStuff);

        Folder music = new Folder("Music", phil);
        phil.addFolder(music);
        folderRepository.save(music);

        Folder investing = new Folder("Investing", duncan);
        duncan.addFolder(investing);
        folderRepository.save(investing);

        File cV = new File("Curriculum Vitae", ".pdf", jobStuff);
        jobStuff.addFile(cV);
        fileRepository.save(cV);

        File coverLetter = new File("Cover Letter", ".docx", jobStuff);
        jobStuff.addFile(coverLetter);
        fileRepository.save(coverLetter);

        File blue = new File("Blue", ".mp3", music);
        music.addFile(blue);
        fileRepository.save(blue);

        File shares = new File("Shares", ".xlxs", investing);
        investing.addFile(shares);
        fileRepository.save(shares);

        File quarterlyResults = new File("Quarterly Results", ".docx", investing);
        investing.addFile(quarterlyResults);
        fileRepository.save(quarterlyResults);
    }
}
