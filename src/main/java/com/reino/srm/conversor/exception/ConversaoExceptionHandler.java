package com.reino.srm.conversor.exception;

import com.reino.srm.conversor.dto.ApiErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ConversaoExceptionHandler {

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<ApiErrorDTO> handleProdutoNaoEncontrado(ProdutoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

    @ExceptionHandler(MoedaNaoEncontradaException.class)
    public ResponseEntity<ApiErrorDTO> handleMoedaNaoEncontrada(MoedaNaoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

    @ExceptionHandler(TaxaCambioNaoEncontradaException.class)
    public ResponseEntity<ApiErrorDTO> handleTaxaNaoEncontrada(TaxaCambioNaoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

    @ExceptionHandler(ProdutoInvalidoException.class)
    public ResponseEntity<ApiErrorDTO> handleProdutoInvalido(ProdutoInvalidoException ex) {
        return ResponseEntity.badRequest()
                .body(new ApiErrorDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler(ErroPersistenciaProdutoException.class)
    public ResponseEntity<ApiErrorDTO> handleErroPersistencia(ErroPersistenciaProdutoException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }

    @ExceptionHandler(MoedaInvalidaException.class)
    public ResponseEntity<ApiErrorDTO> handleMoedaInvalida(MoedaInvalidaException ex) {
        return ResponseEntity.badRequest()
                .body(new ApiErrorDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler(ErroPersistenciaMoedaException.class)
    public ResponseEntity<ApiErrorDTO> handleErroPersistenciaMoeda(ErroPersistenciaMoedaException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }

    @ExceptionHandler(TaxaCambioInvalidaException.class)
    public ResponseEntity<ApiErrorDTO> handleTaxaCambioInvalida(TaxaCambioInvalidaException ex) {
        return ResponseEntity.badRequest()
                .body(new ApiErrorDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler(ErroPersistenciaTaxaCambioException.class)
    public ResponseEntity<ApiErrorDTO> handleErroPersistenciaTaxaCambio(ErroPersistenciaTaxaCambioException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDTO> handleGeneric(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Erro interno: " + ex.getMessage()));
    }

}
