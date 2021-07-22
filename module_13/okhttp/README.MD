# OkHttp

<p align="center">
<img src="assets/okhttp.jpg"  class="center">
</p>

Fino ad oggi avete creato voi dei servizi che avete esposto all'esterno e che potevano essere utilizzati da altri sviluppatori o utenti, ma se invece volessimo noi utilizzare un servizio creato da altri? Un'ottima libreria Java che è abbastanza considerata lo standard de facto è **OkHttp**.

## Come utilizzare OkHttp

Il [sito ufficiale di OkHttp](https://square.github.io/okhttp/) ha all'interno diversi esempi di utilizzo, il mio consiglio è quello di andare sempre a vedere il [full source](https://raw.githubusercontent.com/square/okhttp/master/samples/guide/src/main/java/okhttp3/guide/GetExample.java) dell'esempio che vi serve oppure andare nella [cartella sample della loro repo ufficiale](https://github.com/square/okhttp/tree/master/samples) dove troverete moltissimi altri esempi. 

## Ha senso usare OkHttp per testare le nostre API?

Dal momento che esistono tool come Postman e simili per ragioni puramente pratiche non ha molto senso farsi un progettino per testare le proprie API, fidatevi con postman sarete sicuramente più veloci e la vostra salute mentale vi ringrazierà!

## Quali servizi posso chiamare?

Moltissime piattaforme offrono un interfaccia API con cui potersi interfacciare, alcuni di questi servizi sono a pagamento (google maps), altri richiedono che l'utente faccia prima una registrazione (Telegram per le sue BOT api) altri (che vedremo negli esercizi) sono liberamente utilizzabili. Molti progetti si basano su dati che spesso non si posseggono o che sarebbe molto costoso reperire, fare quindi una ricerca su quali servizi possano offrici i dati è solitamente uno dei primi passi che viene svolto, anche un big come trip advisor si avvale delle mappe google per far vedere dove si trovano i ristoranti.

In [questo sito](https://public-apis.xyz/) troverete una valanga di API pubbliche con documentazione che potrebbero tornarvi utili per i vostri progetti futuri. Esistono anche [piattaforme a pagamento](https://rapidapi.com/marketplace) che integrano in un unico sito tante API di terze parti, per molte aziende una soluzione del genere può risultare molto comoda.


## Consigli per gli esercizi

Una buona documentazione delle API ha sempre qualche Json di esempio, usatelo per costruirvi gli oggetti che vi arriveranno dai siti sfruttando [siti internet come questo](https://json2csharp.com/json-to-pojo).

# Esercizi


Esercizio | Difficoltà
------------ | -------------
[Che tempo fa da me?](https://github.com/Backend-Developer-School-Tree/Corso-Java-backend-2021-01/tree/main/module_13/okhttp/chetempofa) | :kick_scooter:
[Il mio goodreads fatto in casa](https://github.com/Backend-Developer-School-Tree/Corso-Java-backend-2021-01/tree/main/module_13/okhttp/goodreads) | :motor_scooter:


