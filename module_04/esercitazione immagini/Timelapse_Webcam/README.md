# Time lapse Webcam :motor_scooter: /:motorcycle:

In questo esercizio realizzerete un software che produrra una gif in time lapse utilizzando la vostra webcam. Quando farete partire il programma, il software prima di iniziare a catturare immagini, eseguirà un countdown di 3 secondi.


![city time lapse](timeLapse.gif)


## Il Time lapse

Il time lapse è una tecnica cinematografica nella quale la frequenza di cattura di ogni fotogramma è inferiore a quella di riproduzione; a causa di questa discrepanza la proiezione con un frame rate standard di 24 fps fa sì che il tempo, nel filmato, sembri scorrere più velocemente del normale.

![city time lapse](https://64.media.tumblr.com/8d005dbc5d352b03fb9ded11673c98e8/tumblr_naq374DYwf1re4onxo2_1280.gif)

## Usare la webcam in Java

Per poter fare questo esercizio avrete bisogno di utilizzare la vostra webcam

# **ATTENZIONE**
Se la vostra webcam è occupata, per esempio la sta utilizzando zoom, il vostro programma crasherà, perciò controllate prima che nessun altro programma la stia utilizzando prima di eseguire il vostro codice.


Per utilizzare la webcam in Java utilizzeremo una libreria non ufficiale di Oracle ma ben mantenuta e cioè la [webcam-capture](https://github.com/sarxos/webcam-capture) di sarxos (troverete un'ottima guida sia sul loro git e sia sul loro [sito ufficiale](http://webcam-capture.sarxos.pl/)).

Per gli esercizi di oggi basteranno comunque le funzionalità base della libreria che vedremo insieme.

## Hello world della webcam

Una volta che avrete importato la libreria della webcam sul vostro progetto, potrete iniziare ad usarla. 


```java
Webcam webcam = Webcam.getDefault();
webcam.open();
ImageIO.write(webcam.getImage(), "PNG", new File("hello-world.png"));
```

Con queste tre righe di codice sarete in grado di ottenere l'accesso alla webcam e salvare su un file una photo. Il metodo getImage() di webcam restituisce una BufferedImage, perciò siete anche liberi di manipolare l'immagine a vostro piacimento.

## Settare la risoluzione della webcam

La libreria permette di poter cambiare la risoluzione della cattura della webcam. si può scegliere tra alcune risoluzioni standard e si può anche utilizzare risoluzioni non standard. Per esempio se avete una webcam che può cattura a 720p potete utilizzare questo codice per aumentare la risoluzione di cattura:
```java
Dimension[] nonStandardResolutions = new Dimension[] {
        WebcamResolution.PAL.getSize(),
        WebcamResolution.HD720.getSize(),
        new Dimension(2000, 1000),
        new Dimension(1000, 500),
    };

        // your camera have to support HD720p to run this code
Webcam webcam = Webcam.getDefault();
webcam.setCustomViewSizes(nonStandardResolutions);
webcam.setViewSize(WebcamResolution.HD720.getSize());
webcam.open();
```

In alternativa potete utilizzare questo codice per utilizzare risoluzioni standard:

```java
Webcam webcam = Webcam.getDefault();
webcam.setViewSize(new Dimension(1024, 768));
webcam.open();
```
In caso di errore perché inserite una risoluzione non supportata, vi verranno mostrate le risoluzioni che potete utilizzare.


Importante a fine programma ricordarsi di chiudere la webcam (in questo caso FORSE non succede nulla se non lo fate, ma è una buona pratica ed è sempre meglio farlo).

```java
webcam.close();
```

## Le GIF

Le gif sono un formato per le immagini che permettono di mostrare a schermo immagini animate.

Sono un formato più complesso di quello che ci si aspetterebbe, perciò vi verrà fornito del codice per poter creare una gif partendo da un array di BufferedImages.

![Fanelli](https://media.tenor.com/images/ffafbd51b78d2458588d19bb81248990/tenor.gif)


## Il tempo

Per realizzare il conto alla rovescia, quello che vi serve sapere è come leggere l'ora e in quale formato vi viene data l'informazione. In informatica spesso il tempo viene rappresentato come offset in secondi rispetto alla mezzanotte (UTC) del 1º gennaio 1970 (detta epoca). In Java con questa riga di codice otterrete l'orario corrente in millisecondi:

```java
long now = System.currentTimeMillis();
```

Con questa informazione dovreste riuscire a realizzare il countdown.

## L'esercizio

In questa cartella troverete un progetto base con il codice per creare una gif dato un array di BufferedImage, sarà compito vostro caricare la libreria della webcam e scrivere il restante codice.