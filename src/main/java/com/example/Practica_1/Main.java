package com.example.Practica_1;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class Main {

    private List<Cursos> listaCursos = new ArrayList<>();
    private List<Cursos> listaOriginal = new ArrayList<>();
    private int nextId = 1;

    public Main() {
        listaOriginal.add(new Cursos(1, "Java Basico", 40, "Principiante", "Carlos Perez", 150.0));
        listaOriginal.add(new Cursos(2, "Spring Boot", 30, "Intermedio", "Ana Gomez", 200.0));
        listaOriginal.add(new Cursos(3, "React JS", 25, "Principiante", "Luis Torres", 180.0));
        nextId = 4;
    }

    @GetMapping
    public List<Cursos> getAll() {
        List<Cursos> todos = new ArrayList<>();
        todos.addAll(listaOriginal);
        todos.addAll(listaCursos);
        return todos;
    }

    @GetMapping("/id/{id}")
    public Object getById(@PathVariable int id) {
        for (Cursos c : listaOriginal) {
            if (c.getId() == id) return c;
        }
        for (Cursos c : listaCursos) {
            if (c.getId() == id) return c;
        }
        return "Curso no encontrado con ID: " + id;
    }

    @GetMapping("/buscar")
    public List<Cursos> getByNombre(@RequestParam String nombre) {
        List<Cursos> resultado = new ArrayList<>();
        for (Cursos c : listaOriginal) {
            if (c.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(c);
            }
        }
        for (Cursos c : listaCursos) {
            if (c.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    @GetMapping("/agregados")
    public List<Cursos> getAgregados() {
        return listaCursos;
    }

    @PostMapping
    public Cursos create(@RequestBody Cursos curso) {
        curso.setId(nextId++);
        listaCursos.add(curso);
        return curso;
    }

    @PutMapping("/id/{id}")
    public String update(@PathVariable int id, @RequestBody Cursos nuevoCurso) {
        for (int i = 0; i < listaOriginal.size(); i++) {
            if (listaOriginal.get(i).getId() == id) {
                nuevoCurso.setId(id);
                listaOriginal.set(i, nuevoCurso);
                return "Curso actualizado: " + nuevoCurso.getNombre();
            }
        }
        for (int i = 0; i < listaCursos.size(); i++) {
            if (listaCursos.get(i).getId() == id) {
                nuevoCurso.setId(id);
                listaCursos.set(i, nuevoCurso);
                return "Curso actualizado: " + nuevoCurso.getNombre();
            }
        }
        return "Curso no encontrado con ID: " + id;
    }

    @DeleteMapping("/id/{id}")
    public String deleteById(@PathVariable int id) {
        for (int i = 0; i < listaOriginal.size(); i++) {
            if (listaOriginal.get(i).getId() == id) {
                Cursos eliminado = listaOriginal.remove(i);
                return "Curso eliminado: " + eliminado.getNombre();
            }
        }
        for (int i = 0; i < listaCursos.size(); i++) {
            if (listaCursos.get(i).getId() == id) {
                Cursos eliminado = listaCursos.remove(i);
                return "Curso eliminado: " + eliminado.getNombre();
            }
        }
        return "Curso no encontrado con ID: " + id;
    }
}