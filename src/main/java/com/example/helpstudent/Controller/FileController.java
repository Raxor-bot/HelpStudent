package com.example.helpstudent.Controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import com.example.helpstudent.Service.StudentService;
import com.example.helpstudent.Tabellen.Student.Student;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileController {
    private Logger logger = LoggerFactory.logger(FileController.class);
    private final StudentService studentService;

    public FileController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/upload")
    public String handleFilesUpload(@RequestParam("file") MultipartFile file, Model map) throws IOException { //Hier noch StudentID
        StringBuilder sb = new StringBuilder();
        Optional<Student> student = studentService.getStudentByID(1L);

    if(student.isPresent()) {

        logger.info(student.get().getBilderpfad());

        String profilpfad = student.get().getBilderpfad();
        final String UPLOAD_FOLDER = "Bilder_upload";

        if (file != null) {

            logger.info(!file.getName().equals(profilpfad));
            logger.info(Files.exists(Paths.get(UPLOAD_FOLDER + "/" + file.getName())));

            logger.info(Paths.get(UPLOAD_FOLDER + "/" + file.getName()));
            if (Files.exists(Paths.get(UPLOAD_FOLDER + "/" + file.getName())) && (!file.getName().equals(profilpfad))) {
                sb.append("Datei bereits vorhanden \n");
                map.addAttribute("msg", sb);
            }

            else{
                try {
                    if (!Files.exists(Paths.get(UPLOAD_FOLDER))) {
                        try {
                            Files.createDirectories(Paths.get(UPLOAD_FOLDER));
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }

                    Files.copy(file.getInputStream(), Paths.get(UPLOAD_FOLDER, file.getOriginalFilename()));
                    sb.append("Datei wurde Hochgeladen " + file.getOriginalFilename() + "!\n");

                    map.addAttribute("msg", sb);

                } catch (IOException | RuntimeException e) {
                    sb.append("Datei konnte nicht Hochgeladen werden " + file.getOriginalFilename() + " => "
                            + e.getMessage() + String.valueOf(e) + "\n");

                    map.addAttribute("msg", sb);
                }
            }
        }

        else {
            sb.append("Keine Datei ausgewählt\n");
            map.addAttribute("msg", sb);
        }
    }


    else {
        sb.append("Student nicht vorhanden\n");
        map.addAttribute("msg", sb);
    }

        return "upload";
    }
}
