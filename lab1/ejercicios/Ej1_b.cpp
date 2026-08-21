#include <iostream>
#include <vector>

int sumarVector(std::vector<int> arreglo) {
    int suma = 0;
    for(int num : arreglo) { suma += num; }

    return suma;
}

int main() 
{
    std::vector<int> numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    std::cout << "La suma de los numeros del Vector es -> " << sumarVector(numeros) << std::endl;

    return 0;
}
