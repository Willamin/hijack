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
		if (!(args.length > 0))
		{
			System.out.println("No arguments!");
			System.exit(0);
		}
		for(String s : args[0].split("(?<!\\\\);"))
		{
			parseString(s, r);
		}
	}
	public static int escape(char c) 
	{
		switch (c)
		{
		case '#': //meta
			return java.awt.event.KeyEvent.VK_META;
		case 'r': //return
			return java.awt.event.KeyEvent.VK_ENTER;
		default: //others
			return -1;
		}
	}
	public static void parseString(String s, BetterR r)
	{
		System.out.println("command: "+s);
		for(int i=0;i<s.length();i++)
		{
			if (s.charAt(i) == '\\')
			{
				if (i+1>=s.length())
					break;
				int key=escape(s.charAt(i+1));
				if (key!=-1)
				{
					r.keyPress(key);
					r.keyRelease(key);
				}
				else
				{
					r.type(String.valueOf((char)key));
				}
				i++;
			}
			if (s.charAt(i) == '{')
			{
				//check for a } before we do anything
				boolean isthere=false;
				int close=i;
				for(int k=i;k<s.length();k++)
				{
					if (s.charAt(k)=='}')
					{
						isthere=true;
						close=k;
						break;
					}
				}
				if (!isthere)
				{
					System.out.println("Invalid syntax: didn't close brace");
					System.exit(0);
				}
				int c=0;
				for(int k=i+1;k<close;k++)
				{
					if (s.charAt(k)=='\\')
					{
						c=escape(s.charAt(k+1));
					}
					else
						c=s.charAt(k);
					r.keyPress(c);
				}
				for(int k=i+1;k<close;k++)
				{
					if (s.charAt(k)=='\\')
						c=escape(s.charAt(k+1));
					else
						c=s.charAt(k);
					r.keyRelease(c);
				}
			}
			else
			{
				r.type(String.valueOf(s.charAt(i)));
			}
		}
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
