Experimento de paralelismo en java para el JConf Dominicana 2019.

La diapositiva y PDF de la charla esta en Documents.

El objetivo es mostrar como se carga la data de disco a memoria y como se puede procesar junto a los hilos y como seleccionarlos.

Consideraciones
 - La data son listas de numeros en secuencia que se desordenan (En este caso de 20 numeros)
 - En la DB se crean 500,000 registros
 - La carga de disco es de 10,000 y se usa 5, 10 y 50 hilos en la piscina, pues el algoritmo de división de trabajo no tiene contemplado la división de trabajo con fracciones no exactas.

La carga de trabajo y su naturaleza es la que especifica cuantos hilos debo usar.
La carga de trabajo cuando se procesa debe de dar 500,000 registros por cada numero, sino esta mal distribuida.

Preguntas sugerentes para probar
 - Más hilos es más rápido?
 - Que tanto registros debo llevar a RAM? La DB no me hace lento el proceso?
 - La data me favorece para los hilos?

