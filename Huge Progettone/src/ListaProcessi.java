
public class ListaProcessi 
{

		private Nodo head;
		private int elementi;
		
		public ListaProcessi()
		{
			head=null;
			elementi=0;
		}
		
		public int getElementi()
		{
			return elementi;
		}
		
		private Nodo creaNodo(Processo pr1, Nodo link)
		{
			Nodo nodo= new Nodo(pr1);
			nodo.setLink(link);
			return nodo;
		}
		
		private Nodo getLinkPosizione(int posizione) throws Processi_Exception
		{
			
			Nodo p;
			int n;
			p=head;
			n=1;
			
			if (posizione<1 || posizione>getElementi())
				throw new Processi_Exception("Posizione non valida");
			if (elementi==0)
				throw new Processi_Exception("Lista vuota");
				
			while(p.getLink()!=null && n<posizione)
			{
				p=p.getLink();	//p va a puntare al nodo successivo
				n++;
			}
			
			return p;
		}
		
		public void inserisciInTesta (Processo pr1)
		{
			
			Nodo p=creaNodo(pr1, head);
			head=p;
			elementi++;
		}
		
		public String toString()
		{
			String risultato="Head";
			if (elementi==0)
				return risultato+="-->";
			Nodo p=head;
			while (p!=null)
			{
				risultato+="-->"+p.getInfo().toString();
				p=p.getLink();
			}
			return risultato;
		}
		
		public void inserisciInCoda(Processo pr1) throws Processi_Exception
		{
			if(elementi==0)
			{
				inserisciInTesta(pr1);
				return;
			}
			
			Nodo pn=creaNodo(pr1, null);
			Nodo p=getLinkPosizione(elementi);
			p.setLink(pn);
			elementi++;	
		}
		
		public void inseriscInPosizione(Processo pr1,int posizione) throws Processi_Exception
		{
			if (posizione<=1)
			{
				inserisciInTesta(pr1);
				return;
			}
			if (posizione>elementi)
			{
				inserisciInCoda(pr1);
				return;
			}
			
			Nodo pn=creaNodo(pr1, getLinkPosizione(posizione));
			Nodo precedente=getLinkPosizione(posizione-1);
			precedente.setLink(pn);
			elementi++;
		}
		
		public void eliminaInTesta() throws Processi_Exception
		{
			if (elementi==0)
				throw new Processi_Exception("Lista vuota");
			head=head.getLink();
			elementi--;
		}
		
		public void eliminaInCoda() throws Processi_Exception
		{
			if (elementi==0)
				throw new Processi_Exception("Lista vuota");
			if (elementi==1)
			{
				eliminaInTesta();
				return;
			}
			
			Nodo p=getLinkPosizione(elementi-1);
			p.setLink(null);
			elementi--;
		}
		
		public void eliminaInPosizione(int posizione) throws Processi_Exception
		{
			if (elementi==0)
				throw new Processi_Exception("Lista vuota");
			
			if (posizione<=0 || posizione>elementi)
				throw new Processi_Exception("Posizione non valida");
		
			if (posizione==1)
			{
				eliminaInTesta();
				return;
			}
			if (posizione==elementi)
			{
				eliminaInCoda();
				return;
			}
			
			Nodo p;
			p=getLinkPosizione(posizione);
			Nodo precedente=getLinkPosizione(posizione-1);
			precedente.setLink(p.getLink());
			elementi--;
			
		}
		
		public String visita (int posizione) throws Processi_Exception
		{
			if (elementi==0)
				throw new Processi_Exception("Lista vuota");
			
			if (posizione<=0 || posizione>elementi)
				throw new Processi_Exception("Posizione non valida");
			
			Nodo p=getLinkPosizione(posizione);
			return p.getInfo().toString();		
		}
		
		public Processo getProcesso (int posizione) throws Processi_Exception
		{
			if (elementi==0)
				throw new Processi_Exception("Lista vuota");
			
			if (posizione<=0 || posizione>elementi)
				throw new Processi_Exception("Posizione non valida");
			
			Nodo p=getLinkPosizione(posizione);
			return p.getInfo();		
		}
		
}


