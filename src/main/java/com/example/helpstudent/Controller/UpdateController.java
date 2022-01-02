package com.example.helpstudent.Controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;

import com.example.helpstudent.Service.StudentService;
import com.example.helpstudent.Tabellen.Student.Student;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UpdateController {
    private final Logger logger = LoggerFactory.logger(UpdateController.class);
    private final StudentService studentService;

    public UpdateController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/upload")
    public ResponseEntity<?> handleFilesUpload(@RequestParam("file") MultipartFile file,@RequestParam("id") long id, Model map) throws IOException { //Hier noch StudentID
        StringBuilder sb = new StringBuilder();
        Optional<Student> student = studentService.getStudentByID(id);

    if(student.isPresent()) {
        System.out.println("Bild veararbeiten");

        logger.info(student.get().getBilderpfad());

        String profilpfad = student.get().getBilderpfad();
        final String UPLOAD_FOLDER = "Bilder_upload";

        if (file != null) {
            if (Files.exists(Paths.get(UPLOAD_FOLDER + "/" + file.getOriginalFilename())) && (!Objects.equals(file.getOriginalFilename(), profilpfad))) {
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

                    studentService.setStudentBilderPfad(file.getOriginalFilename(), student.get().getNlfdstudent());

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
        return new ResponseEntity<Object>(map, HttpStatus.OK);    }
}
