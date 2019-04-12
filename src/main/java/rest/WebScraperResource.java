package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import webscraber.TagCounter;
import webscraber.TagCounterCallable;

@Path("scrape")
public class WebScraperResource {

  @Context
  private UriInfo context;

  public WebScraperResource() {
  }
  /* READ BELOW BEFORE YOU START
  // This part does not work with Tomcat 8.0.27 (default Tomcat with NetBeans)
  // If you wan't to test async Jersey endpoints upgrade your Tomcat Server (Tested with 8.5.54)
   
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("slow")
  public void getAllOrders(@Suspended final AsyncResponse ar) {

    ExecutorService es = Executors.newSingleThreadExecutor();
    es.submit(new Runnable() {
      @Override
      public void run() {
        try {
          //Simulating a long running process
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          System.out.println("UPS" + e);
        }
        ar.resume("{\"msg\":\"This response was delayed two seconds\"}");
        es.shutdown();
      }
    });
  }

  @GET
  @Path("veryslow")
  @Produces(MediaType.APPLICATION_JSON)
  public void asyncGetWithTimeout(@Suspended final AsyncResponse asyncResponse) {
    asyncResponse.setTimeoutHandler(new TimeoutHandler() {
      @Override
      public void handleTimeout(AsyncResponse asyncResponse) {
        asyncResponse.resume(Response.status(Response.Status.SERVICE_UNAVAILABLE)
                .entity("{\"msg\":\"Operation timeout - Shit happens ;-)\"}").build());
      }
    });
    asyncResponse.setTimeout(5, TimeUnit.SECONDS);

    new Thread(new Runnable() {
      @Override
      public void run() {
        String result;
        try {
          result = veryExpensiveOperation();
          asyncResponse.resume(result);
        } catch (InterruptedException ex) {
          Logger.getLogger(WebScraperResource.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      private String veryExpensiveOperation() throws InterruptedException {
        Thread.sleep(5500);
        return "{\"msg\":\"This response was delayed two seconds\"}";
      }
    }).start();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("tags")
  public void getTags(@Suspended final AsyncResponse asyncResponse) {
    asyncResponse.resume(makeResponse());
  }
  */
  
  
  //If you have upgraded your Tomcat Server, remove this method and use the async version above
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("tags1")
  public String getTags() {
    return makeResponse();
  }

  private String makeResponse() {
    return "{\"todo\":\"Make me return the calculated values from the external requests\"}";
  }

}
