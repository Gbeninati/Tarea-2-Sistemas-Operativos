# Tarea-2-Sistemas-Operativos
Tarea 2 de sistemas operativos con la utilización de hebras.

Integrantes:
- Gianni Beninati
- David Monsalves

Explicación Problema 2:

Se pide ordenar un arreglo mediante la utilizacíon de hebras. 
Algoritmos conocidos para ordenamiento son: BubbleSort, QuickSort y MergeSort.
Para la solución del problema se utiliza el algoritmo de MergeSort, conocido
por su técnica de "Dividir y Conquistar". Nos aprovecharemos de esta "división"
para utilizar hebras para cada partición del arreglo inicial.

El programa se beneficia en el uso de hebras ya que, el algoritmo Merge Sort se centra
en dividir el arreglo en sub-arreglos y luego ordenarlos, y al tener dos hebras, se puede
dividir el arreglo en dos y que cada hebra ejecute de manera paralela Merge Sort para su mitad
de arreglo. Notar que dependiendo del tamaño del arreglo se podrían realizar más divisiones
y más hebras para una solución más eficiente.

Al usar Merge Sort en cada mitad por separado y que se ordenen de manera paralela,
el ordenamiento se hace muchísimo mas rápido, especialmente en arreglos con muchos
elementos.

Instrucciones de compilación:

- Abrir el terminal en el directorio en que se encuentra el archivo.
- Escribir comando: make.