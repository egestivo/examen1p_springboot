package ec.estivo.edu.elona_prueba1.service.impl;

import ec.estivo.edu.elona_prueba1.domain.Loan;
import ec.estivo.edu.elona_prueba1.dto.LoanCreateRequest;
import ec.estivo.edu.elona_prueba1.dto.LoanReportResponse;
import ec.estivo.edu.elona_prueba1.dto.LoanResponse;
import ec.estivo.edu.elona_prueba1.dto.LoanUpdateRequest;
import ec.estivo.edu.elona_prueba1.repository.LoanRepository;
import ec.estivo.edu.elona_prueba1.service.LoanService;
import ec.estivo.edu.elona_prueba1.web.advice.ConflictException;
import ec.estivo.edu.elona_prueba1.web.advice.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    // Inyección de dependencias
    private final LoanRepository repo;

    public LoanServiceImpl(LoanRepository repo) {
        this.repo = repo;
    }

    // listar un libro
    @Override
    public LoanResponse findById(Long id) {
        // validar que exista, si no 404
        Loan l = repo.findById(id).orElseThrow(() -> new NotFoundException("Libro no existe"));

        return toResponse(l);
    }

    // listar todos
    @Override
    public List<LoanResponse> findAll() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public LoanResponse create(LoanCreateRequest request) {

        // crea la entidad loan
        Loan l = new Loan();
        l.setBookTitle(request.getBookTitle());
        l.setBorrowerName(request.getBorrowerName());
        l.setLoanDate(request.getLoanDate());
        l.setReturned(false);

        // guardar
        Loan saved = repo.save(l);
        return toResponse(saved);
    }

    @Override
    public LoanResponse update(Long id, LoanUpdateRequest request) {
        // Actualizar todos los campos, debe existir el libro a actualizar
        Loan l = repo.findById(id).orElseThrow(() -> new NotFoundException("Libro no existe"));

        // aplican cambios
        l.setBookTitle(request.getBookTitle());
        l.setBorrowerName(request.getBorrowerName());
        l.setLoanDate(request.getLoanDate());

        if (Boolean.TRUE.equals(request.getReturned()) && request.getReturnedDate() == null) {
            throw new ConflictException("Si el libro fue devuelto proporcione una fecha de devolución");
        }

        // validar la fecha nuevamente, pero para que la fecha no sea anterior a la fecha de préstamo
        if( request.getReturnedDate() != null && request.getReturnedDate().isBefore(request.getLoanDate())) {
            throw new ConflictException("La fecha de devolución no puede ser anterior a la fecha de préstamo");
        }

        l.setReturnDate(request.getReturnedDate());
        l.setReturned(request.getReturned());

        return toResponse(repo.save(l));

    }


    @Override
    public LoanResponse devuelto(Long id) {
        // debe existir el libro a actualizar
        Loan l = repo.findById(id).orElseThrow(() -> new NotFoundException("Libro no existe"));

        // aplican cambios
        l.setReturned(true);
        l.setReturnDate(LocalDate.now());

        Loan updated = repo.save(l);
        return toResponse(updated);
    }

    // reporte de libros
    @Override
    public LoanReportResponse getLoanReport(){
        // contadores independientes
        long total = repo.count();
        long returned = repo.countByReturnedTrue();
        long pending = repo.countByReturnedFalse();

        // crear respuesta
        return new LoanReportResponse(total, returned, pending);
    }

    // mapeo de entity a dto salida
    private LoanResponse toResponse(Loan l) {
        LoanResponse r = new LoanResponse();
        r.setId(l.getId());
        r.setBookTitle(l.getBookTitle());
        r.setBorrowerName(l.getBorrowerName());
        r.setReturnDate(l.getReturnDate());
        r.setReturned(l.getReturned());
        return r;
    }


}
