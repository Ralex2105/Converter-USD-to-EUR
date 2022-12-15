# Converter USD to EUR

Simple converter which takes HTTP POST request with EUR or USD values and returns USD or EUR response.

## How to use

To convert USD -> EUR you can send request on
``` 
0.0.0.0:8080/convert/USDtoEUR?value=<your value>
```
To convert EUR -> USD you can send request on
``` 
0.0.0.0:8080/convert/EURtoUSD?value=<your value>
```

## How to run with docker
Clone repository:
``` console
$ git clone https://github.com/Ralex2105/Converter-USD-to-EUR.git
```
CD into app folder:
``` console
$ cd Converter-USD-to-EUR
```
Build docker image:
``` console
$ docker build -t converterApp
```
Run docker image:
``` console
$ docker run -p 8080:8080 converterApp
```

## Lisense
We're [MIT](./LICENSE) licensed.
