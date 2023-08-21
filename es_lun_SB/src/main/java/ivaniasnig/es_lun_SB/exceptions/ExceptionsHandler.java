package ivaniasnig.es_lun_SB.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;


@RestControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorPayload handleBadRequest(BadRequestException e) {
		return new ErrorPayload("BAD REQUEST ERROR -> " + e.getMessage());
	}

	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ErrorPayload handleUnauthorized(UnauthorizedException e) {
		return new ErrorPayload("UNAUTHORIZED -> " +e.getMessage());
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorPayload handleNotFound(NotFoundException e) {
		return new ErrorPayload("NOT FOUND -> " + e.getMessage());
	}


}