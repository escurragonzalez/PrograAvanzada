entrada(paella).
entrada(gazpacho).
entrada(consome).
carne(filete_de_cerdo).
carne(pollo_asado).
pescado(trucha).
pescado(bacalao).
postre(flan).
postre(helado).
postre(pastel).
es_plato_principal(X):- carne(X);pescado(X).
es_comida(X,Y,Z):- entrada(X),es_platoPrincipal(Y),postre(Z).
tiene_flan(X,Y,Z):- es_comida(X,Y,Z),Z==flan.
tiene_consome(X,Y,Z):- es_comida(X,Y,Z),X==consome.

