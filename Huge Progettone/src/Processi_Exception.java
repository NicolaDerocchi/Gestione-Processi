
public class Processi_Exception extends Exception 
{
	private String messaggio;
	
	public Processi_Exception(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
}