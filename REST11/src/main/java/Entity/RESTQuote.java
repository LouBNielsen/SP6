/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author LouiseB
 */
@Path("quote")
public class RESTQuote
{

    @Context
    private UriInfo context;

    private static Map<Integer, String> quotes = new HashMap()
    {
        {
            put(1, "Friends are kisses blown to us by angels");
            put(2, "Do not take life too seriously. You will never get out of it alive");
            put(3, "Behind every great man, is a woman rolling her eyes");
            put(4, "I am a quote you can delete");
            put(5, "I am a quote you can delete");

        }
    };

    public RESTQuote()
    {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String getQuote(@PathParam("id") int id)
    {
        int key = id;
        JsonObject quote = new JsonObject();
        quote.addProperty("quote", quotes.get(key));
        String jsonQuote = new Gson().toJson(quote);
        return jsonQuote;

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("random")
    public String getRandomQuote()
    {

        Random rand = new Random();
        JsonObject quote = new JsonObject();
        quote.addProperty("quote", quotes.get(rand.nextInt(quotes.size()) + 1));
        String jsonQuote = new Gson().toJson(quote);
        return jsonQuote;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("add")
    public String postQuote(String content)
    {
        System.out.println("postQuote");
        JsonObject jo = new JsonParser().parse(content).getAsJsonObject();

        if (jo.has("quote"))
        {
            quotes.put(quotes.size() + 1, jo.get("quote").getAsString());
        }
        jo.addProperty("id", quotes.size());

        return jo.toString();

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String putQuote(@PathParam("id") int id, String content)
    {
        JsonObject jo = new JsonParser().parse(content).getAsJsonObject();
        String quote = jo.get("quote").getAsString();

        if (id <= quotes.size() && jo.has("quote"))
        {
            quotes.put(id, quote);

        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", id);
        jsonObject.addProperty("quote", quotes.get(id));
        String jsonQuote = new Gson().toJson(jsonObject);
        return jsonQuote;

    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void deleteQuote(@PathParam("id") int id)
    {
        System.out.println("deleteQuote");

        quotes.remove(id);

    }

}
