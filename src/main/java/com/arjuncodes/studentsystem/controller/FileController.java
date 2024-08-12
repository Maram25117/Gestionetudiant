package com.arjuncodes.studentsystem.controller;

import com.arjuncodes.studentsystem.model.File;
import com.arjuncodes.studentsystem.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.List;

/*@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping
    public List<File> getAllFiles() {
        return fileService.getAllFiles();
    }

    /*@PostMapping("/upload")
    public ResponseEntity<?> uploadFiles(@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file : files) {
            // Code pour sauvegarder le fichier
        }
        // Retournez une réponse appropriée
        return ResponseEntity.ok("Fichiers téléchargés avec succès");
    }
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFiles(@RequestParam("files") MultipartFile[] files) throws IOException {
        for (MultipartFile file : files) {
            fileService.saveFile(file);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileSystemResource> getFile(@PathVariable Long id) {
        File fileEntity = fileService.getFile(id);
        FileSystemResource resource = new FileSystemResource(fileEntity.getPath());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=" + fileEntity.getName()); // 'inline' to display in browser

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Long id) {
        fileService.deleteFile(id);
        return ResponseEntity.ok().build();
    }
}*/
    @RestController
    @RequestMapping("/file")
    public class FileController {

        @Autowired
        private FileService fileService;

        @GetMapping
        public List<File> getAllFiles() {
            return fileService.getAllFiles();
        }

        @PostMapping("/upload")
        public ResponseEntity<String> uploadFiles(@RequestParam("files") MultipartFile[] files) {
            try {
                for (MultipartFile file : files) {
                    fileService.saveFile(file);
                }
                return ResponseEntity.ok("Fichiers téléchargés avec succès");
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors du téléversement des fichiers");
            }
        }

        @GetMapping("/{id}")
        public ResponseEntity<FileSystemResource> getFile(@PathVariable Long id) {
            File fileEntity = fileService.getFile(id);
            if (fileEntity != null) {
                FileSystemResource resource = new FileSystemResource(fileEntity.getPath());
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Disposition", "inline; filename=" + fileEntity.getName());
                return ResponseEntity.ok().headers(headers).body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteFile(@PathVariable Long id) {
            fileService.deleteFile(id);
            return ResponseEntity.ok("Fichier supprimé avec succès");
        }
    }

