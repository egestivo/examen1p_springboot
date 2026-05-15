package ec.estivo.edu.elona_prueba1.service;

import ec.estivo.edu.elona_prueba1.dto.LoanCreateRequest;
import ec.estivo.edu.elona_prueba1.dto.LoanReportResponse;
import ec.estivo.edu.elona_prueba1.dto.LoanResponse;
import ec.estivo.edu.elona_prueba1.dto.LoanUpdateRequest;

import java.util.List;

public interface LoanService{

    // listar uno
    LoanResponse findById(Long id);

    // listar todos los libros prestados
    List<LoanResponse> findAll();


    // Crear un libro
    LoanResponse create(LoanCreateRequest request);

    // actualizar un libro (put)
    LoanResponse update(Long id, LoanUpdateRequest request);

    // actualizar estado (patch)
    LoanResponse devuelto(Long id);

    // Crear reporte
    LoanReportResponse getLoanReport();

}
