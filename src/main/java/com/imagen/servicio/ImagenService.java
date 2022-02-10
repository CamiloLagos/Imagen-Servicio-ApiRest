package com.imagen.servicio;

import com.imagen.document.Imagen;
import com.imagen.repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenService {
    @Autowired
    private ImagenRepository imagenRepository;

    public Imagen buscarImagen(int id){
        return imagenRepository.findById(id).orElseThrow(()->
             new RuntimeException("No se encontro la imagen")
        );
    }

    public Imagen crearImagen(Imagen imagen){
        Imagen imagenActual = new Imagen(imagen.getId(),imagen.getBase64());
        imagenRepository.save(imagenActual);
        return imagenActual;
    }

}
