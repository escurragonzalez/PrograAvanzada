%clauses

entrada(paella).
entrada(gazpacho).
entrada(consomé).
entrada(matambre).

carne(filete_de_cerdo).
carne(pollo_asado).
carne(milanesa_napolitana).
carne(asado_del_medio).

pescado(trucha).
pescado(bacalao).

postre(flan).
postre(helado).
postre(pastel).
postre(don_pedro).

%fin clauses

%rules

es_comida(X,Y,Z):-entrada(X),
(carne(Y);pescado(Y)),postre(Z).
es_comida_sin_flan(A,B,C):-es_comida(A,B,C),not(C==flan).
es_comida_con_consome(A,B,C):-es_comida(A,B,C),A==consomé.

%fin rules

