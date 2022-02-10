package com.imagen.document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;


@Data
@NoArgsConstructor
@Document(collection = "imagen")
public class Imagen {

    @Id
    private int id;
    private String base64;

    public Imagen(int id, String base64) {
        this.id = id;
        this.base64 = base64;
        convertir();
    }

    public void convertir() {
        //Codificando la imagen
        InputStream is;
        try {
            is = new FileInputStream(base64);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error leyendo la imagen...");
        }

        byte[] arrayBytes;
        try {
            arrayBytes = IOUtils.toByteArray(is);
        } catch (IOException e) {
            throw new RuntimeException("Error convirtiendo la imagen...");
        }

        this.base64 = Base64.getEncoder().encodeToString(arrayBytes);
    }

//    public void decode() throws IOException {
//        //Decodificar la imagen de base64
//        //byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64);
//        //BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
//        //ImageIO.write(img, "jpg", new File("C:\\Users\\Juan.Lagos\\IdeaProjects\\Proyect\\src\\main\\resources\\img\\img.jpg"));
//    }
}