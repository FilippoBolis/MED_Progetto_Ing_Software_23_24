# Progetto_ING.Software_23_24
versione BETA 1.0.0
![logo](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/Immagini/Logo%20progetto_Tavola%20disegno%201.png)
Lo scopo del progetto è quello di implementare una soluzione software alternativa volta alla gestione automatica(raccolta, scrittura e consultazione) dei dati che accompagnano il paziente dalla sua accettazione alla dimissione e contribuendo a raccogliere una serie di rilevazioni sui parametri vitali, al fine di migliorare 
l’efficienza ospedaliera e il mantenimento dei dati, il tutto interagendo con un'interfaccia grafica(GUI).
## Project Plan
Il [project plan]() è stato redatto prima della realizzazione del software e successivamente modificato per una completa pianificazione
## Documentazione
Tutta a documentazione,compresa __l'analisi dei requisiti__, per la progettazione del problema è stata scritta in un unico file chiamato [Documentazione del progetto](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/Documentazione%20del%20progetto.pdf)
## UML
Abbiamo realizzato i vari diagrammi con l'utilizzo di StarUML e draw.io, si trovano nella cartella [Med/doc/diagrammi](MED/doc/diagrammi):
- [CASI D'USO](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Diagramma%20Casi%20d'uso.pdf)
- [ATTIVITÀ](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Diagramma%20delle%20attivit%C3%A0.pdf)
- [CLASSI](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Diagramma%20di%20classe.pdf)
- [PACKAGE](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Diagramma%20di%20pacchetto.JPG)
- [SEQUENZA](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Diagramma%20di%20sequenza.pdf)
- [ER](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Diagramma%20ER.pdf)
- [COMPONENTI](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Diagramma%20dei%20Componenti.pdf)
- [MACCHINA A STATI](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/doc/diagrammi/Macchina%20a%20stati%20paziente.pdf)
## DataBase
Abbiamo sviluppato un file Java denominato [CreateDB](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/code/progetto_database/src/main/java/gestore_db/CreateDB.java) dedicato alla creazione del database. Nel caso in cui il database non esista, verrà generato un nuovo database denominato [db.db3](https://github.com/FilippoBolis/Progetto_ING.Software_23_24/blob/main/MED/code/progetto_database/db/db.db3). Questo processo è implementato utilizzando Java, JOOQ e SQLite all'interno dell'IDE Eclipse, al fine di raccogliere e gestire i dati relativi ai pazienti e al personale.
## Funzionalità
- __Inserimento dati del paziente nel database__
- __Inserimento diaria medica da parte del medico__
- __Inserimento diaria infermieristica da parte dell'infermiere__
- __Spostamento del paziente da parte dell'operatore__
- __Dimissione del paziente da parte del medico__
- __Filtri per la ricerca veloce del paziente__
- __scrivere qui per aggiungere__
- __scrivere qui per aggiungere__
- __scrivere qui per aggiungere__
- __scrivere qui per aggiungere__
## Funzionalità Future
- Autenticazione a 2 Fattori
## Componenti del gruppo
- [__Daniele Gotti, matricola 1079011__](https://github.com/DanieleGotti)
- [__Bolis Filippo Antonio, matricola 1079493__](https://github.com/FilippoBolis)
- [__Mazzoleni Gabriele, matricola 1079514__](https://github.com/Gabriele-Mazzoleni)
- [__Masinari Gabriele, matricola 1079692__](https://github.com/GabrieleMasinari27)
