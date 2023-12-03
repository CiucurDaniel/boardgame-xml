# Expresii simple
---------------------------------------------------------------

* Numar de boardgame-uri in baza de date
```xpath2
count(//BoardgameRoot/boardgames/boardgame)
```

* Numele boardgame-urilor
```xpath2
/BoardgameRoot/boardgames/boardgame/name
```
* Gasire boardgame name dupa ID
```xpath2
/BoardgameRoot/boardgames/boardgame[@ID='b4']/name/text()
```

* Gasire boardgame-uri mai ieftine de 150 lei
```xpath2
/BoardgameRoot/boardgames/boardgame[price <= 150]
```

* A 3-a categorie categorie
```xpath2
/BoardgameRoot/categories/category[3]
```

# Expresii medii
---------------------------------------------------------------

Expresii medii cu filtrare simpla folosind predicate.

* Gasire boardgame-uri cuprinse intre un anumit pret
```xpath2
/BoardgameRoot/boardgames/boardgame[price[. >= 20 and . <= 50]]
```

* Afisare toate detalii producator nr 2 inline
```xpath2
/BoardgameRoot/manufacturers/manufacturer[2]/concat()
```

* Boardgame-uri create de producatorul X
```xpath2
/TODO
```
* Boardgame care are o categorie (numele categoriei este dat)
```xpath2
/TODO
```

* Boardgame care are o singura categorie
```xpath2
/TODO
```

# Expresii complexe
---------------------------------------------------------------

Expresii complexe cand filtrarea bazata pe relatii cu alte parti ale documentelui XML (if-then-else, expresii cuantificabile de genul some/every, etc.)

// Gasirea ID-ului primului producator si apoi identificarea boardgame-urilor produse de acesta
```xpath2
/TODO
```

//65t67y