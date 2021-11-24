package sit.integrated.project.controllers;


import org.apache.commons.io.FilenameUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sit.integrated.project.exceptions.ExceptionResponse;
import sit.integrated.project.exceptions.ProductsException;
import sit.integrated.project.models.Products;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/Images")
@CrossOrigin
public class ImageController {



String FILE_DIRECTORY = "./images/";

@GetMapping("/Get/{filename:.+}")

    public ResponseEntity<byte[]> getImages(@PathVariable("filename") String filename) throws IOException{
    System.out.println(filename);
    FileInputStream fileInputStream = new FileInputStream( FILE_DIRECTORY +filename);
    byte[] images = fileInputStream.readAllBytes();
    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(images);
}
@PostMapping("/upload/{id}")

    public void imageUpload(@RequestParam("File")MultipartFile file, @PathVariable("id") int id ) throws IOException{

        String ChangNameOfImages = "." + FilenameUtils.getExtension(file.getOriginalFilename());
        File imageFile = new File(FILE_DIRECTORY + Integer.toString(id) + ChangNameOfImages);
        imageFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(imageFile);
        fos.write(file.getBytes());
        fos.close();
        System.out.println("The File Uploaded Successfully");

}
@PutMapping("/edit/{id}")
    public void imageEdit(@RequestParam("File")MultipartFile file, @PathVariable("id") int id ) throws IOException{
    String ChangNameOfImages = Integer.toString(id)+"." + FilenameUtils.getExtension(file.getOriginalFilename());
    File imageFile = new File (  FILE_DIRECTORY + ChangNameOfImages);
    imageFile.createNewFile();
    FileOutputStream fos = new FileOutputStream(imageFile,false);
    fos.write(file.getBytes());
    fos.close();
    System.out.println("The File Uploaded Successfully");

}

    @DeleteMapping("/Delete/{id}")
    public void Imagesdelete(@PathVariable String id) throws IOException {
        Files.delete(Path.of("images" + "/" + id));
        System.out.println("Images have delete");
    }
}
