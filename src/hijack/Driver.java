package hijack;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Driver
{
	public static void main(String[] args)
	{
		BetterR r = null;
		try {
			r = new BetterR();
		} catch (AWTException e) {
			System.out.println("Couldn't create robot");
			System.exit(0);
		}
//		boolean b=true;
//		//while(b)
//		{
//			try {
//			    URL myURL = new URL("http://wflewis.com/pebble/javacheck.php");
//			    URLConnection myURLConnection = myURL.openConnection();
//			    myURLConnection.connect();
//			    Scanner web = new Scanner(myURLConnection.getInputStream());
//			    if (web.hasNextLine())
//			    {
//			    	String s= web.nextLine();
//			    	System.out.println(s);
//			    	if (s.equals("p"))
//			    	{pauseItunes(r);returnBack(r);}
//			    	
//			    }
//			} 
//			catch (MalformedURLException e) { 
//			    System.out.println("Can't find URL");
//			} 
//			catch (IOException e) {   
//			    System.out.println("Broken Connection");
//			}
//		}
		
		
		pauseItunes(r);
		//r.delay(50);
		returnBack(r);
	}
	public static void pauseItunes(BetterR r)
	{
		r.keyPress(java.awt.event.KeyEvent.VK_META);
		r.keyPress(java.awt.event.KeyEvent.VK_SPACE);
		r.delay(25);
		r.keyRelease(java.awt.event.KeyEvent.VK_META);
		r.keyRelease(java.awt.event.KeyEvent.VK_SPACE);
		r.type("itunes");
		r.key(java.awt.event.KeyEvent.VK_ENTER);
		r.delay(200);
		r.key(java.awt.event.KeyEvent.VK_SPACE);
	}
	public static void returnBack(BetterR r)
	{
		r.keyPress(java.awt.event.KeyEvent.VK_META);
		r.key(java.awt.event.KeyEvent.VK_TAB);
		r.key(java.awt.event.KeyEvent.VK_TAB);
		r.delay(100);
		r.keyRelease(java.awt.event.KeyEvent.VK_META);
	}
	

}
