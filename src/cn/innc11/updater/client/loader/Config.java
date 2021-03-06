package cn.innc11.updater.client.loader;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;

public class Config
{
	public String host;
	public int port;
	public String launcherFileName;
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException
	{
		Config mconfig = new Config();
		
		mconfig.host = "127.0.0.1";
		mconfig.port = 5398;
		mconfig.launcherFileName = "null";
		
		Properties prop = new Properties();
		
		for(Field field : Config.class.getDeclaredFields())
		{
			int modifiers = field.getModifiers();
			if(Modifier.isPublic(modifiers) || !Modifier.isStatic(modifiers))
			{
				prop.put(field.getName(), String.valueOf(field.get(mconfig)));
			}
		}
		
		for(Object key : prop.keySet())
		{
			System.out.println(key+"="+prop.getProperty(key.toString()));
		}
		
	}
}
