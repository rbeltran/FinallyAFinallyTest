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
      System.out.println( "In the catch" );
    } finally {
      System.out.println( "In the FINALLY" );
    }
  }

  public void testSystemExit() {
    try {
      BufferedReader reader = new BufferedReader( new FileReader( "nofile.txt" ));
      reader.readLine();
    } catch( IOException iox ) {
      System.out.println( "In the catch" );
      System.exit( -1);
    } finally {
      System.out.println( "In the FINALLY" );
    }
  }

  public void testReturnInCatch() {
    try {
      BufferedReader reader = new BufferedReader( new FileReader( "nofile.txt" ));
      reader.readLine();
    } catch( IOException iox ) {
      System.out.println( "In the catch" );
      return;
    } finally {
      System.out.println( "In the FINALLY" );
    }
  }

  public String testReturnInTry() {
    try {
      BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ));
      System.out.println( "Doing a readLine()" );
      return reader.readLine();
    } catch( IOException iox ) {
      System.out.println( "In the catch" );
    } finally {
      System.out.println( "In the FINALLY" );
    }
    return null;
  }

  public void testThrowException() {
    try { 
      List list = null;
      list.add( null );
      BufferedReader reader = new BufferedReader( new FileReader( "nofile.txt" ));
    } catch( FileNotFoundException fex ) {
      System.out.println( "In the catch" );
    } finally {
      System.out.println( "In the NPE FINALLY" );
    }
  }

  public static void main( String[] args ) {
    FinallyTest ft = new FinallyTest();

    System.out.println( "Test catch-finally");
    ft.testCatchFinally();

    System.out.println( "Test Return In Catch");
    ft.testReturnInCatch();

    System.out.println( "Test Return in Try");
    ft.testReturnInTry();
    System.out.println( "returned from Return in Try");

    System.out.println( "Test throw Exception");
    ft.testThrowException();
  }


}
