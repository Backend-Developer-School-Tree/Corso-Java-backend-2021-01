# Esercitazione immagini e Webcam

>*Ricordi siamo pixel <br>
>Ma lei non lo capisce*


<p align="center">
<img src="https://images.genius.com/902be6fbe13dc1ed58acadf9166075a2.600x321x3.gif" class="center">
</p>

[*Sxrrxwland - Cattedrale*](https://www.youtube.com/watch?v=QyfvThlYDTc)

## Le immagini

Oggi lavoreremo con le immagini in Java. Ma cos'è un immagine?

Un'immagine è una rappresentazine visiva e non solida della realtà che possiamo percepire tramite il nostro senso della vista. In informatica per immagini intendiamo alcune tipologie di file che contengono i dati per riprodurre immagini a schermo. La struttura più comune è quella di strutturare l'immagine come una matrice di pixels (immagini raster) sfruttando quindi l'idea alla base dei **mosaici**.


<p align="center">
<img src="https://www.mangaforever.net/wp-content/uploads/2018/12/cave-canem.jpg" height="320" class="center">
</p>

# Pixel e colori

Un pixel è un tipo di dato che serve a rappresentare un colore. Per fare ciò, solitamente un pixel si avvale di 3 canali RGB (rosso, verde, blu) e la combinazione di quanto sono attivi i 3 canali ci da come risultato un colore. Il range dei valori va da 0 a 255 perciò con un byte riusciamo a rappresentare un canale e con 3 byte l'intero colore. Il formato RGB è pensato sulla logica dei colori della luce perciò i tre canali accesi al massimo danno il bianco (luce pura) mentre i 3 colori spenti danno il nero, possiamo quindi definire il formato RGB come **additivo**, I colori a cui siamo abituati noi solitamente non funzionano al contrario, per esempio mischiando molte vernici colorate si ottiene un colore molto più scuro di quelli di partenza.

<p align="center">
<img src="https://www.fc1492.com/wp-content/uploads/2017/02/rgb.png" height="480" class="center">
</p>

il perché sono stati scelti rosso verde e blue come colori di partenza riguarda il modo in cui percepiamo noi i colori che deriva sia da come sono strutturati i nostri occhi ma anche da come il nostro cervello elabora le informazioni; per esempio sapevate che il blu è un colore relativamente nuovo?

[![blue da ba dee da ba da](https://i.ytimg.com/vi/D1-WuBbVe2E/maxresdefault.jpg)](https://www.youtube.com/watch?v=D1-WuBbVe2E)


Per chi volesse approfondire il discorso sulla percezione questo [link](https://en.wikipedia.org/wiki/Color_vision) è un buon punto d'inizio.


## Formati immagini

Esistono moltissimi formati per salvare le immagini sul computer e possono anche variare molto tra di loro, tra i più famosi e utilizzati ci sono: 
* RAW 
* PSD
* TIFF
* PNG
* PDF
* EPS
* BMP
* Ai
* GIF
* PICT
* SVG
* JPEG.

Ogni formato ha le proprie caratteristiche e la propria struttura, per esempio in un immagine PNG abbiamo 4 canali per il colore e l'ultimo è adibito all'alpha e cioè gestisce la trasparenza del pixel. Alcuni dei formati sopra citati (PDF e SVG) nemmeno sfruttano l'idea del mosaico ma hanno all'interno le istruzioni per poter ricostruire l'immagine, in questi casi parliamo di immagini **vettoriali** ma oggi vedremo e lavoreremo soltanto con quelle di tipo **raster** e cioè strutturate a matrice di pixels.

## Java e le immagini

Nonostante Java non sia un linguaggio popolare per la grafica ci sono comunque moltissime librerie che ci permettono di lavorare con la grafica, alcune di queste anche ufficiali.


```java
int width = 1024;
int height = 1024;
BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
```

Questa singola riga di codice crea per noi un'immagine grande 1024 * 1024 che può gestire i 3 classici canali RGB. Se volessimo colorarla completamente di rosso, col classico doppio ciclo for con cui cicliamo su una matrice possiamo fare:

```java
for (int col = 0; col < image.getWidth(); col++)
    for (int row = 0; row < image.getHeight(); row++)
    {
        Color pixel = new Color(255,0,0);
        outputImage.setRGB(col , row, pixel.getRGB());
    }
```

Perciò prima creiamo un nuovo pixel colorato e successivamente lo assegniamo all'immagine.

Fate molto attenzione che non stiamo utilizzando la classica matrice Java ma un oggetto chiamato "BufferedImage" e per accedere ad uno specifico pixel non usiamo le parentesi quadre ma un suo metodo specifico, fate anche attenzione che non passiamo direttamente l'oggetto Color all'immagine ma il risultato della chiamata al metodo "getRGB()".

Ovviamente con un doppio ciclo possiamo leggere i pixel dell'immagine e farci quello che vogliamo, per esempio in questo ciclo leggiamo ogni pixel e gli settiamo la componente del verde a 150:


```java
for (int col = 0; col < image.getWidth(); col++)
    for (int row = 0; row < image.getHeight(); row++)
    {
        Color pixel = new Color(image.getRGB(col, row));
        int red = pixel.getRed();
        int green = 150;
        int blue = pixel.getBlue();
        Color newPixel = new Color(red, green, blue);
        image.setRGB(col , row, newPixel.getRGB());
    }
```


Infine per salvare l'immagine sul disco utilizziamo questa riga di codice:

```java
ImageIO.write(outputImage, "jpg", new File("immagineRossa.jpg"));
```

È possibile anche lavorare su un'immagine già presente sul nostro disco, in questo caso ci basta fare:

```java
selfieMio = ImageIO.read(new File("selfie.jpg"));
```

## Disclaimer

Alcuni dei metodi degli oggetti che utilizzeremo oggi possono lanciare **eccezioni**, non le abbiamo ancora viste nel corso, se capita quindi per gestirle o accettiamo il suggerimento di Intellij/Eclipse oppure  
aggiungiamo "throws Exception" alla firma dei metodi che ci danno questo problema.

```java
public static void main(String[] args) throws Exception{
```

Ora possedete le nozioni basi per poter lavorare con le immagini in Java e poter affrontare gli esercizi di oggi.




Esercizio | Difficoltà
------------ | -------------
[256 shades of gray](https://github.com/Backend-Developer-School-Tree/Corso-Java-backend-2021-01/tree/main/module_04/esercitazione%20immagini/256_shades_of_gray) | :kick_scooter:
[Filtri immagine](https://github.com/Backend-Developer-School-Tree/Corso-Java-backend-2021-01/tree/main/module_04/esercitazione%20immagini/Filtri) | :kick_scooter:
[Green screen](https://github.com/Backend-Developer-School-Tree/Corso-Java-backend-2021-01/tree/main/module_04/esercitazione%20immagini/Green_Screen) | :motor_scooter:
[Time lapse con webcam](https://github.com/Backend-Developer-School-Tree/Corso-Java-backend-2021-01/tree/main/module_04/esercitazione%20immagini/Timelapse_Webcam) | :motor_scooter: /:motorcycle:
[Gif filtri webcam](https://github.com/Backend-Developer-School-Tree/Corso-Java-backend-2021-01/tree/main/module_04/esercitazione%20immagini/Gif_filtri_webcam) |  :motorcycle:



# Hall of fame

<p align="center">
<img src="https://media1.tenor.com/images/8c8f18bec7ba6a1b7ddc2ef76664e9ae/tenor.gif?itemid=10584134" class="center">
</p>

In questa tabella saranno inserite le soluzioni particolarmente meritevoli oppure gli effetti grafici di vostra creazione:

Nome | Effetto 
------------ | -------------
Pierluigi Filosa |[Effetto Pokemon](https://github.com/ox-rock/JavaBackendCourse2021/tree/main/module_04/Filtro%20Pokemon) 