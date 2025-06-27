package br.com.leonardo.teste.exception.handler;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}
