import java.io.IOException;
import java.util.Scanner;

public class MainClass 
{

	public static void main(String[] args) throws NumberFormatException, IOException, Processi_Exception, ClassNotFoundException  
	{
		ConsoleInput tastiera = new ConsoleInput();
		ListaProcessi lista = new ListaProcessi();
		ListaProcessi listaTer = new ListaProcessi();
		Scanner tastiera1 = new Scanner(System.in);
		
		String[] s = new String[5];
		s[0]="Inserisci un nuovo Processo";
		s[1]="Termina un Processo";
		s[2]="Visualizza la coda dei Processi";
		s[3]="Context Switching";
		s[4]="Visualizza la lista dei Processi terminati";
		Menu menu1 =new Menu();
		
		Processo pr1=new Processo(1,"Microsoft Word","34bh",3);
		Processo pr2=new Processo(2,"Microsoft Excel","65bh",5);
		Processo pr3=new Processo(6,"Microsoft Power Point","78jk",1);
		Processo pr4=new Processo(63,"Adobe Photoshop","69lf",4);
		lista.inserisciInCoda(pr1);
		lista.inserisciInCoda(pr2);
		lista.inserisciInCoda(pr3);
		lista.inserisciInCoda(pr4);
		
		lista.salvaProcessi("ListaProcessi.txt");
		listaTer.salvaProcessi("ListaProcessiTer.txt");
		
		listaTer.caricaProcessi("ListaProcessiTer.txt");
		lista.caricaProcessi("ListaProcessi.txt");
		
		int selezione=0;
		
		do 
		{
			menu1.show(s);
			selezione=tastiera.readInt();
			
			switch (selezione) 
			{
			case 0:
				int ID=0;
				String nome="";
				String PCB="";
				int priorita=0;
				
				System.out.println("Inserisci l'ID del nuovo Processo");
				ID=tastiera.readInt();
				
				System.out.println("Inserisic il nome del nuovo Proceso");
				nome=tastiera.readString();
				
				System.out.println("Inserisci il PCB del nuovo Processo");
				PCB=tastiera.readString();
				
				System.out.println("Inserisci la priorità del nuovo Processo");
				priorita=tastiera.readInt();
				
				Processo p1=new Processo(ID,nome,PCB,priorita);
				lista.inserisciInTesta(p1);
				
				lista.salvaProcessi("ListaProcessi.txt");
				
				break;
			case 1:
			{
				Menu menu2 = new Menu();
				String[] s2 = new String[3]; 
				int selezione2;
				
				s2[0]="Eliminare il Processo in testa";
				s2[1]="Eliminare il Processo in coda";
				s2[2]="Eliminare un Processso in una posizione centrale";
				
				menu2.show(s2);
				selezione2=tastiera.readInt();
				
				switch (selezione2) 
				{
				case 0:
					
					listaTer.inserisciInTesta(lista.getProcesso(1));
					listaTer.salvaProcessi("ListaPtocessiTer.txt");
					
					lista.eliminaInTesta();
					System.out.println("Processo eliminato con successo");
					lista.salvaProcessi("ListaProcessi.txt");
					tastiera1.nextLine();
					
					break;
				case 1:
					listaTer.inserisciInTesta(lista.getProcesso(lista.getElementi()));
					listaTer.salvaProcessi("ListaPtocessiTer.txt");
					
					lista.eliminaInCoda();
					System.out.println("Processo eliminato con successo");
					lista.salvaProcessi("ListaProcessi.txt");
					tastiera1.nextLine();
					
					break;
					
				case 2:
					
					int ID1;
					System.out.println("Inserisci l'ID del Processo da eliminare");
					ID1=tastiera.readInt();

					for (int i = 1; i < lista.getElementi(); i++) 
					{
						if (lista.getProcesso(i).getID()==ID1) 
						{
							listaTer.inserisciInTesta(lista.getProcesso(i));
							listaTer.salvaProcessi("ListaProcessiTer.txt");
							
							lista.eliminaInPosizione(i);
							System.out.println("Processo eliminato con successo");
						}else
						{
							System.out.println("Processo non presente nella lista");
						}
					}
					lista.salvaProcessi("ListaProcessi.txt");
					
					break;

				default:
					break;
				}
			}
			case 2:
				for (int i = 1; i < lista.getElementi()+1; i++) 
				{
					System.out.println(lista.visita(i));
				}
				
				break;
			case 3:
				
				System.out.println("Assegnazione del processore al processo:");
				System.out.println(lista.getProcesso(1));
				
				tastiera1.nextLine();
				
				System.err.println("Context Switch avvenuto");
				lista.getProcesso(1).setPriorita(0);
				
				
			default:
				break;
			}
			
		} while (selezione==0 && selezione==1 && selezione==2 && selezione==3 && selezione==4);
		System.out.println("Arrivederci è stato bello");
	}

}
