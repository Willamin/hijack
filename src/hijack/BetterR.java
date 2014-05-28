package hijack;

import java.awt.AWTException;
import java.awt.Robot;

public class BetterR extends Robot
	{

		public BetterR() throws AWTException {
			super();
		}
		public void key(int keyCode)
		{
			//System.out.println("Pressing: "+keyCode);
			keyPress(keyCode);
			delay(25);
			keyRelease(keyCode);
		}
		public void type(String input)
		{
			//System.out.println("Trying to type: "+input);
			for(int i=0;i<input.length();i++)
			{
				String s=input.substring(i,i+1);
				
				if (s.equals(s.toUpperCase()))
				{
					keyPress(java.awt.event.KeyEvent.VK_SHIFT);
				}
				
				key(s.toUpperCase().charAt(0));
				
				if (s.equals(s.toUpperCase()))
				{
					keyRelease(java.awt.event.KeyEvent.VK_SHIFT);
				}
			}
		}
	}