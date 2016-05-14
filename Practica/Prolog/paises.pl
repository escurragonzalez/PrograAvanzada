es_un_pais(argentina).
es_un_pais(chile).
es_un_pais(mexico).
es_un_pais(guyanafrancesa).
es_un_pais(cuba).
es_un_pais(brasil).
es_un_pais(colombia).
es_un_pais(bolivia).
es_un_pais(peru).
es_un_pais(paraguay).
es_un_pais(uruguay).
es_un_pais(guatemala).
limita_con(guatemala,peru).
limita_con(argentina,paraguay).
limita_con(argentina,uruguay).
limita_con(argentina,chile).
limita_con(argentina,bolivia).
son_limitrofes(X,Y):- limita_con(X,Y);limita_con(Y,X).

