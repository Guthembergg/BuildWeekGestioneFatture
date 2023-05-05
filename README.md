# BuildWeekGestioneFatture

Nel seguente file sono presenti le spiegazioni dei vari metodi della collection creata appositamente per il progetto
su Postman:

Successivamente vengono riportate le varie richieste che sono possibili effetuare in formato :

- nome richiesta;
- URL Richiesta;
- tipo richiesta (POST, PUT , GET, DELETE);
- metodo per effettuare la richiesta;
- Autenticazione necessaria per effettuare tale richiesta;


- Metodo "RegistraDipendente" :
		
		URL: localhost:8080/api/auth/register;
		
  		Tipo di Richiesta : "POST";
  	
  		Metodo per effettuare la registrazione di un Dipendente sul database;
  		
  		Richieste necessarie : NESSUNA;
  		
  		Autenticazioni necessarie: nessuna;
  	
  	
- Metodo "LoginDipendente":

		URL: localhost:8080/api/auth/login;
	 
 		Tipo di Richiesta : "POST";
 		
 		Metodo per effettuare il login utile per poter accedere a tutte le funzionalità di lettura (GET)
 		delle API;
 		
 		Richieste necessarie: Richiede di specificare nel body della chiamata un username utente (impostato precedentemente
 		tramite metodo apposito) e password impostati;
 		
 		Autenticazioni necessarie: nessuna;
 		
 		
- Metodo "UploadCsvProvince" :

		 URL : localhost:8080/province/upload

		 Tipo di Richiesta : "POST";
		 
		 Metodo per inserire dei dati presenti su un file CSV esterno e/o non presenti sul database;
		 
		 Richieste necessarie: Per utilizzare tale metodo impostare su Postman, nella sezione "form-data",
		 un dato composto da chiave-valore. Nel parametro "Key" inserire un nome da associare al file da importare, 
		 nel parametro "Value" selezinare il file da importare ;
		 
		 Autenticazioni necessarie: nessuna;
		 
		 
 - Metodo "UploadCsvComune" :
 
 		  URL: localhost:8080/comuni/upload;
 		
 		  Tipo di Richiesta : "POST";
 		  
 		 Metodo per inserire dei dati presenti su un file CSV esterno e/o non presenti sul database;
 		  
 		 Richieste necessarie: Per utilizzare tale metodo impostare su Postman, nella sezione "form-data",
		 un dato composto da chiave-valore. Nel parametro "Key" inserire un nome da associare al file da importare, 
		 nel parametro "Value" selezinare il file da importare ;
		 
		 Autenticazioni necessarie: nessuna;
		 
		 
 - Metodo "TuttiClienti":
 
 		URL : localhost:8080/clienti/lista;
 		
 		Tipo di Richiesta : "GET";
 		
 		Metodo per leggere tutti i clienti presenti nel database;
 		
 		Autenticazioni necessarie: User;
 		
 		
- Metodo "TuttiClienti(pag)":
 
 		URL :localhost:8080/clienti/paginazione?size=5&page=0;
 		
 		Tipo di Richiesta : "GET";
 		
 		Metodo per leggere tutti i clienti presenti nel database suddivisi tramite paginazione;
 		
 		Autenticazioni necessarie: User;
 		
 		
- Metodo "OrdinaClientiPerNome":
 
 		URL :localhost:8080/clienti/paginazione/nomi;
 		
 		Tipo di Richiesta : "GET";
 		
 		Metodo per leggere tutti i clienti presenti nel database ordinati e suddivisi tramite paginazione;
 		
 		Autenticazioni necessarie: User;
 		
 		
 		
- Metodo "OrdinaClientiPerFatturato":
 
 		URL :localhost:8080/clienti/paginazione/fatturato;
 		
 		Tipo di Richiesta : "GET";
 		
 		Metodo per leggere il fatturato dei clienti presenti nel database ordinati e suddivisi tramite paginazione;
 		
 		Autenticazioni necessarie: User;
 		
 		
- Metodo "OrdinaClientiPerDataInserimento":
 
 		URL :localhost:8080/clienti/paginazione/data_ins;
 		
 		Tipo di Richiesta : "GET";
 		
 		Metodo per leggere i clienti presenti nel database ordinati per data di inserimento e suddivisi tramite paginazione;
 		
 		Autenticazioni necessarie: User;
 		
 		
- Metodo "OrdinaClientiPerUltimoContatto" :

		URL :localhost:8080/clienti/paginazione/data_ult;
		
		Tipo di Richiesta : "GET";
		
		Metodo per leggere i clienti in base all'ultimo contatto;
		
		Autenticazioni necessarie: User;
		
		
		
- Metodo "OrdinaClientiPerProvincia" :

		URL :localhost:8080/clienti/paginazione/prov;
		
		Tipo di Richiesta : "GET";
		
		Metodo per leggere i clienti presenti nel database ordinati per Provincia e suddivisi tramite paginazione;
		
		Autenticazioni necessarie: User;
		
		
- Metodo "OrdinaClientiPerParteDelNome" :

		URL :localhost:8080/clienti/paginazione/cercaPerParteNome/Wa;
		
		Tipo di Richiesta : "GET";
		
		Metodo per leggere i clienti presenti nel database ordinati in base ad una parte del 
		loro nome e suddivisi tramite paginazione;
		
		Autenticazioni necessarie: User;
		
		
- Metodo "OrdinaClientiPerFatturatoMaggioreDi" :

		URL :localhost:8080/clienti/paginazione/fatturato_maggiore_di222222;
		
		Tipo di Richiesta : "GET";
		
		Metodo per leggere i clienti presenti nel database ordinati per Fatturato maggiore di un valore inserito
		e suddivisi tramite paginazione;
		
		Autenticazioni necessarie: User;
		
		
		
- Metodo "OrdinaClientiPerFatturatoMinoreDi" :

		URL :localhost:8080/clienti/paginazione/fatturato_minore_di22222;
		
		Tipo di Richiesta : "GET";
		
		Metodo per leggere i clienti presenti nel database ordinati per Fatturato minore di un valore inserito
		e suddivisi tramite paginazione;
		
		Autenticazioni necessarie: User;
		
		
- Metodo "CercaClientePerId" :

		URL :localhost:8080/clienti/trovaPerId/4;
		
		Tipo di Richiesta : "GET";
		
		Metodo per ricercare un Cliente in base al proprio id;
		
		Autenticazioni necessarie: User;
		
		
- Metodo "TuttiIndirizzi" :

		URL :localhost:8080/indirizzi/lista;
		
		Tipo di Richiesta : "GET";
		
		Metodo per ricevere una riposta con tutti gli indirizzi presenti nel Database;
		
		Autenticazioni necessarie: User;
		
		
- Metodo "RegClienteConSedeLegaleEsistente" :

		URL : localhost:8080/clienti;
		
		Tipo di Richiesta : "POST";
		
		Metodo per registrare un cliente con la sede legale esistente;
		
		Autenticazioni necessarie: ADMIN;
		
		
- Metodo "RegClienteConSedeLegaleEOperativaEsistente" :

		URL : localhost:8080/clienti;
		
		Tipo di Richiesta : "POST";
		
		Metodo per registrare un cliente con la sede legale e operativa esistente;
		
		Autenticazioni necessarie: ADMIN;
		
		
- Metodo "RegClienteNoIndirizzi" :

		URL : localhost:8080/clienti;
		
		Tipo di Richiesta : "POST";
		
		Metodo per registrare un cliente sprovvisto di sede legale e/o sede operativa;
		
		Autenticazioni necessarie: ADMIN;
		
		
- Metodo "RegistraIndirizzo" :

		URL : localhost:8080/indirizzi;
		
		Tipo di Richiesta : "POST";
		
		Metodo per registrare un nuovo indirizzo sul Database;
		
		Autenticazioni necessarie: ADMIN;
		
		
- Metodo "ModificaCliente(creaIndirizziSeNonSpecificoGliID)"

		URL : localhost:8080/clienti/modifica/3;
		
		Tipo di Richiesta : "PUT";
		
		Metodo per modificare un cliente;
		
		Autenticazioni necessarie: ADMIN;
		

- Metodo "EliminaCliente"

		URL : localhost:8080/clienti/elimina/12;
		
		Tipo di Richiesta : "DEL";
		
		Metodo per eliminare un cliente passando l'id del cliente da eliminare all'interno dell'URL;
		
		Autenticazioni necessarie: ADMIN;
		
		
- Metodo "AssociaIndirizzoEsistenteAComuneEsistente" :

		URL: localhost:8080/indirizzi/associaComune/22/13;
		
		Tipo di Richiesta : "PUT";
		
		Metodo per associare un indirizzo esistente ad un comune esistente passando l'id sia dell'indirizzo che del comune
		esistente nell'url della chiamata;
		
		Autenticazioni necessarie: ADMIN;
		
		
- Metodo "ModificaIndirizzo" :
		
		URL: localhost:8080/indirizzi/modifica/1;
		
		Tipo di Richiesta : "PUT";
		
		Metodo per modificare un indirizzo esistente passando l'id del comune dell'URL della chiamata;
		
		Autenticazioni necessarie: ADMIN;
		
		
- Metodo "AssociaIndirizzoACliente" :

		URL : localhost:8080/indirizzi/associaIndirizzoUtente/1/10/legale;
		
	    Tipo di Richiesta : "PUT";
	    
	    Metodo per associare un indirizzo esistente ad un cliente esistente passando l'id dell Cliente, l'id dell'Indirizzo
	    e il tipo di sede di quest'ultimo;
	    
	    Autenticazioni necessarie: ADMIN;
	    
	    
- Metodo "EliminaIndirizzoSenzaCliente" :

		URL : localhost:8080/indirizzi/15;
		
		Tipo di richiesta : "DEL",
		
		Metodo per eliminare un indirizzo esistente passando l'Id dell'indirizzo da eliminare all'interno dell'URL;
		
		Autenticazioni necessarie: ADMIN;
		
		
- Metodo "TutteFatture" :
		
		URL : localhost:8080/fatture/lista;
		
		Tipo di richiesta : "GET";
		
		Metodo per ricercare tutte le fatture esitenti e presenti nel Database;
		
		Autenticazioni necessarie : "USER";
		
		
- Metodo "TrovaFatturaPerId" :
		
		URL : localhost:8080/fatture/trovaPerId/4;
		
		Tipo di richiesta : "GET";
		
		Metodo per ricercare una fattura presente nel Database passando come parametro nell'URL l'id della fattura da 
		ricercare;
		
		Autenticazioni necessarie : "USER";
		
		
- Metodo "TrovaFatturaPerIdCliente" :
		
		URL : localhost:8080/fatture/trovaPerCliente/3;
		
		Tipo di richiesta : "GET";
		
		Metodo per ricercare una fattura presente nel Database passando come parametro nell'URL l'id del cliente;
		
		Autenticazioni necessarie : "USER";
		
		
- Metodo "TrovaFatturaPerStato" :
		
		URL : localhost:8080/fatture/listaPerStato/EMESSA;
		
		Tipo di richiesta : "GET";
		
		Metodo per ricercare una fattura presente nel Database passando come parametro nell'URL lo stato della fattura
		(EMESSA, IN_PENDENZA, COMPLETATA ;
		
		Autenticazioni necessarie : "USER";
		
		
- Metodo "TrovaFatturaPerData" :
		
		URL : localhost:8080/fatture/listaPerData/2022/01/12;
		
		Tipo di richiesta : "GET";
		
		Metodo per ricercare una fattura presente nel Database passando come parametro nell'URL la data da ricercare
		(YYYY/GG/MM);
		
		Autenticazioni necessarie : "USER";
		
		
- Metodo "TrovaFatturaPerAnno" :

		URL : localhost:8080/fatture/listaFattureAnnue/2022;
		
		Tipo di richiesta : "GET";
		
		Metodo per ricerare una fattura presente nel Databse passando come parametro nel'URL l'anno della fattura;
		
		Autenticazioni necessarie : "USER";
		
		
- Metodo "TrovaFatturaPerImportiBetween" :

		URL : localhost:8080/fatture/lista/importi/0/9999;
		
		Tipo di richiesta : "GET";
		
		Metodo per ricercare una fattura presente nel Database passando come parametro nell'URL un range di importo da
		ricercare;
		
		Autenticazioni necessarie : "USER";
		
		
- Metodo "RegistraFattura" :

		URL : localhost:8080/fatture;
		
		Tipo di richiesta : "POST";
		
		Metoto per registrare una fattura nel Database passando come valori nel body : anno, data, importo, numero e 
		statoFattura;
		
		Autenticazioni necessarie: ADMIN;
		
		

		
		

 		  
 		  
 		  
