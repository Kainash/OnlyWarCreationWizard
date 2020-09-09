import java.io.*;

public class FileOps {
	
	private File file;
	private String contents = "";
	private String name;
	
	
	public FileOps(String path) 
	{
		
		for (int i=path.length();i>=0;i++)
		{
			if (path.charAt(i) == '/')
			{
				break;
			}
			else
			{
				name = path.charAt(i) + name;
			}
		}
		
		file = new File(path);
		
		try
		{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null)
			{
				contents += line + '\n';
			}
			
			br.close();
			fr.close();
		}
		catch (Exception e)
		{
			try 
			{
				if (!file.createNewFile())
				{
					writeFile("");
				}
			} 
			catch (IOException e1) 
			{
				
			}
			contents = "";
		}
	}
	
	
	public FileOps (String path, String fName)
	{
		name = fName;
		file = new File(path + name);
		try 
		{
			if (!file.createNewFile())
			{
				writeFile("");
			}
		} 
		catch (IOException e) 
		{

		}
		contents = "";
	}
	
	
	public String getName()
	{
		return name;
	}
	
	
	public String getContents()
	{
		return contents;
	}
	
	
	public String getLine(int targetLine)
	{
		String temp = "";
		int i, currentLine = 0;
		
		for (i=0;i<contents.length();i++)
		{
			if (contents.charAt(i) == '\n')
			{
				if (currentLine == targetLine)
				{
					return temp;
				}
				else
				{
					temp = "";
					currentLine++;
				}
			}
			else
			{
				temp += contents.charAt(i);
			}
		}
		
		if (currentLine == targetLine)
		{
			return temp;
		}
		else
		{
			return null;
		}
	}
	
	
	public String getValue(String keyword)
	{
		keyword += ": ";
		int i=0;
		String line = getLine(i);
		String temp = "";
		
		while (line != null)
		{
			try
			{
				temp = line.substring(0, keyword.length());
			}
			catch (Exception e)
			{
				temp = "";
			}
			
			if (temp.equals(keyword))
			{
				try
				{
					temp = line.substring(keyword.length());
				}
				catch (Exception e)
				{
					temp = "";
				}
				
				return temp;
			}
			
			i++;
			line = getLine(i);
		}
		
		return null;
	}
	
	
	public void changeValue(String keyword, String value)
	{	
		keyword += ": ";
		int i=0;
		String line = getLine(i);
		String temp = "", newContents = "";
		Boolean found = false;
		
		while (line != null)
		{
			if (!found)
			{
				try
				{
					temp = line.substring(0, keyword.length());
				}
				catch (Exception e)
				{
					temp = "";
				}
				
				if (temp.equals(keyword))
				{
					line = keyword + value;
					found = true;
				}
			}
			
			newContents += line + '\n';
			
			i++;
			line = getLine(i);
		}
		
		if (!found)
		{
			newContents += keyword + value + '\n';
		}
		
		writeFile (newContents);
		
		return;
	}
	
	
	public void writeFile (String newContents)
	{
		try
		{
		FileWriter writer = new FileWriter(file);
		writer.write(newContents);
		contents = newContents;
		writer.close();
		}
		catch (Exception e)
		{
			
		}
		return;
	}
	
}
