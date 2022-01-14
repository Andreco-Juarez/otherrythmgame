public class Nota {
    int alto, ancho;
    int radio=100;
    boolean block=false;
    //s a b c n f
    char ps='n';

    Nota(int alto, int ancho){
        this.alto=alto;
        this.ancho=ancho;
    }
    void avanzar(){
        alto+=2;
    }
}
