
public class Nodo 
{
	private Processo info;
	private Nodo link;
	
	public Nodo(Processo pr1)
	{
		setInfo(pr1);
		link=null;
	}

	public Processo getInfo() 
	{
		return info;
	}

	public void setInfo(Processo info) 
	{
		this.info = info;
	}

	public Nodo getLink() 
	{
		return link;
	}

	public void setLink(Nodo link) 
	{
		this.link = link;
	}
	
	
}
