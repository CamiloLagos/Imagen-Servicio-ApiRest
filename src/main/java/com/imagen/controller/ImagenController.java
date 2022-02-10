package com.imagen.controller;

import com.imagen.document.Imagen;
import com.imagen.servicio.ImagenService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/imagenes")
public class ImagenController {

    @Autowired
    ImagenService imagenService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Imagen> buscarImagen (@PathVariable("id")int id){
        log.info("Buscando la imagen con id {}", id);
        Imagen imagen = imagenService.buscarImagen(id);
        return ResponseEntity.ok(imagen);
    }

    @PostMapping
    public ResponseEntity<Imagen> crearImagen (@RequestBody Imagen imagen){
        log.info("Creando la imagen {}", imagen);
        Imagen imagen1 = imagenService.crearImagen(imagen);
        return ResponseEntity.ok(imagen1);
    }

//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Imagen>  borrarImagen (@PathVariable("id") int id){
//        log.info("Borrando la imagen con id {}", id);
//        return ResponseEntity.ok(imagenService.)
//    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Imagen>  actualizarImagen (@PathVariable("id") int id, @RequestBody String base64){
        log.info("Actualizando la imagen con id{}", id);
        Imagen imagen = new Imagen(id, base64);
        return ResponseEntity.ok(imagenService.crearImagen(imagen));
    }

}
