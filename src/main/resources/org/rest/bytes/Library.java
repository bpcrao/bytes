package org.rest.bytes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/library")
public class Library {

    private Map<String, Book> books;

    public Library() {
        books = new HashMap<String, Book>();
    }

    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        List<Book> booksList = new ArrayList<Book>();
        booksList.addAll(books.values());
        System.out.println("getting books"+booksList);
        return booksList;
    }

    @GET
    @Path("/books/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook(@PathParam("isbn") String id) {
        return books.get(id);
    }

    @POST
    @Path("/books/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_XML)
    public Book addBook(@PathParam("isbn") String id, @QueryParam("title") String title) {
        System.out.println("adding book title "+title);
        Book e = new Book();
        e.setISBN(id);
        e.setTitle(title);
        books.put(id, e);
        System.out.println("has id "+books.containsKey(id));
        return e;
    }

    @PUT
    @Path("/books/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book updateBook(@PathParam("isbn") String id, @QueryParam("title")  String title) {        
        Book e = books.get(id);
        e.setTitle(title);
        books.put(id, e);
        return e;
    }

    @DELETE
    @Path("/books/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book removeBook(@PathParam("isbn") String id) {
        System.out.println("deleteing id "+id);
        System.out.println(books.containsKey(id));
        return books.remove(id);
    }
}
