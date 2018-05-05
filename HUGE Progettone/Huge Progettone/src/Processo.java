
public class Processo 
{

	private int ID;
	private String nome;
	private String PCB;
	private int priorita;
	
	public Processo(int ID,String nome,String PCB,int priorita)
	{
		this.setID(ID);
		this.setNome(nome);
		this.setPCB(PCB);
		this.setPriorita(priorita);
	}
	
	public Processo()
	{
		
	}
	
	public Processo(Processo processo1)
	{
		this.ID=processo1.getID();
		this.nome=processo1.getNome();
		this.PCB=processo1.getPCB();
		this.priorita=processo1.getPriorita();
	}
	
	public boolean equals(Processo processo1)
	{
		if (this.ID==processo1.getID() && this.nome==processo1.getNome() && this.PCB==processo1.getPCB() && this.priorita==processo1.getPriorita()) 
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		String x;
		x="ID: "+this.ID+" Nome: "+this.nome+" PCB: "+this.PCB+" Priorità: "+this.priorita;
		return x;
	}
	
	public void esegui()
	{
		this.priorita=0;
	}

	public int getID() 
	{
		return ID;
	}

	public void setID(int iD) 
	{
		ID = iD;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getPCB() 
	{
		return PCB;
	}

	public void setPCB(String pCB) 
	{
		PCB = pCB;
	}

	public int getPriorita() 
	{
		return priorita;
	}

	public void setPriorita(int priorita) 
	{
		this.priorita = priorita;
	}
	
	
}

