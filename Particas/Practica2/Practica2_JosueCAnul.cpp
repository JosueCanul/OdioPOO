#include <stdio.h>

struct racional {
private:
	int numerador;
	int denominador;
public:
	void imprimir();
	void asignar(int n, int d);
	racional sumarRacionales(racional b);
	racional multiplicarRacionales(racional b);
};

racional racional::sumarRacionales(racional b){
	racional r2;
	r2.numerador = (numerador * b.denominador) + (denominador * b.numerador);
	r2.denominador = denominador * b.denominador;
	return r2;
}

racional racional::multiplicarRacionales(racional b)
{
	racional r2;
	r2.numerador = numerador * b.numerador;
	r2.denominador = denominador * b.denominador;
	return r2;
}

void racional::imprimir() {
	printf("%d/",numerador);
	printf("%d",denominador);
};

void racional::asignar(int n, int d) {
	numerador= n;
	denominador=d;
};

int main() {
	racional r, x, Suma;
	r.asignar(1,2);
	x.asignar(1,4);
	r.multiplicarRacionales(x);
	r.imprimir();
} ///:~
