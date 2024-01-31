# Progetto_ING.Software_23_24
versione BETA 1.0.0
![logo](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/immagini/logo.png)
Lo scopo del progetto è quello di implementare una soluzione software alternativa volta alla gestione automatica (raccolta, scrittura e consultazione) dei dati che accompagnano il paziente dalla sua accettazione alla dimissione e contribuendo a raccogliere una serie di rilevazioni sui parametri vitali, al fine di migliorare 
l’efficienza ospedaliera e il mantenimento dei dati, il tutto interagendo con un'interfaccia grafica (GUI).
## Project Plan
Il [project plan](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/Project%20Plan.pdf) è stato redatto prima della realizzazione del software e successivamente modificato per una completa pianificazione.
## Documentazione
Tutta a documentazione, compresa __l'analisi dei requisiti__, per la progettazione del problema è stata scritta in un unico file chiamato [Documentazione del progetto](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/Documentazione%20del%20Progetto.pdf).
## UML
Abbiamo realizzato i vari diagrammi con l'utilizzo di StarUML e draw.io, si trovano nella cartella [Med/doc/diagrammi](MED/doc/diagrammi):
- [CASI D'USO](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Diagramma%20dei%20Casi%20d'Uso.pdf) ([Descrizione dei casi d'uso](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Descrizione%20dei%20Casi%20d'Uso.pdf))
- [ATTIVITÀ](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Diagramma%20delle%20Attivit%C3%A0.pdf)
- [CLASSI](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Diagramma%20di%20Classe.pdf)
- [PACKAGE](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Diagramma%20di%20Pacchetto.pdf)
- [SEQUENZA](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Diagramma%20di%20Sequenza.pdf)
- [ER](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Diagramma%20ER.pdf)
- [COMPONENTI](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Diagramma%20dei%20Componenti.pdf)
- [MACCHINA A STATI](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Macchina%20a%20Stati%20Paziente.pdf)
## DataBase
Abbiamo sviluppato un file Java denominato [CreateDB](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/code/progetto_database/src/main/java/gestore_db/CreateDB.java) dedicato alla creazione del database. Nel caso in cui il database non esista, verrà generato un nuovo database denominato [db.db3](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/code/progetto_database/db/db.db3). Questo processo è implementato utilizzando Java, JOOQ e SQLite all'interno dell'IDE Eclipse, al fine di raccogliere e gestire i dati relativi ai pazienti e al personale.
## Funzionalità
- __Inserimento dati del paziente nel database__
- __Inserimento diaria medica da parte del medico__
- __Inserimento diaria infermieristica da parte dell'infermiere__
- __Inserimento delle rilevazioni da parte dell'infermiere__ 
- __Spostamento del paziente da parte dell'operatore__
- __Dimissione del paziente da parte del medico__
- __Filtri per la ricerca veloce del paziente__
## Funzionalità Future
- Aumento dei campi sulle rilevazioni disponibili
- Miglioramento grafico a seguito di eventuali consigli del cliente 
- Aggiunta di ulteriori casi di test
## Installazione del software e procedura per l'avvio
Per usufruire del software, è necessario procedere al download del file .zip dalla pagina principale di GitHub. Ciò può essere realizzato cliccando sull'opzione "Code" e successivamente selezionando "Download ZIP".
Una volta completata l'operazione di download estrarre il file ZIP ottenuto in una directory a scelta all'interno del computer.
Successivamente, sarà necessario navigare attraverso le cartelle fino a raggiungere il percorso seguente: Progetto_ING.Software_23_24-main -> MED -> code -> progetto_logico. A questo punto, eseguire il file .jar denominato MED.jar (oppure eseguirlo direttamente dal desktop copiando il collegamento dal medesimo file .jar).

In alternativa è possibile importare il software nell'ambiente di sviluppo Eclipse IDE (assicurarsi che siano presenti tutti e quattro i progetti) e avviarlo utilizzando la classe "Main" presente nel progetto "progetto_logico" all'interno del package "eseguibile".

Per accedere al software nella pagina di login inserire le seguenti credeziali:
 - Username: __m__ Password: __m__, per accedere come medico
 - Username: __i__ Password: __i__, per accedere come infermiere
 - Username: __o__ Password: __o__, per accedere come operatore

Nel software sono già presenti 
## Componenti del gruppo
- [__Daniele Gotti, matricola 1079011__](https://github.com/DanieleGotti)
- [__Bolis Filippo Antonio, matricola 1079493__](https://github.com/FilippoBolis)
- [__Mazzoleni Gabriele, matricola 1079514__](https://github.com/Gabriele-Mazzoleni)
- [__Masinari Gabriele, matricola 1079692__](https://github.com/GabrieleMasinari27)
