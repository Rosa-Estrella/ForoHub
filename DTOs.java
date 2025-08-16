package com.alura.foro.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        String autor) {}



package com.alura.foro.dto;

public record DatosRespuestaTopico(Long id, String titulo, String mensaje, String autor) {}



package com.alura.foro.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizarTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje) {}
