package org.example;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "libreria")
public class Libreria {
    private String nombre;
    private String lugar;
    private List<Libro> libros = new ArrayList<>();

    public Libreria() {
    }

    public Libreria(String nombre, String lugar) {
        this.nombre = nombre;
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @XmlElementWrapper(name = "Libros")
    @XmlElement(name = "libro")
    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public void mostrarTitulos() {
        System.out.println("Títulos de los libros:");
        for (Libro l : libros) {
            System.out.println(l.getTitulo());
        }
    }

    public void mostrarLibrosPorAutor(String autor) {
        boolean hay = false;
        for (Libro l : libros) {
            if (l.getAutor().equalsIgnoreCase(autor)) {
                System.out.println(l);
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay libros de ese autor");
        }
    }
}
