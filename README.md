"# spring-la-mia-pizzeria-crud" 
"# spring-la-mia-pizzeria-relazioni" 

day 1 

Esercizio di oggi: Spring La Mia Pizzeria - CRUD

nome repo: spring-la-mia-pizzeria-crud


Ciao ragazzi,
Dobbiamo realizzare un’applicazione web che ci aiuti a gestire la nostra pizzeria.
Abbiamo bisogno di creare la prima pagina (index) dove mostriamo tutte le pizze che prepariamo. Nei prossimi giorni implementeremo il resto dei metodi per le CRUD.

Una pizza avrà le seguenti informazioni :
- un nome
- una descrizione
- una foto
- un prezzo

Creaimo il database, repository e l'entity per gestire le CRUD delle pizze.
Implementiamo quindi il controller con il metodo index che restituisce una view per mostrare l’elenco delle pizze caricate dal database (possiamo creare una tabella con bootstrap o una qualche grafica a nostro piacimento che mostri questo elenco...un po’ di creatività se vogliamo!)
L’elenco potrebbe essere vuoto : in quel caso dobbiamo mostrare un messaggio che indichi all’utente che non ci sono pizze presenti nella nostra applicazione.
Gestiamo i componenti riutilizzabili con i fragments.

day 2

Ciao ragazzi, andiamo avanti con l’applicazione per gestire la nostra pizzeria. Lo scopo di oggi è quello di mostrare i dettagli di una singola pizza.
Ogni pizza dell’elenco avrà quindi un pulsante che se cliccato ci porterà a una pagina che mostrerà i dettagli della pizza scelta.
Dobbiamo quindi inviare l’id come parametro dell’URL, recuperarlo nel metodo del controller, caricare i dati della pizza ricercata e passarli come model.
La view a quel punto li mostrerà all’utente con la grafica che preferiamo.
Nella pagina con l’elenco delle pizze aggiungiamo un campo di testo che se compilato filtrerà le pizze (lato server) aventi come titolo quello inserito dall’utente.

day 3

Ciao ragazzi,
nuove implementazioni per la nostra applicazione.
Abbiamo la lista delle pizze, abbiamo i dettagli delle pizze...perchè non realizzare la pagina per la creazione di una nuova pizza?
Aggiungiamo quindi tutto il codice necessario per mostrare il form per la creazione di una nuova pizza e per il salvataggio dei dati in tabella.
Nella index creiamo ovviamente il bottone “Crea nuova pizza” che ci porta a questa nuova pagina creata.
Ricordiamoci che l’utente potrebbe sbagliare inserendo dei dati : gestiamo quindi la validazione!
Ad esempio verifichiamo che :
- i dati della pizza siano tutti presenti
- il campi di testo non superino una certa lunghezza
- il prezzo abbia un valore valido (ha senso una pizza con prezzo minore o uguale a zero?)

day 4

Ciao ragazzi, andiamo avanti col nostro progetto.
Completiamo le pagine di gestione delle nostre pizze! Abbiamo la pagina con la lista di tutte le pizze, quella con i dettagli della singola pizza, quella per crearla...cosa manca?
Dobbiamo realizzare : - pagina di modifica di una pizza - cancellazione di una pizza cliccando un pulsante presente nella grafica di ogni singolo prodotto mostrato nella lista in homepage 

day 5

Esercizio di oggi: Spring La Mia Pizzeria Relazioni
nome repo: spring-la-mia-pizzeria-relazioni
IMPORTANTE: Ricordatevi di sganciare la vostra vecchia repository e di crearne una nuova per questo esercizio, che prosegue il lavoro della pizzeria, dove lo avevate lasciato.
Ciao ragazzi,
nuova giornata di sviluppo!
Nuova importante funzionalità : le offerte speciali!
In alcuni momenti potremmo voler vendere le nostre pizze a un prezzo scontato.
Dobbiamo quindi predisporre tutto il codice necessario per poter collegare un’offerta speciale a una pizza (in una relazione 1 a molti, cioè un’offerta speciale può essere collegata a una sola pizza, e una pizza può essere collegata a più offerte speciali).
L’offerta speciale avrà :
- una data di inizio
- una data di fine
- un titolo
La pagina di dettaglio della singola pizza mostrerà l’elenco delle offerte collegate e avrà un bottone “Crea nuova offerta speciale” per aggiungerne una nuova.
Accanto ad ogni offerta speciale è previsto un bottone che mi porterà a una pagina per modificarla.

day 6

nuovo pezzettino per la nostra pizzeria : gli ingredienti!
Ogni pizza può avere più ingredienti, e ogni ingrediente può essere collegato a più pizze.
Prevediamo quindi una pagina per mostrare l’elenco di tutti gli ingredienti che utilizziamo nella nostra pizzeria che permetta anche di crearne di nuovi (e di cancellarli).
Nella pagina di creazione (e modifica) della singola pizza dobbiamo dare la possibilità di collegare uno o più ingredienti.

day 7

vogliamo dare accesso alla nostra applicazione anche all’esterno!
Implementiamo quindi i metodi CRUD tramite RestController.
Diamo la possibilità di :
- ottenere la lista di pizze (dobbiamo anche poterle filtrare per titolo)
- leggere i dettagli di una singola pizza
- creare una nuova pizza
- modificare una pizza esistente
- cancellare una pizza
Queste operazioni devono poter essere eseguite tramite PostMan, non preoccupiamoci quindi della parte di frontend per ora

day 8

abbiamo implementato le Api REST, e le possiamo interrogare con PostMan.
Facciamo un altro sforzo : creiamo un semplice progetto frontend che le richiami e tramite javascript mostri in pagina i dati.
Ricordiamoci che servirà una pagina per la lista delle pizze (filtrabili per titolo), una per il dettaglio di una singola pizza, una per la creazione e una per la modifica…senza dimenticarci del pulsante per la cancellazione di un elemento!

day 9

Ciao ragazzi,
proteggiamo la nostra applicazione!
Abbiamo sviluppato tutte le pagine per gestire la nostra pizzeria (elenco pizze, dettagli singola pizza, creazione, modifica, cancellazione, offerte speciali, ingredienti)…
ma vogliamo che chiunque possa effettuare queste operazioni?
Sicuramente no!
Quindi inseriamo l’autenticazione in modo che solo gli utenti registrati possano accedere a queste pagine.
Creiamo le entity necessarie e popoliamo a mano i dati degli utenti nel database.
Sono previsti due ruoli : USER e ADMIN
Gli utenti con ruolo USER possono accedere solo alla pagina index e a quella di dettaglio.
Gli utenti ADMIN possono fare tutto.