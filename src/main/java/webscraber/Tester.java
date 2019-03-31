package webscraber;

import java.util.ArrayList;
import java.util.List;

public class Tester {

  private List<TagCounter> urls = new ArrayList();

   public void runSequental()  {
    List<TagCounter> urls = new ArrayList();
    urls.add(new TagCounter("https://www.fck.dk"));
    urls.add(new TagCounter("https://www.google.com"));
    urls.add(new TagCounter("https://politiken.dk"));
    urls.add(new TagCounter("https://cphbusiness.dk"));
    for (TagCounter tc : urls) {
      tc.doWork();
      System.out.println("Title: " + tc.getTitle());
      System.out.println("Div's: " + tc.getDivCount());
      System.out.println("Body's: " + tc.getBodyCount());
      System.out.println("----------------------------------");
    }
  }
  
  public void runParrallel()  {
    
  }

  public static void main(String[] args) {
    long timeSequental;
    long timeParallel;
    long start = System.nanoTime();
    
    new Tester().runSequental();
    
    long end = System.nanoTime();
    timeSequental = end - start;
    System.out.println("Time Sequential: "+((timeSequental)/1_000_000)+ " ms.");
    
    /*
    start = System.nanoTime();
    //TODO Add your parrallel calculation here
    end = System.nanoTime();
    timeParallel = end - start;
    System.out.println("Time Parallel: "+((timeParallel)/100_000_000)+" ms.);
    
    System.out.println("Paralle was "+timeSequental/timeParallel + " times faster");
   */
 
  }
}
