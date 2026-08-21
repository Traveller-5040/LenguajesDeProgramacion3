def sumarArreglo(arreglo):
    suma = 0
    for num in arreglo:
        suma += num

    return suma

numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
print("La suma de los numeros del vector es ->", sumarArreglo(numeros))
