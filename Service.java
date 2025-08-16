package com.alura.foro.service;

import com.alura.foro.dto.*;
import com.alura.foro.model.Topico;
import com.alura.foro.repository.TopicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicoService {
    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository) {
        this.repository = repository;
    }

    public List<DatosRespuestaTopico> listar() {
        return repository.findAll().stream()
                .map(t -> new DatosRespuestaTopico(t.getId(), t.getTitulo(), t.getMensaje(), t.getAutor()))
                .toList();
    }

    public DatosRespuestaTopico obtener(Long id) {
        Topico t = repository.findById(id).orElseThrow();
        return new DatosRespuestaTopico(t.getId(), t.getTitulo(), t.getMensaje(), t.getAutor());
    }

    @Transactional
    public DatosRespuestaTopico crear(DatosRegistroTopico datos) {
        Topico t = new Topico();
        t.setTitulo(datos.titulo());
        t.setMensaje(datos.mensaje());
        t.setAutor(datos.autor());
        repository.save(t);
        return new DatosRespuestaTopico(t.getId(), t.getTitulo(), t.getMensaje(), t.getAutor());
    }

    @Transactional
    public DatosRespuestaTopico actualizar(Long id, DatosActualizarTopico datos) {
        Topico t = repository.findById(id).orElseThrow();
        t.setTitulo(datos.titulo());
        t.setMensaje(datos.mensaje());
        return new DatosRespuestaTopico(t.getId(), t.getTitulo(), t.getMensaje(), t.getAutor());
    }

    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
