package com.example.file_upload;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/file")

public class FileUploadController {
    @PostMapping("/upload")
    public void saveFile(@RequestParam("files")MultipartFile[] files){
        String uploadDir = "Uploaded Files"; // Updated directory name
        Arrays.asList(files).stream().forEach(file->{
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            System.out.println(fileName);
            try{
                FileUploadUtil.saveFile(uploadDir,fileName,file);
            }catch (IOException ioException){

            }
        });
    }
}
