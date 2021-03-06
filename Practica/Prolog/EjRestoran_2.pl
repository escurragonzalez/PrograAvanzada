%clauses

entrada(paella).
entrada(gazpacho).
entrada(consom�).
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

bebida(vino_guarany).
bebida(vino_termidor).
bebida(cerveza_rubia).
bebida(cerveza_roja).
bebida(agua_con_gas).
bebida(agua_sin_gas).

%fin clauses

%rules

es_comida(X,Y,Z,W):-entrada(X),
(carne(Y);pescado(Y)),postre(Z),bebida(W).
es_comida_sin_flan(A,B,C,D):-es_comida(A,B,C,D),not(C==flan).
es_comida_con_consome(A,B,C):-es_comida(A,B,C,D),A==consom�.

%fin rules



