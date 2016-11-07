import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.List;

public class FinallyTest {

  public void testCatchFinally() {
    try {
      BufferedReader reader = new BufferedReader( new FileReader( "nofile.txt" ));
      reader.readLine();
    } catch( IOException iox ) {
      System.out.println( "\tIn the catch" );
    } finally {
      System.out.println( "\tIn the FINALLY" );
    }
  }

  public void testSystemExit() {
    try {
      BufferedReader reader = new BufferedReader( new FileReader( "nofile.txt" ));
      reader.readLine();
    } catch( IOException iox ) {
      System.out.println( "\tIn the catch" );
      System.exit( -1);
    } finally {
      System.out.println( "\tIn the FINALLY" );
    }
  }

  public void testReturnInCatch() {
    try {
      BufferedReader reader = new BufferedReader( new FileReader( "nofile.txt" ));
      reader.readLine();
    } catch( IOException iox ) {
      System.out.println( "\tIn the catch" );
      return;
    } finally {
      System.out.println( "\tIn the FINALLY" );
    }
  }

  public String testReturnInTry() {
    try {
      BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ));
      System.out.println( "\tDoing a readLine()" );
      return reader.readLine();
    } catch( IOException iox ) {
      System.out.println( "\tIn the catch" );
    } finally {
      System.out.println( "\tIn the FINALLY" );
    }
    return null;
  }

  public String testReturnInFinally() {
    try {
      BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ));
      System.out.println( "\treturning in try" );
      return "try";
    } finally {
      System.out.println( "\tIn the FINALLY" );
      return "finally";
    }
  }

  /**
   * purposelly throwing a NPE
   */
  public void testThrowException() {
    try { 
      List list = null;
      list.add( null );
      BufferedReader reader = new BufferedReader( new FileReader( "nofile.txt" ));
    } catch( FileNotFoundException fex ) {
      System.out.println( "\tIn the catch" );
    } finally {
      System.out.println( "\tIn the NPE FINALLY" );
    }
  }

  public void testThrowInCatch() {
    try { 
      BufferedReader reader = new BufferedReader( new FileReader( "nofile.txt" ));
    } catch( FileNotFoundException fex ) {
      System.out.println( "\tIn the catch" );
      throw new RuntimeException( "unchecked" );
    } finally {
      System.out.println( "\tIn the Throw In Catch FINALLY" );
    }
  }

  public static void main( String[] args ) {
    FinallyTest ft = new FinallyTest();

    System.out.println( "\nTest catch-finally");
    ft.testCatchFinally();

    System.out.println( "\nTest Return In Catch");
    ft.testReturnInCatch();

    System.out.println( "\nTest Return in Try");
    ft.testReturnInTry();
    System.out.println( "returned from Return in Try");

    System.out.println( "\nTest throw Exception");
    try {
      ft.testThrowException();
    } catch( NullPointerException npe ) {
      //catch the NPE so the whole program isn't killed
    }

    System.out.println( "\nTest Return in Finally");
    String value = ft.testReturnInFinally();
    System.out.println( "Returned ["+value+"]");

    System.out.println( "\nTest throw in Catch ");
    try {
      ft.testThrowInCatch();
    } catch( RuntimeException rex ) {
      // catch and ignore
    }

    System.out.println( "\nTest System Exit");
    ft.testSystemExit();
  }


}
