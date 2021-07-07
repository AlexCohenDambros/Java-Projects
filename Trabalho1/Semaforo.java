package Trabalho1;

public class Semaforo {
	public int cor = 2;

    public void MudaProximaCor(){
        if (cor == 0)
            cor = 1;

        else if (cor == 1)
            cor = 2;

        else if(cor == 2)
            cor = 0;
    }

    public void MudaCorFixa(int corFixa){
        cor = corFixa;
    }

    public int MostraCor(){
        return cor;
    }
}
