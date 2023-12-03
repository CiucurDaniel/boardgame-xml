# Expresii simple
---------------------------------------------------------------

1) Numar de boardgame-uri in baza de date
count(//BoardgameRoot/boardgames/boardgame)

2) Gasire boardgame name dupa ID
/BoardgameRoot/boardgames/boardgame[@ID='b4']/name/text()

3) Gasire boardgame-uri mai ieftine de 150 lei
/BoardgameRoot/boardgames/boardgame[price <= 150]]

4) A 3-a categorie categorie
// /BoardgameRoot/categories/category[3]

# Expresii medii
---------------------------------------------------------------

1) Gasire boardgame-uri cuprinse intre un anumit pret
// /BoardgameRoot/boardgames/boardgame[price[. >= 20 and . <= 50]]

2) Afisare toate detalii producator nr 2 inline
// /BoardgameRoot/manufacturers/manufacturer[2]/concat()

3) Boardgame-uri create de producatorul X

4) Boardgame care are o categorie (numele categoriei este dat)

4) Boardgame care are o singura categorie

# Expresii complexe
---------------------------------------------------------------



//65t67y