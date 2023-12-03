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

* A 3-a categorie
```xpath2
/BoardgameRoot/categories/category[3]
```
* Toate elementele a caror parent tag nu este boardgames
```xpath2
//*[name()!='boardgames']/*
```

* Cate categorii are al-3-lea boardgame
```xpath2
/BoardgameRoot/boardgames/boardgame[3]/count(tokenize(@categoriesIDs, ' '))
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

* Gasire nume boardgames care nu sunt produse de manufacturer-ul m2
```xpath2
/BoardgameRoot/boardgames/boardgame[not(@manufacturerID='m2')]/name
```

* Afisare sub forma "boardgame - price"
```xpath2
/BoardgameRoot/boardgames/boardgame/concat(name, ' ', price)
```

* Afisare sub forma "boardgame - price" intr-o singure linie si valorile separate prin virgula ("Catan 100, Monopoly 250")
```xpath2
string-join(/BoardgameRoot/boardgames/boardgame/concat(name, ' ', price), ', ')
```

* Boardgame care are o singura categorie
```xpath2
/BoardgameRoot/boardgames/boardgame/name[count(tokenize(../@categoriesIDs, ' ')) < 2 ]
```

* Ce boardgame este inaintea boardgame-ului b3
```xpath2
/BoardgameRoot/boardgames/boardgame[@ID='b3']/ancestor::boardgame
```

* Ce boardgames se afla dupa boardgame-ului b3
```xpath2
/BoardgameRoot/boardgames/boardgame[@ID='b3']/following-sibling::boardgame
```

* Selectare boardgame cu pret distinct (un set de elemente boardgame cu pret distinct)
```xpath2
/BoardgameRoot/boardgames/boardgame/name[not(price = preceding-sibling::boardgame/price)]
```

# Expresii complexe
---------------------------------------------------------------

Expresii complexe cand filtrarea bazata pe relatii cu alte parti ale documentelui XML (if-then-else, expresii cuantificabile de genul some/every, etc.)

// Gasirea ID-ului primului producator si apoi identificarea boardgame-urilor produse de acesta
```xpath2
//manufacturers/manufacturer[position() = 1]/@manufacturerID/ancestor::BoardgameRoot/boardgames/boardgame[@manufacturerID = //manufacturers/manufacturer[position() = 1]/@manufacturerID]/name

```

* Media de pret a boardgame-urilor (NOTA: consideram price de forma: $100)
```xpath2
avg(//boardgame/number(substring-after(price, '$')))
```

* Media boardgame-urilor de pe primele 3 pozitii
```xpath2
avg(//boardgame[position() le 3]/number(price))
```

* Aplica discount-uri bazat pe pretul boardgame-ului
```xpath2
for $boardgame in //boardgame
return
    if ($boardgame/price > 120) then
        <discountedBoardgame>
            <name>{data($boardgame/name)}</name>
            <originalPrice>{data($boardgame/price)}</originalPrice>
            <discountedPrice>{data($boardgame/price * 0.8)}</discountedPrice>
        </discountedBoardgame>
    else
        <discountedBoardgame>
            <name>{data($boardgame/name)}</name>
            <originalPrice>{data($boardgame/price)}</originalPrice>
            <discountedPrice>{data($boardgame/price * 0.7)}</discountedPrice>
        </discountedBoardgame>
```

* Gaseste boardgame-urile care sunt facute de "Kosmos" si costa mai mult de 100
```xpath2
//manufacturer[name = 'Kosmos']/ancestor::BoardgameRoot/boardgames/boardgame[number(price) > 100]/name

```

* Some | Verificam daca unele boardgames de la Hasbro costa peste 200
```xpath2
//manufacturers/manufacturer[name = 'Hasbro'][some $game in //boardgame[@manufacturerID = current-manufacturer/@manufacturerID] satisfies $game/price > 200]
```

* Every | Verifica daca fiecare boardgame de la Hasbro costa peste 50 
```xpath2
//manufacturers/manufacturer[name = 'Hasbro'][every $game in //boardgame[@manufacturerID = current-manufacturer/@manufacturerID] satisfies $game/price > 50]
```

* FIXME: Manufacturer cu cele mai multe boardgames
```xpath2
//manufacturers/manufacturer[
count(//boardgames[@manufacturerID = current()/@manufacturerID]) =
max(//manufacturers/manufacturer/count(//boardgames[@manufacturerID = current()/@manufacturerID]))
]
```
//65t67y