package org.example;

import jakarta.xml.bind.*;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JAXBException {
        JAXBContext contexto = JAXBContext.newInstance(Libreria.class);
        File archivo = new File("libreria.xml");
        Libreria libreria;
        if (!archivo.exists()) {
            libreria = new Libreria("Las hojas", "Calle Madrid");
            libreria.getLibros().add(new Libro("Cervantes", "Quijote", "El Barco de Vapor", "1234", 19.9, 1605));
            libreria.getLibros().add(new Libro("Fernando de Rojas", "La Celestina", "Hacendado", "4321", 14.5, 1499));

            Marshaller m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(libreria, archivo);
            System.out.println("Archivo creado");
        } else {
            Unmarshaller um = contexto.createUnmarshaller();
            libreria = (Libreria) um.unmarshal(archivo);
            System.out.println("Archivo leído");
        }
        System.out.println("----------------------");
        libreria.mostrarTitulos();

        System.out.println("----------------------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe un autor: ");
        String autor = sc.nextLine();
        libreria.mostrarLibrosPorAutor(autor);

        //Añadir nuevo libro
        System.out.println("----------------------------");
        Libro nuevo = new Libro("Nome Lose Marquex", "Capitan Calzoncillos", "Anaya", "6666", 10.00, 2005);
        libreria.getLibros().add(nuevo);

        //Guardamos el xml
        Marshaller m = contexto.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(libreria, archivo);
        System.out.println("--Libro: " + nuevo + " guardado --");

        System.out.println("Mostramos de nuevo la lsita de vídeos:");
        libreria.mostrarTitulos();
    }
}

