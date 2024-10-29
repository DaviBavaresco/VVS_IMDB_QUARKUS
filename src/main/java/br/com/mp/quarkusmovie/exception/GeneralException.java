package br.com.mp.quarkusmovie.exception;

import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GeneralException implements ExceptionMapper<Exception> {
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(Exception e) {

        MessageError messageError = new MessageError();

        if (e instanceof BusinessException) {
            messageError.setMessage(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(messageError).build();
        }

        if (e instanceof NotAuthorizedException) {
            messageError.setMessage("Erro ao validar as credenciais.");
            return Response.status(Response.Status.BAD_REQUEST).entity(messageError).build();
        }

        messageError.setMessage("Erro: Por favor entre em contato com o suporte.");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(messageError).build();
    }
}
