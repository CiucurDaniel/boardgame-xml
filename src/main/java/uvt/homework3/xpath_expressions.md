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
* Toate elementele a caror parent tag nu este boardgames
```xpath2
//*[name()!='boardgames']/*
```

* Cate categorii are al-3-lea boardgame
```xpath2
/BoardgameRoot/boardgames/boardgame[count(idref('categoriesIDs')) < 2]
```

# Expresii medii
---------------------------------------------------------------

Expresii medii cu filtrare simpla folosind predicate ([condition], and, or, not) .

* Gasire boardgame-uri cuprinse intre un anumit pret
```xpath2
/BoardgameRoot/boardgames/boardgame[price[. >= 20 and . <= 50]]
```
* Gasire boardgame cu pret mai mic de 110 lei sau produse de manufacturer-ul m1
```xpath2
/BoardgameRoot/boardgames/boardgame[price<= 110 or @manufacturerID='m1']
```

* Gasire boardgame care nu sunt produse de manufacturer-ul m2
```xpath2
/BoardgameRoot/boardgames/boardgame[not(@manufacturerID='m2')]
```

* Afisare sub forma "boardgame - price"
```xpath2
/BoardgameRoot/boardgames/boardgame/concat(name, ' ', price)
```

* Afisare sub forma "boardgame - price" intr-o singure linie si valorile separate prin virgula ("Catan 100, Monopoly 250")
```xpath2
string-join(/BoardgameRoot/boardgames/boardgame/concat(name, ' ', price), ', ')
```

* Boardgame-uri create de producatorul X
```xpath2
/BoardgameRoot/boardgames
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