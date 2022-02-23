package Projeto1;

import java.util.concurrent.Semaphore;

public class Main{
    public static void main(String[] args) {
        FilaVenda filaVenda = new FilaVenda(100);
        Semaphore mutexVenda = new Semaphore(1);
        Semaphore limiteFilaVenda = new Semaphore(100);

        FilaEntrega filaEntrega = new FilaEntrega(100);
        Semaphore mutexEntrega = new Semaphore(1);
        Semaphore limiteFilaEntrega = new Semaphore(100);

        Semaphore sVendas = new Semaphore(0);
        Semaphore sEntregas = new Semaphore(0);

        Loja l1 = new Loja("A",filaVenda,mutexVenda,sVendas,limiteFilaVenda);
        Loja l2 = new Loja("B",filaVenda,mutexVenda,sVendas,limiteFilaVenda);
        Loja l3 = new Loja("C",filaVenda,mutexVenda,sVendas,limiteFilaVenda);
        Loja l4 = new Loja("D",filaVenda,mutexVenda,sVendas,limiteFilaVenda);
        Loja l5 = new Loja("E",filaVenda,mutexVenda,sVendas,limiteFilaVenda);
        Loja l6 = new Loja("F",filaVenda,mutexVenda,sVendas,limiteFilaVenda);
        Loja l7 = new Loja("G",filaVenda,mutexVenda,sVendas,limiteFilaVenda);
        Loja l8 = new Loja("H",filaVenda,mutexVenda,sVendas,limiteFilaVenda);

        Fabricante f1 = new Fabricante("A",filaVenda,mutexVenda,sVendas,limiteFilaVenda,filaEntrega,mutexEntrega,sEntregas,limiteFilaEntrega,4);
        Fabricante f2 = new Fabricante("B",filaVenda,mutexVenda,sVendas,limiteFilaVenda,filaEntrega,mutexEntrega,sEntregas,limiteFilaEntrega,1);
        Fabricante f3 = new Fabricante("C",filaVenda,mutexVenda,sVendas,limiteFilaVenda,filaEntrega,mutexEntrega,sEntregas,limiteFilaEntrega,4);
        Fabricante f4 = new Fabricante("D",filaVenda,mutexVenda,sVendas,limiteFilaVenda,filaEntrega,mutexEntrega,sEntregas,limiteFilaEntrega,4);

        Transportadora t1 = new Transportadora("A",filaEntrega,mutexEntrega,sEntregas,limiteFilaEntrega,10);
        Transportadora t2 = new Transportadora("B",filaEntrega,mutexEntrega,sEntregas,limiteFilaEntrega,20);

        l1.start();
        l2.start();
        l3.start();
        l4.start();
        l5.start();
        l6.start();
        l7.start();
        l8.start();

        f1.start();
        f2.start();
        f3.start();
        f4.start();

        t1.start();
        t2.start();
    }
}