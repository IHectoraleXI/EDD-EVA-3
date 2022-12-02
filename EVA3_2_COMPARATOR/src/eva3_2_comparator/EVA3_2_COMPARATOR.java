package eva3_2_comparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class EVA3_2_COMPARATOR {
    
    public static void main(String[] args) {
        LinkedList<Integer> miLista = new LinkedList();
        miLista.add((int)(Math.random() * 100));
        miLista.add((int)(Math.random() * 100));
        miLista.add((int)(Math.random() * 100));
        miLista.add((int)(Math.random() * 100));
        miLista.add((int)(Math.random() * 100));
        miLista.add((int)(Math.random() * 100));
        miLista.add((int)(Math.random() * 100));
        System.out.println(miLista);
        //Comparator es una interfaz.
        Comparator ordenar = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer val1 = (Integer)o1;
                Integer val2 = (Integer)o2;
                //menor a mayor
                return val1 - val2;
                //mayor a menor
                //return val2 - val1;
            }
        };
        miLista.sort(ordenar);
        System.out.println(miLista);
        //--------------------------
        LinkedList<Persona> listaPersonas = new <Persona>LinkedList();
        listaPersonas.add(new Persona("America","Chavarria","Monge",54,100.0));
        listaPersonas.add(new Persona("Rocio","Gardea","Gardea",35,100.0));
        listaPersonas.add(new Persona("Yahir","Quezada","Romero",24,100.0));
        listaPersonas.add(new Persona("Paulina","Villegas","Trevizo",38,100.0));
        listaPersonas.add(new Persona("Pepe","Ramirez","Romero",43,100.0));
        listaPersonas.add(new Persona("Fanny","Hernandez","Meraz",29,100.0));
        
        for (Iterator<Persona> iterator = listaPersonas.iterator(); iterator.hasNext; i++) {
             Persona perso = iterator.next();
             System.out.println(perso.getNombre());
        }
    }
    
    class Persona {
        private String nombre;
        private String paterno;
        private String materno;
        private int edad;
        private double salario;

        public Persona(String nombre, String paterno, String materno, int edad, double salario) {
            this.nombre = nombre;
            this.paterno = paterno;
            this.materno = materno;
            this.edad = edad;
            this.salario = salario;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getPaterno() {
            return paterno;
        }

        public void setPaterno(String paterno) {
            this.paterno = paterno;
        }

        public String getMaterno() {
            return materno;
        }

        public void setMaterno(String materno) {
            this.materno = materno;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }
        
        
    }
}
